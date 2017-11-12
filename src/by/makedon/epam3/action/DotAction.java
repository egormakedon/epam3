package by.makedon.epam3.action;

import by.makedon.epam3.entity.Dot;

public class DotAction {
    public double calculateDistance(Dot dot1, Dot dot2) {
        return Math.hypot(dot1.getX() - dot2.getX(), dot1.getY() - dot2.getY());
    }

    public boolean isRectangle(Dot dot1, Dot dot2, Dot dot3) {
        final int ZERO = 0;

        double vx1 = dot2.getX() - dot1.getX();
        double vy1 = dot2.getY() - dot1.getY();

        double vx2 = dot3.getX() - dot2.getX();
        double vy2 = dot3.getY() - dot2.getY();

        return  (vx1*vx2 + vy1*vy2 == ZERO);
    }
}