package by.makedon.epam3.register;

import by.makedon.epam3.action.TriangleAction;
import by.makedon.epam3.entity.Triangle;

import java.util.*;

public class TriangleRegister implements Observer{
    private Map<Triangle, List<Double>> mapRegister = new HashMap<Triangle, List<Double>>();

    private TriangleRegister() {}

    private static class SingletonHolder {
        private final static TriangleRegister INSTANCE = new TriangleRegister();
    }
    public static TriangleRegister getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void update(Observable o, Object arg) {
        Triangle changedTriangle = (Triangle) o;
        List<Double> characters = null;
        for (Map.Entry<Triangle, List<Double>> entry : mapRegister.entrySet()) {
            if (entry.getKey() == changedTriangle) {
                characters = entry.getValue();
                break;
            }
        }
        List<Double> newCharacters = calculateCharacters(changedTriangle);
        characters.clear();
        characters.add(newCharacters.get(0));
        characters.add(newCharacters.get(1));
    }

    public void add(Triangle triangle) {
        mapRegister.put(triangle, calculateCharacters(triangle));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Triangle, List<Double>> entry : mapRegister.entrySet()) {
            sb.append(entry.getKey().toString() + "     " + "area:" + entry.getValue().get(0) + "       perimeter:" + entry.getValue().get(1) + "\n");
        }
        return sb.toString();
    }

    private List<Double> calculateCharacters(Triangle triangle) {
        TriangleAction triangleAction = new TriangleAction();
        double area = triangleAction.calculateArea(triangle);
        double perimeter = triangleAction.calculatePerimeter(triangle);
        List<Double> characters = new ArrayList<Double>();
        characters.add(area);
        characters.add(perimeter);
        return characters;
    }
}
