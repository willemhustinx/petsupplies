package nl.sogeti.petshop.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Account implements Serializable {

    @Column(unique = true)
    @NotNull
    @Id
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    private String insertion;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String addressNumber;

    private String addressInsertion;

    @NotNull
    private String postalCode;

    @NotNull
    private String city;

    @NotNull
    private Boolean activated;

    public Account(String email, String password, String firstName, String insertion, String lastName, String address,
            String addressNumber, String addressInsertion, String postalCode, String city) {
        super();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.insertion = insertion;
        this.lastName = lastName;
        this.address = address;
        this.addressNumber = addressNumber;
        this.addressInsertion = addressInsertion;
        this.postalCode = postalCode;
        this.city = city;
        this.activated = false;
    }

    public Account() {
        // default constructor
    }

    public String createHash() {
        String stringToEncrypt = email + "-" + password;

        String encryptedString = "";
        String base64encodedString = "";

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(stringToEncrypt.getBytes());
            encryptedString = new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(Account.class.getName()).log(Level.WARNING, "Cannot digest hash", e);
        }

        try {
            base64encodedString = Base64.getEncoder().encodeToString(encryptedString.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(Account.class.getName()).log(Level.WARNING, "Cannot encode password", e);
        }

        base64encodedString = base64encodedString.replace('/', 'W');
        base64encodedString = base64encodedString.replace('=', 'W');

        return base64encodedString;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "Account [email=" + email + ", password=" + password + ", firstName=" + firstName + ", insertion="
                + insertion + ", roles=" + roles + ", lastName=" + lastName + ", address=" + address
                + ", addressNumber=" + addressNumber + ", addressInsertion=" + addressInsertion + ", postalCode="
                + postalCode + ", city=" + city + ", activated=" + activated + "]";
    }
}
