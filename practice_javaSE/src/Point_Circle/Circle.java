package Point_Circle;

public class Circle {
    private Point Center;
    private double r;
    Circle(){   //初始化值
        this.Center=new Point();
        this.Center.setX(0);
        this.Center.setY(0);
    }
    public boolean check(double r){
        return r>0;
    }
    public double getR(){    //返回半径
        if(check(this.r)){
            return r;
        }
        else{
            System.out.println("半径设置有误");
        }
        return 0;
    }
    public Point getCenter(){   //放回圆的圆心
        Point new_point=new Point();
        if(check(this.r)) {
            return this.Center;
        }
        else{
            System.out.println("半径设置有误");
        }
        return new_point;
    }
    public double getArea(){   //返回圆的面积
        if(check(this.r)){
            return Math.PI*r*r;
        }
        return 0;
    }
    public void setR(double r){   //设置半径
        if(r<0){
            System.out.println("半径设置有误!");
            return;
        }
        this.r=r;
    }
    public void setCenter(Point center){     //设置圆心
        this.Center.setX(center.getX());
        this.Center.setY(center.getY());
    }
    public Circle My_clone(){   //相当于深拷贝,新开辟了一个内存空间
        Circle new_circle=new Circle();
        if(check(this.r)){
            new_circle.setCenter(this.getCenter());
            new_circle.setR(this.getR());
            return new_circle;
        }
        else{
            System.out.println("半径设置有误!");
        }
        return new_circle;
    }
}
