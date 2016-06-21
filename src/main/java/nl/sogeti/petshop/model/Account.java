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
import javax.persistence.Embedded;
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
    @Embedded
    private Name name;

    @NotNull
    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @NotNull
    private Boolean activated;

    public Account() {
        super();
    }

    public Account(String email, String password, Name name, Address address) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public String createHash() {
        String stringToEncrypt = email + "-" + password;

        String encryptedString = "";
        String base64encodedString = null;

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
        return "Account [email=" + email + ", password=" + password + ", name=" + name + ", address=" + address
                + ", roles=" + roles + ", activated=" + activated + "]";
    }

}
