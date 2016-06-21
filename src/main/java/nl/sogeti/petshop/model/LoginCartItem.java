package nl.sogeti.petshop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class LoginCartItem implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    private int amount;

    public LoginCartItem() {
        //empty constructor for hibernate
    }

    public LoginCartItem(Product product, int amount) {
        super();
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "LoginCartItem [product=" + product + ", amount=" + amount + "]";
    }

}