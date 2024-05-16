import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final Float price;


    public BunTest(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getBunData(){
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 1.5f},
                {"Б", 2.0f},
                {"булкааааааааааааааааааааааааааааааааааааааааааааааааааааа", 2.5f},
                {null, 3.0f},
                {"Спецсимволы!@#$%^&*()", 3.5f},
                {"", 4.0f},
                {"Флюоресцентная булка R2-D3", -2.5f},
                {"Флюоресцентная булка R2-D3", 0.01f},
                {"Флюоресцентная булка R2-D3", 4356439857345.87689678f},
                {"Краторная булка N-200i", 0f}
        };
    }

    @Test
    public void testBunGetName() {
        Bun bun = new Bun(name, price);
        assertEquals("Значение теста testBunGetName не совпадают", name, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Значение теста testBunGetPrice не совпадают", price, bun.getPrice(), 0);
    }
}