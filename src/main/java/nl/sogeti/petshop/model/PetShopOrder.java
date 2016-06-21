package nl.sogeti.petshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "PETSHOPORDER")
public class PetShopOrder extends HasGeneratedId {

    @NotNull
    @Embedded
    private Name name;

    @NotNull
    @Embedded
    private Address address;

    private String email;
    private String currency;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ORDERPRODUCTS", joinColumns = { @JoinColumn(name = "ID") })
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public PetShopOrder() {
        super();
    }

    public PetShopOrder(Name name, Address address, String email) {
        super();
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        this.orderProducts.add(orderProduct);
    }

    @Override
    public String toString() {
        return "PetShopOrder [name=" + name + ", address=" + address + ", email=" + email + ", currency=" + currency
                + ", orderProducts=" + orderProducts + "]";
    }

}