package Object;

public class Food {
    private String name;
    private double price;
    private String descreption;

    public Food(String name, double price, String descreption) {
        this.name = name;
        this.price = price;
        this.descreption = descreption;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
