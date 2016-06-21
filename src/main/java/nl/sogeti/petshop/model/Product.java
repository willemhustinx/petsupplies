package nl.sogeti.petshop.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "PRODUCT")
@SQLDelete(sql = "UPDATE PRODUCT SET deleted = '1' WHERE id = ?")
// Filter added to retrieve only records that have not been soft deleted.
@Where(clause = "deleted <> '1'")
public class Product extends HasGeneratedId {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PRODUCTNAMES", joinColumns = { @JoinColumn(name = "ID") })
    @MapKeyColumn(name = "LANGUAGE")
    @Column(name = "VALUE")
    private Map<String, String> name = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PRODUCTDESCRIPTION", joinColumns = { @JoinColumn(name = "ID") })
    @MapKeyColumn(name = "LANGUAGE")
    @Column(name = "VALUE")
    private Map<String, String> description = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PRODUCTPRICE", joinColumns = { @JoinColumn(name = "ID") })
    @MapKeyColumn(name = "CURRENCY")
    @Column(name = "VALUE")
    private Map<String, Double> price = new HashMap<>();

    @ManyToOne
    private Category category;

    private char deleted;

    public Product() {
        super();
    }

    public Product(Map<String, String> name, Map<String, String> description, Map<String, Double> price,
            Category category, char deleted) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.deleted = deleted;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }

    public Map<String, Double> getPrice() {
        return price;
    }

    public void setPrice(Map<String, Double> price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public char isDeleted() {
        return deleted;
    }

    public void setDeleted(char deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", description=" + description + ", price=" + price + ", category=" + category
                + ", deleted=" + deleted + "]";
    }

}
