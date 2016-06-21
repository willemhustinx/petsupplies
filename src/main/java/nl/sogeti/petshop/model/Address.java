package nl.sogeti.petshop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address implements Serializable {

    @NotNull
    private String address;

    @NotNull
    private String addressNumber;

    private String addressInsertion;

    @NotNull
    private String postalCode;

    @NotNull
    private String city;

    public Address() {
        super();
    }

    public Address(String address, String addressNumber, String addressInsertion, String postalCode, String city) {
        super();
        this.address = address;
        this.addressNumber = addressNumber;
        this.addressInsertion = addressInsertion;
        this.postalCode = postalCode;
        this.city = city;
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

    @Override
    public String toString() {
        return "Address [address=" + address + ", addressNumber=" + addressNumber + ", addressInsertion="
                + addressInsertion + ", postalCode=" + postalCode + ", city=" + city + "]";
    }

}
