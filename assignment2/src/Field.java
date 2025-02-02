import java.awt.Color;

public class Field {
    private Color color;
    private int number;

    public Field() {
        color = null;
        number = 0;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int increaseNumber() {return ++number;}
}
