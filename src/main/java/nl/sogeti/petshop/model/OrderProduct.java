package nl.sogeti.petshop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProduct implements Serializable {

    private String name;

    private double price;

    private int amount;

    public OrderProduct() {
        // default constructor
    }

    public OrderProduct(String name, double price, int amount) {
        super();
        this.name = name;
        this.price = price;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderProduct [name=" + name + ", price=" + price + ", amount=" + amount + "]";
    }

}