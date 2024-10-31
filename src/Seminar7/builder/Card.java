package Seminar7.builder;

import java.util.Arrays;

public class Card {
    String name;
    int price;
    int[] size;
    String colorFront;
    String colorBack;

    public void setColorFront(String colorFront) {
        this.colorFront = colorFront;
    }

    public void setColorBack(String colorBack) {
        this.colorBack = colorBack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + Arrays.toString(size) +
                ", colorFront='" + colorFront + '\'' +
                ", colorBack='" + colorBack + '\'' +
                '}';
    }
}
