package by.makedon.epam3.validator;

import by.makedon.epam3.exception.WrongDataException;

public class TriangleIndexValidator {
    public boolean indexValidation(int index) throws WrongDataException {
        final int DOT_AMOUNT = 3;
        if (index >= 0 && index < DOT_AMOUNT) {
            return true;
        } else if (index < 0) {
            throw new WrongDataException("index out of range: less than 0");
        } else {
            throw new WrongDataException("index out of range: bigger than 2");
        }
    }
}