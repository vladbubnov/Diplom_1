import praktikum.Bun;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Burger;
import org.mockito.Mockito;
import praktikum.Ingredient;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Установленно неверное название и цена булочки", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals("Ингредиент не добавлен", 1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ингредиент не удален", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(FILLING, "sausage", 300));
        burger.moveIngredient(0, 1);
        String expectedIngredientName = "hot sauce";
        assertEquals("Ингредиент перемещен", expectedIngredientName, burger.ingredients.get(1).name);
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float expectedPrice = 300F;
        assertEquals("Значение стоимости не совпадает", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient1.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("cutlet");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient1.getPrice()).thenReturn(100F);
        String expectedReceipt =
                "(==== black bun ====)\r\n= sauce hot sauce =\r\n= filling cutlet =\r\n(==== black bun ====)\r\n\r\nPrice: 400,000000\r\n";
        assertEquals("Рецепт бургера не совпадает", expectedReceipt, burger.getReceipt());
    }
}