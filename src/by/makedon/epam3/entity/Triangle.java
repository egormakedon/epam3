package by.makedon.epam1.entity;

import by.makedon.epam1.action.DotAction;
import by.makedon.epam1.exception.WrongDataException;
import by.makedon.epam1.validator.TriangleValidator;
import by.makedon.epam1.validator.TriangleIndexValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Triangle {
    private Dot[] dots;
    private final int DOT_AMOUNT = 3;
    static Logger logger = LogManager.getLogger(Triangle.class);

    public Triangle(Dot dot1, Dot dot2, Dot dot3) {
        TriangleValidator triangleValidator = new TriangleValidator();
        try {
            if(triangleValidator.dotsValidation(dot1, dot2, dot3)) {
                dots = new Dot[DOT_AMOUNT];
                dots[0] = dot1;
                dots[1] = dot2;
                dots[2] = dot3;
                logger.log(Level.INFO, this.toString() + " create successfully");
            }
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }
    }
    public Triangle(Dot[] dots) {
        TriangleValidator triangleValidator = new TriangleValidator();
        try {
            if(triangleValidator.dotsValidation(dots)) {
                this.dots = new Dot[DOT_AMOUNT];
                this.dots[0] = dots[0];
                this.dots[1] = dots[1];
                this.dots[2] = dots[2];
                logger.log(Level.INFO, this.toString() + " create successfully");
            }
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }
    }

    public void set(Dot dot1, Dot dot2, Dot dot3) {
        TriangleValidator triangleValidator = new TriangleValidator();
        try {
            if(triangleValidator.dotsValidation(dot1, dot2, dot3)) {
                dots[0] = dot1;
                dots[1] = dot2;
                dots[2] = dot3;
                logger.log(Level.INFO, this.toString() + " create successfully");
            }
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }
    }
    public void set(Dot[] dots) {
        TriangleValidator triangleValidator = new TriangleValidator();
        try {
            if(triangleValidator.dotsValidation(dots)) {
                    this.dots[0] = dots[0];
                    this.dots[1] = dots[1];
                    this.dots[2] = dots[2];
                    logger.log(Level.INFO, this.toString() + " create successfully");
            }
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }
    }

    public Dot getDot(int index) throws WrongDataException {
        TriangleIndexValidator triangleIndexValidator = new TriangleIndexValidator();
        try {
            if (triangleIndexValidator.indexValidation(index)) {
                return dots[index];
            }
        } catch (WrongDataException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        }
        return null;
    }

    public boolean isRect() {
        DotAction dotAction = new DotAction();

        return (dotAction.isRectangle(dots[1], dots[0], dots[2]) ||
                dotAction.isRectangle(dots[0], dots[1], dots[2]) ||
                dotAction.isRectangle(dots[1], dots[2], dots[0]));
    }

    @Override
    public String toString() {
        return dots[0].toString() + " " + dots[1].toString() + " " + dots[2].toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (DOT_AMOUNT != triangle.DOT_AMOUNT) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dots, triangle.dots);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dots);
        result = 31 * result + DOT_AMOUNT;
        return result;
    }
}