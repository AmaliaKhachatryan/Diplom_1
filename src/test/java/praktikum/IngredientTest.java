package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType expectedType;
    private String expectedName;
    private float expectedPrice;

    public IngredientTest(Ingredient ingredient, IngredientType expectedType, String expectedName, float expectedPrise) {
        this.ingredient = ingredient;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrise;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {new Ingredient(SAUCE, "hot sauce", 100), SAUCE, "hot sauce", 100},
                {new Ingredient(SAUCE, "sour cream", 200), SAUCE, "sour cream", 200},
                {new Ingredient(SAUCE, "$Бесплатный соус$", 0), SAUCE, "$Бесплатный соус$", 0},
                {new Ingredient(SAUCE, "Сырный соус", 150), SAUCE, "Сырный соус", 150},
                {new Ingredient(SAUCE, "Соевый соус", 10.5f), SAUCE, "Соевый соус", 10.5f},
                {new Ingredient(SAUCE, "Просроченный соус", -20.9f), SAUCE, "Просроченный соус", -20.9f},
                {new Ingredient(FILLING, "dinosaur", 200), FILLING, "dinosaur", 200},
                {new Ingredient(FILLING, "sausage", 300), FILLING, "sausage", 300},
                {new Ingredient(FILLING, "cutlet", 99.99f), FILLING, "cutlet", 99.99f},
                {new Ingredient(FILLING, "бекон", 20), FILLING, "бекон", 20},
                {new Ingredient(FILLING, " салат ", 100), FILLING, " салат ", 100},
                {new Ingredient(FILLING, "$Бесплатная начинка$", 0), FILLING, "$Бесплатная начинка$", 0},
        };
    }

    @Test
    public void ingredientTest() {
        Assert.assertEquals(expectedType, ingredient.getType());
        Assert.assertEquals(expectedName, ingredient.getName());
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0.0f);

    }
}