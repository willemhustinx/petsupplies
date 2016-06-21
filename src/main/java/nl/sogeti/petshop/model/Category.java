package nl.sogeti.petshop.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

@Entity
public class Category extends HasGeneratedId {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "CATEGORYNAMES", joinColumns = { @JoinColumn(name = "ID") })
    @MapKeyColumn(name = "LANGUAGE")
    @Column(name = "VALUE")
    private Map<String, String> name = new HashMap<>();

    public Category() {
        // default constructor
    }

    public Category(Map<String, String> name) {
        super();
        this.name = name;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [name=" + name + "]";
    }
}
