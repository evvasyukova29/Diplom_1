import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Название булочки: {0}, Цена булочки: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Правильная", 150F},
                {"Съедобная", Float.MAX_VALUE},
                {"Негативная", -150F},
                {"Бесплатная", 0F},
                {"", 150F},
                {"        ", 150F},
                {"!@#$%^&*()", 150F}
        };
    }
    @Before
    public void createBun() {
        bun = new Bun(name, price);
    }
    @Test
    public void correctNameBun() {
        Assert.assertEquals("Название булочки такое же, как при создании", name, bun.getName());
    }
    @Test
    public void correctPriceBun() {
        Assert.assertEquals("Цена булочки совпадает до полутысячных", price, bun.getPrice(), 0.005);
    }
}
