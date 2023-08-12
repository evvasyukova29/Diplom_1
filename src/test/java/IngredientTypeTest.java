import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String typeName;
    private final boolean compositionBurger;

    public IngredientTypeTest(String typeName, boolean compositionBurger) {
        this.typeName = typeName;
        this.compositionBurger = compositionBurger;
    }
    @Parameterized.Parameters(name = "Тип ингредиента: {0}, Входит в состав бургера: {1}")
    public static Object[][] getTypes() {
        return new Object[][] {
                {"FILLING", true},
                {"SAUCE", true},
                {"CREAM", false},
                {"FRUITS", false}
        };
    }
    @Test
    public void correctTypeIngredientForBurger() {
        if (compositionBurger) {
            Assert.assertNotNull("Правильный тип ингредиентов для бургеров:", IngredientType.valueOf(typeName));
        } else {
            Assert.assertThrows("Неправильный тип ингредиентов для бургеров:", IllegalArgumentException.class, () -> IngredientType.valueOf(typeName));
        }
    }
}