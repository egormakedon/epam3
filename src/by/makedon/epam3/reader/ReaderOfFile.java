package by.makedon.epam1.reader;

import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.WrongDataException;
import by.makedon.epam1.exception.IncorrectFileException;
import by.makedon.epam1.parser.StringDataParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderOfFile {
    static Logger logger = LogManager.getLogger(ReaderOfFile.class);

    public boolean isFileExist(String filename) throws IncorrectFileException {
        File file = new File(filename);
        if (file.exists()) {
            logger.log(Level.INFO,filename + " has found");
            return true;
        } else {
            return false;
        }
    }

    public List<Dot[]> readFileData(String filename, String delimiter) throws IncorrectFileException {
        if (isFileExist(filename)) {
            Scanner scanner = null;
            List<Dot[]> fileDataList = new ArrayList<>();
            try {
                scanner = new Scanner(new File(filename));
                StringDataParser stringDataParser = new StringDataParser();

                while (scanner.hasNextLine()) {
                    String stringData = scanner.nextLine();
                    try {
                        if (stringDataParser.isParseString(stringData, delimiter)) {
                            fileDataList.add(stringDataParser.takeDots(stringData, delimiter));
                            logger.log(Level.INFO, stringData + " has read correct");
                        }
                    } catch (WrongDataException exception) {
                        logger.log(Level.ERROR, exception.getMessage());
                    }
                }
            } catch (FileNotFoundException exception) {
                logger.log(Level.WARN, "unknown error");
            } finally {
                if (scanner != null) scanner.close();
            }

            if (!fileDataList.isEmpty()) {
                return fileDataList;
            } else {
                throw new IncorrectFileException("filename hasn't correct data");
            }

        } else {
            throw new IncorrectFileException(filename + " hasn't found");
        }
    }
}