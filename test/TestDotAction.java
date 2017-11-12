import by.makedon.epam3.action.DotAction;
import by.makedon.epam3.entity.Dot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDotAction {
    private DotAction dotAction;

    @BeforeTest
    public void set() {
        dotAction = new DotAction();
    }

    @AfterTest
    public void destr() {
        dotAction = null;
    }

    @Test
    public void calculateDistanceTest() {
        double result = dotAction.calculateDistance(new Dot(0, 0), new Dot(4, 3));
        double expected = 5;
        Assert.assertEquals(result, expected, 0.00001);
    }

    @Test
    public void calculateDistanceNotEqTest() {
        double result = dotAction.calculateDistance(new Dot(-1, -1), new Dot(4, 3));
        double expected = 5;
        Assert.assertNotEquals(result, expected, 0.00001);
    }

    @Test
    public void isRectangleTest() {
        boolean result = dotAction.isRectangle(new Dot(0, 5), new Dot(0, 0), new Dot(10, 0));
        Assert.assertTrue(result);
    }

    @Test
    public void isRectangleFalseTest() {
        boolean result = dotAction.isRectangle(new Dot(1, 5), new Dot(-1, 0), new Dot(10, 50));
        Assert.assertFalse(result);
    }
}