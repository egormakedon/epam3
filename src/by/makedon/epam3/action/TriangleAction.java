package by.makedon.epam3.action;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;
import by.makedon.epam3.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleAction {
    static Logger logger = LogManager.getLogger(TriangleAction.class);

    public double calculateArea(Triangle triangle) {
        int index = 0;
        Dot dot1 = null;
        try {
            dot1 = triangle.getDot(index);
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }

        index = 1;
        Dot dot2 = null;
        try {
            dot2 = triangle.getDot(index);
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }

        index = 2;
        Dot dot3 = null;
        try {
            dot3 = triangle.getDot(index);
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }

        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistance(dot1, dot2);
        double side2 = dotAction.calculateDistance(dot2, dot3);
        double side3 = dotAction.calculateDistance(dot1, dot3);
        double halfPerimeter = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));

        logger.log(Level.INFO, "triangle " + triangle.toString() + " has area " + area);
        return area;
    }

    public double calculatePerimeter(Triangle triangle) {
        int index = 0;
        Dot dot1 = null;
        try {
            dot1 = triangle.getDot(index);
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }

        index = 1;
        Dot dot2 = null;
        try {
            dot2 = triangle.getDot(index);
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }

        index = 2;
        Dot dot3 = null;
        try {
            dot3 = triangle.getDot(index);
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }

        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistance(dot1, dot2);
        double side2 = dotAction.calculateDistance(dot2, dot3);
        double side3 = dotAction.calculateDistance(dot1, dot3);
        double perimeter = side1 + side2 + side3;

        logger.log(Level.INFO, "triangle " + triangle.toString() + " has perimeter " + perimeter);
        return perimeter;
    }
}