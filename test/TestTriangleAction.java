import by.makedon.epam3.action.TriangleAction;
import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;
import by.makedon.epam3.exception.WrongDataException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTriangleAction {
    private TriangleAction triangleAction;
    @BeforeTest
    public void set() {
        triangleAction = new TriangleAction();
    }

    @AfterTest
    public void destr() {
        triangleAction = null;
    }

    @Test
    public void calculateAreaTest() throws WrongDataException {
        Triangle triangle = new Triangle(new Dot(0,0), new Dot(0,10), new Dot(20,0));
        double area = triangleAction.calculateArea(triangle);
        double excepted = 100;
        Assert.assertEquals(area, excepted, 0.00001);
    }

    @Test
    public void calculateAreaNotEqTest() throws WrongDataException {
        Triangle triangle = new Triangle(new Dot(-100,20), new Dot(1000,10), new Dot(20,0));
        double area = triangleAction.calculateArea(triangle);
        double excepted = 100;
        Assert.assertNotEquals(area, excepted, 0.00001);
    }

    @Test
    public void calculatePerimeterTest() throws WrongDataException {
        Triangle triangle = new Triangle(new Dot(10, 10), new Dot(1, 5), new Dot(1,0));
        double perimeter = triangleAction.calculatePerimeter(triangle);
        double excepted = 28.74925418806071;
        Assert.assertEquals(excepted, perimeter, 0.00001);
    }

    @Test
    public void calculatePerimeterNotEqTest() throws WrongDataException {
        Triangle triangle = new Triangle(new Dot(10, 10), new Dot(1, 5), new Dot(1,0));
        double perimeter = triangleAction.calculatePerimeter(triangle);
        double excepted = 250;
        Assert.assertNotEquals(excepted, perimeter, 0.00001);
    }
}
