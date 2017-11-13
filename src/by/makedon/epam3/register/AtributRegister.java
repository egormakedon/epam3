package by.makedon.epam3.register;

import by.makedon.epam3.action.TriangleAction;
import by.makedon.epam3.entity.Triangle;
import by.makedon.epam3.exception.WrongDataException;

import java.util.*;

public class AtributRegister implements Observer {
    private Map<Triangle, List<Double>> atributMap = new HashMap<Triangle, List<Double>>();

    private AtributRegister() {}

    private static class SingletonHolder {
        private final static AtributRegister INSTANCE = new AtributRegister();
    }

    public static AtributRegister getInstance() {
        return AtributRegister.SingletonHolder.INSTANCE;
    }

    public void add(Triangle triangle) {
        triangle.addObserver(this);
        atributMap.put(triangle, calculateCharacters(triangle));
    }

    public List<Double> get(Triangle triangle) throws WrongDataException {
        for (Map.Entry<Triangle, List<Double>> entry : atributMap.entrySet()) {
            if (entry.getKey() == triangle) {
                return entry.getValue();
            }
        }
        throw new WrongDataException(triangle.toString() + " hasn't found in atributRegister");
    }

    @Override
    public void update(Observable o, Object arg) {
        Triangle changedTriangle = (Triangle) o;
        List<Double> characters = null;
        for (Map.Entry<Triangle, List<Double>> entry : atributMap.entrySet()) {
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