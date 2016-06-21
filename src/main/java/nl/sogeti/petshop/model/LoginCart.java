package nl.sogeti.petshop.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LoginCart extends HasGeneratedId {

    @OneToOne(fetch = FetchType.EAGER)
    private Account owner;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "LOGINCARTRODUCTS", joinColumns = { @JoinColumn(name = "ID") })
    private List<LoginCartItem> loginCartItems = new ArrayList<>();

    public LoginCart() {
        super();
    }

    public LoginCart(Account owner, List<LoginCartItem> loginCartItems) {
        super();
        this.owner = owner;
        this.loginCartItems = loginCartItems;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public List<LoginCartItem> getLoginCartItems() {
        return loginCartItems;
    }

    public void setLoginCartItems(List<LoginCartItem> loginCartItems) {
        this.loginCartItems = loginCartItems;
    }

    public void addLoginCartItems(LoginCartItem loginCartItems) {
        this.loginCartItems.add(loginCartItems);
    }

    @Override
    public String toString() {
        return "LoginCart [owner=" + owner + ", loginCartItems=" + loginCartItems + "]";
    }

}
