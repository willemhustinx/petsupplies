package nl.sogeti.petshop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ extends nl.sogeti.petshop.model.HasGeneratedId_ {

	public static volatile MapAttribute<Product, String, Double> price;
	public static volatile MapAttribute<Product, String, String> name;
	public static volatile MapAttribute<Product, String, String> description;
	public static volatile SingularAttribute<Product, Category> category;

}

