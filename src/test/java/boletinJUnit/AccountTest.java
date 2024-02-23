package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("Juanfran", 123456, 1000.0f);
    }


    @Test
    public void testDepositValidAmount() {
        assertTrue(account.deposit(500.0f));
        assertEquals(1500.0f, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        assertFalse(account.deposit(-500.0f));
        assertEquals(1000.0f, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        assertTrue(account.withdraw(500.0f, 0.0f));
        assertEquals(500.0f, account.getBalance());
        assertFalse(account.withdraw(-500.0f, 0.0f));
        assertFalse(account.withdraw(1500.0f, 0.0f));
        assertFalse(account.withdraw(-500.0f, 20.0f));
    }

    @Test
    public void testAddInterest() {
        account.addInterest();
        assertEquals(1045.0f, account.getBalance(), 0.001);
    }

    @Test
    public void testConstructor() {
        assertEquals("Juanfran", account.name);
        assertEquals(123456, account.getAccountNumber());
        assertEquals(1000.0f, account.getBalance());
    }

    @Test
    public void testWithdrawInvalidAmount() {
        assertFalse(account.withdraw(-500.0f, 20.0f));
        assertEquals(1000.0f, account.getBalance());
    }

    @Test
    public void testWithdrawExceedingBalanceWithFee() {
        assertFalse(account.withdraw(1500.0f, 20.0f));
        assertEquals(1000.0f, account.getBalance());
    }

    @Test
    public void testToString() {
        String expected = "123456\tJuanfran\t" + NumberFormat.getCurrencyInstance().format(1000.0f);
        assertEquals(expected, account.toString());    }
}