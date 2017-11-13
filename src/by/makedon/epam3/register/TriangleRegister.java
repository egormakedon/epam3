package by.makedon.epam3.register;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;

import java.util.*;

public class TriangleRegister {
    private List<Triangle> triangleList = new ArrayList<Triangle>();

    private TriangleRegister() {}

    private static class SingletonHolder {
        private final static TriangleRegister INSTANCE = new TriangleRegister();
    }

    public static TriangleRegister getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void add(Dot[] dots) {
        Triangle triangle = new Triangle(dots);
        triangleList.add(triangle);
    }

    public int size() {
        return triangleList.size();
    }

    public Triangle get(int index) {
        return triangleList.get(index);
    }
}
