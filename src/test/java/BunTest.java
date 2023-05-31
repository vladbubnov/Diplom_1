import praktikum.Bun;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun = new Bun("Dallas", 5F);

    @Test
    public void testBunGetName() {
        String expectedBunName = "Dallas";
        assertEquals("Значение теста testBunGetName не совпадают", expectedBunName, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        float expectedBunPrice = 5F;
        assertEquals("Значение теста testBunGetPrice не совпадают", expectedBunPrice, bun.getPrice(), 0);
    }
}