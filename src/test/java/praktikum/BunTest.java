package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    String expectedName;
    float expectedPrice;

    public BunTest(Bun bun, String expectedName, float expectedPrice) {
        this.bun = bun;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {new Bun("Черный хлеб", 20.05f), "Черный хлеб", 20.05f},
                {new Bun("Черствый хлеб", -12), "Черствый хлеб", -12},
                {new Bun("$Бесплатный$", 0), "$Бесплатный$", 0},
                {new Bun(" red", 1000), " red", 1000},
                {new Bun("black bun", 99.88f), "black bun", 99.88f},
                {new Bun("white bun", 200), "white bun", 200},
                {new Bun("red bun", 300), "red bun", 300}
        };
    }
    @Test
    public void bunTest(){
        Assert.assertEquals(expectedName,bun.getName());
        Assert.assertEquals(expectedPrice,bun.getPrice(),0.0);
    }
}