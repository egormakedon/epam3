package by.makedon.epam3.validator;

import by.makedon.epam3.action.DotAction;
import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.exception.WrongDataException;

public class TriangleValidator {
    public boolean dotsValidation(Dot dot1, Dot dot2, Dot dot3) throws WrongDataException {
        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistance(dot1, dot2);
        double side2 = dotAction.calculateDistance(dot2, dot3);
        double side3 = dotAction.calculateDistance(dot1, dot3);
        boolean areDotsComposeTriangle = (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);

        if (areDotsComposeTriangle) {
            return true;
        } else {
            throw new WrongDataException(dot1.toString() + " " + dot2.toString() + " " + dot3.toString() + " don't compose triangle");
        }
    }

    public boolean dotsValidation(Dot[] dots) throws WrongDataException {
        final int DOT_AMOUNT = 3;
        final int length = dots.length;
        if (length == DOT_AMOUNT) {
            return dotsValidation(dots[0], dots[1], dots[2]);
        } else if (length < DOT_AMOUNT) {
            throw new WrongDataException("length of " + dots.toString() + " less than 3");
        } else {
            throw new WrongDataException("length of " + dots.toString() + " bigger than 3");
        }
    }
}