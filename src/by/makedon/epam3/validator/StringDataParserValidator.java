package by.makedon.epam3.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDataParserValidator {
    public boolean validation(String stringData) {
        final String FIND_DOTS_CORDINATES_FOR_TRIANGLE = "(-*)\\d{1,}.\\d{1,}\\s" +
                                                         "(-*)\\d{1,}.\\d{1,}\\s" +
                                                         "(-*)\\d{1,}.\\d{1,}\\s" +
                                                         "(-*)\\d{1,}.\\d{1,}\\s" +
                                                         "(-*)\\d{1,}.\\d{1,}\\s" +
                                                         "(-*)\\d{1,}.\\d{1,}";
        Pattern pattern = Pattern.compile(FIND_DOTS_CORDINATES_FOR_TRIANGLE);
        Matcher matcher = pattern.matcher(stringData);
        return matcher.matches();
    }
}