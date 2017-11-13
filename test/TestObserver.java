import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;
import by.makedon.epam3.exception.IncorrectFileException;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.reader.ReaderOfFile;
import by.makedon.epam3.register.AtributRegister;
import by.makedon.epam3.register.TriangleRegister;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestObserver {
    @Test
    public void observerTest() throws IncorrectFileException, WrongDataException {
        TriangleRegister triangleRegister = TriangleRegister.getInstance();
        final String FILENAME = "in/in.txt";
        ReaderOfFile reader = new ReaderOfFile();
        List<Dot[]> dotsList = reader.readFileData(FILENAME, " ");
        for (Dot[] dots : dotsList) {
            triangleRegister.add(dots);
        }

        AtributRegister atributRegister = AtributRegister.getInstance();
        for (int index = 0; index < triangleRegister.size(); index++) {
            Triangle triangle = triangleRegister.get(index);
            atributRegister.add(triangle);
        }

        Triangle triangle1 = triangleRegister.get(0);
        try {
            triangle1.replaceDot(new Dot(-100, -100), 0);
        } catch (WrongDataException e) {
            e.printStackTrace();
        }
        List<Double> atributs = atributRegister.get(triangle1);
        double exceptedArea = 253.00000000000244;
        double area = atributs.get(0);
        Assert.assertEquals(exceptedArea, area, 0.00001);
    }
}
