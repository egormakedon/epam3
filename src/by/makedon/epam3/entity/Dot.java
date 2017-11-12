package by.makedon.epam3.entity;

public class Dot {
    private double x;
    private double y;

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {

        this.x = x;
    }
    public void setY(double y) {

        this.y = y;
    }
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dot dot = (Dot) o;

        if (Double.compare(dot.x, x) != 0) return false;
        return Double.compare(dot.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}