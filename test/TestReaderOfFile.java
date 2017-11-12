import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.WrongDataException;
import by.makedon.epam1.exception.IncorrectFileException;
import by.makedon.epam1.reader.ReaderOfFile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestReaderOfFile {
    private ReaderOfFile rF;

    @BeforeTest
    public void set() {
        rF = new ReaderOfFile();
    }

    @AfterTest
    public void destr() {
        rF = null;
    }

    @Test
    public void fileExistTest() throws IncorrectFileException {
        String fileName = "in/in.txt";
        Assert.assertTrue(rF.isFileExist(fileName));
    }

    @Test
    public void fileNotExistTest() throws IncorrectFileException {
        String fileName = "thisFileNotExist.txt";
        Assert.assertFalse(rF.isFileExist(fileName));
    }

    @Test
    public void readFileTest() throws WrongDataException, IncorrectFileException {
        String fileName = "in/in.txt";
        List<Dot[]> result = rF.readFileData(fileName, " ");
        List<Dot[]> expectedList = new ArrayList<>();

        expectedList.add(new Dot[3]);
        expectedList.get(0)[0] = new Dot(0, 0);
        expectedList.get(0)[1] = new Dot(0, 2);
        expectedList.get(0)[2] = new Dot(3, 0);

        expectedList.add(new Dot[3]);
        expectedList.get(1)[0] = new Dot(-1, 0);
        expectedList.get(1)[1] = new Dot(2, 3);
        expectedList.get(1)[2] = new Dot(1, 4);

        expectedList.add(new Dot[3]);
        expectedList.get(2)[0] = new Dot(1, 0);
        expectedList.get(2)[1] = new Dot(1, 4);
        expectedList.get(2)[2] = new Dot(10, 0);

        expectedList.add(new Dot[3]);
        expectedList.get(3)[0] = new Dot(1, 1);
        expectedList.get(3)[1] = new Dot(2, 2);
        expectedList.get(3)[2] = new Dot(5, 1.5);

        expectedList.add(new Dot[3]);
        expectedList.get(4)[0] = new Dot(2, 3);
        expectedList.get(4)[1] = new Dot(3, 2);
        expectedList.get(4)[2] = new Dot(4, 5);

        Assert.assertEquals(result, expectedList);
    }
}
