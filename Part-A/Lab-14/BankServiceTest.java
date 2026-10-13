import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    
    void testAddAccount() {
        BankService bank = new BankService();
        bank.addAccount("Dhruti", 1000);

        assertEquals(1, bank.getCount());
    }

   
    void testInvalidAccount() {
        BankService bank = new BankService();

        assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(5, 100));
    }
}