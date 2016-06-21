package nl.sogeti.petshop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Name implements Serializable {

    private String firstName;

    private String insertion;

    private String lastName;

    public Name() {
        super();
    }

    public Name(String firstName, String insertion, String lastName) {
        super();
        this.firstName = firstName;
        this.insertion = insertion;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Name [firstName=" + firstName + ", insertion=" + insertion + ", lastName=" + lastName + "]";
    }

}
