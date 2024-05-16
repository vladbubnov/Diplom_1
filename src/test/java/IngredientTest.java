import org.junit.Test;
import org.junit.Before;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: type = {0}, name = {1}, price = {2}")
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testIngredientGetPrice() {
        assertEquals("Значения теста testIngredientGetPrice не совпадают", price, ingredient.getPrice(), 0);
        }

    @Test
    public void testIngredientGetName(){
        assertEquals("Значения теста testIngredientGetName не совпадают", name, ingredient.getName());
    }

    @Test
    public void testIngredientGetType() {
        assertEquals("Значения теста testIngredientGetIngredientType не совпадают", type, ingredient.getType());
    }
}