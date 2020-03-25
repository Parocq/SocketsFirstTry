import java.io.Serializable;

public class Ring implements Serializable {
    private String title;
    private String color;
    private double price;

    public Ring(String title, String color, double price) {
        this.title = title;
        this.color = color;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
