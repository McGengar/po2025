import org.junit.Test;

import static org.junit.Assert.*;

public class CodingBatTest {
    CodingBat cB = new CodingBat();
    @Test
    public void sumDouble() {
        assertEquals(8, cB.sumDouble(2,6));
        assertEquals(8, cB.sumDouble(2,2));
    }

    @Test
    public void monkeyTrouble() {
        assertEquals(true, cB.monkeyTrouble(true,true));
    }

    @Test
    public void countEvens() {
        assertEquals(2,cB.countEvens(new int[]{2,3,5,4,1}));
    }

    @Test
    public void helloName() {
        assertEquals("Hello Marcin!", cB.helloName("Marcin"));
    }
}