import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;
import by.makedon.epam3.exception.WrongDataException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTriangle {
    @Test
    public void isTriangleRectTest() throws WrongDataException {
        Triangle triangle = new Triangle(new Dot(0,0), new Dot(0,20), new Dot(5,0));
        Assert.assertTrue(triangle.isRect());
    }

    @Test
    public void isTriangleNotRectTest() throws WrongDataException {
        Triangle triangle = new Triangle(new Dot(-20,0), new Dot(0,20), new Dot(5,0));
        Assert.assertFalse(triangle.isRect());
    }
}