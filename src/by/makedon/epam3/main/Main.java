package by.makedon.epam3.main;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;
import by.makedon.epam3.exception.IncorrectFileException;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.reader.ReaderOfFile;
import by.makedon.epam3.register.TriangleRegister;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IncorrectFileException {
        TriangleRegister triangleRegister = TriangleRegister.getInstance();

        final String FILENAME = "in/in.txt";
        ReaderOfFile reader = new ReaderOfFile();
        List<Dot[]> dotsList = reader.readFileData(FILENAME, " ");

        Triangle[] triangle = new Triangle[5];
        int index = 0;
        for (Dot[] dots : dotsList) {
            triangle[index] = new Triangle(dots);
            triangle[index].addObserver(triangleRegister);
            triangleRegister.add(triangle[index]);
            index++;
        }

        System.out.println("\n" + triangleRegister.toString());
        try {
            triangle[0].replaceDot(new Dot(-100, -100), 0);
            triangle[1].replaceDot(new Dot(25, 25), 1);
            triangle[2].replaceDot(new Dot(-42, 42), 2);
            triangle[3].set(new Dot(1,3), new Dot(42,42), new Dot(0, -1));
        } catch (WrongDataException e) {
            e.printStackTrace();
        }
        System.out.println(triangleRegister.toString());
    }
}
