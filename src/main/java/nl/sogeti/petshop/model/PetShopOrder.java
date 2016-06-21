package nl.sogeti.petshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "PETSHOPORDER")
public class PetShopOrder extends HasGeneratedId {

    private String firstName;
    private String insertion;
    private String lastName;
    private String address;
    private String addressNumber;
    private String addressInsertion;
    private String postalCode;
    private String city;
    private String email;
    private String currency;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ORDERPRODUCTS", joinColumns = { @JoinColumn(name = "ID") })
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public PetShopOrder() {
        // defualt constructor
    }

    public PetShopOrder(String firstName, String insertion, String lastName, String address, String addressNumber,
            String addressInsertion, String postalCode, String city, String email) {
        this.firstName = firstName;
        this.insertion = insertion;
        this.lastName = lastName;
        this.address = address;
        this.addressNumber = addressNumber;
        this.addressInsertion = addressInsertion;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressInsertion() {
        return addressInsertion;
    }

    public void setAddressInsertion(String addressInsertion) {
        this.addressInsertion = addressInsertion;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    @Override
    public String toString() {
        return "PetShopOrder [firstName=" + firstName + ", middleName=" + insertion + ", lastName=" + lastName
                + ", street=" + address + ", streetNumber=" + addressNumber + ", steetNumberAddition="
                + addressInsertion + ", postalCode=" + postalCode + ", city=" + city + ", email=" + email
                + ", orderProducts=" + orderProducts + "]";
    }

}