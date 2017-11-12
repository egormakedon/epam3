package by.makedon.epam3.parser;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.validator.StringDataParserValidator;
import by.makedon.epam3.validator.TriangleValidator;

public class StringDataParser {
    public boolean isParseString(String stringData, String delimiter) throws WrongDataException {
        StringDataParserValidator stringDataParserValidator = new StringDataParserValidator();
        if (stringDataParserValidator.validation(stringData)) {
            TriangleValidator triangleValidator = new TriangleValidator();
            return triangleValidator.dotsValidation(takeDots(stringData, delimiter));
        } else {
            throw new WrongDataException(stringData + " hasn't read: wrong parameters");
        }
    }

    public Dot[] takeDots(String stringData, String delimiter) throws WrongDataException {
        final int DOT_AMOUNT = 3;
        String[] strings = stringData.split(delimiter);
        if (strings.length == 6) {
            Dot[] dots = new Dot[DOT_AMOUNT];
            dots[0] = new Dot((Double.parseDouble(strings[0])), Double.parseDouble(strings[1]));
            dots[1] = new Dot((Double.parseDouble(strings[2])), Double.parseDouble(strings[3]));
            dots[2] = new Dot((Double.parseDouble(strings[4])), Double.parseDouble(strings[5]));
            return dots;
        } else {
            throw new WrongDataException("length of " + strings.toString() + " not equal " + DOT_AMOUNT);
        }
    }
}