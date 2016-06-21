package nl.sogeti.petshop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PetShopOrder.class)
public abstract class PetShopOrder_ extends nl.sogeti.petshop.model.HasGeneratedId_ {

	public static volatile SingularAttribute<PetShopOrder, String> firstName;
	public static volatile SingularAttribute<PetShopOrder, String> lastName;
	public static volatile SingularAttribute<PetShopOrder, String> address;
	public static volatile SingularAttribute<PetShopOrder, String> addressInsertion;
	public static volatile SingularAttribute<PetShopOrder, String> city;
	public static volatile SingularAttribute<PetShopOrder, String> postalCode;
	public static volatile SingularAttribute<PetShopOrder, String> addressNumber;
	public static volatile ListAttribute<PetShopOrder, OrderProduct> orderProducts;
	public static volatile SingularAttribute<PetShopOrder, String> insertion;
	public static volatile SingularAttribute<PetShopOrder, String> currency;
	public static volatile SingularAttribute<PetShopOrder, String> email;

}

