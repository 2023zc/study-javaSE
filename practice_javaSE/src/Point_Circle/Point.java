package Point_Circle;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point My_clone() {    //相当于深拷贝,新开辟了一个内存空间
        Point new_point = new Point();
        new_point.setX(this.x);
        new_point.setY(this.y);
        return new_point;
    }
}
