import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.validator.TriangleValidator;
import by.makedon.epam3.validator.TriangleIndexValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTriangleValidator {
    private TriangleValidator triangleValidator;
    private TriangleIndexValidator triangleIndexValidator;

    @BeforeTest
    public void set() {
        triangleValidator = new TriangleValidator();
        triangleIndexValidator = new TriangleIndexValidator();
    }

    @AfterTest
    public void destr() {
        triangleValidator = null;
        triangleIndexValidator = null;
    }

    @Test
    public void isDotsComposeTriangleTest_1() throws WrongDataException {
        Assert.assertTrue(triangleValidator.dotsValidation(new Dot(0,0), new Dot(1.10,200), new Dot(-123,213.232)));
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void isDotsNotComposeTriangleTest_1() throws WrongDataException {
        triangleValidator.dotsValidation(new Dot(0,0), new Dot(1,1), new Dot(-1,-1));
    }

    @Test
    public void isDotsComposeTriangleTest_2() throws WrongDataException {
        Dot[] dots = new Dot[3];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(2,2);
        dots[2] = new Dot(22,100);
        Assert.assertTrue(triangleValidator.dotsValidation(dots));
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void isDotsNotComposeTriangleTest_2() throws WrongDataException {
        Dot[] dots = new Dot[3];
        dots[0] = new Dot(1,1);
        dots[1] = new Dot(2,2);
        dots[2] = new Dot(3,3);
        triangleValidator.dotsValidation(dots);
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationWrongTest1() throws WrongDataException {
        Dot[] dots = new Dot[4];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(1,2);
        dots[2] = new Dot(1,2);
        dots[3] = new Dot(1,2);
        triangleValidator.dotsValidation(dots);
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationWrongTest2() throws WrongDataException {
        Dot[] dots = new Dot[2];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(1,2);
        triangleValidator.dotsValidation(dots);
    }

    @Test
    public void validationIndexTest() throws WrongDataException {
        int index = 2;
        Assert.assertTrue(triangleIndexValidator.indexValidation(index));
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationIndexWrongTest1() throws WrongDataException {
        int index = 100;
        triangleIndexValidator.indexValidation(index);
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationIndexWrongTest2() throws WrongDataException {
        int index = -100;
        triangleIndexValidator.indexValidation(index);
    }
}