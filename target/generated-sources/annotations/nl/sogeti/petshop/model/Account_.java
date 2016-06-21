package nl.sogeti.petshop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, String> firstName;
	public static volatile SingularAttribute<Account, String> lastName;
	public static volatile SingularAttribute<Account, String> password;
	public static volatile SingularAttribute<Account, String> address;
	public static volatile SingularAttribute<Account, String> addressInsertion;
	public static volatile SingularAttribute<Account, String> city;
	public static volatile ListAttribute<Account, String> roles;
	public static volatile SingularAttribute<Account, String> postalCode;
	public static volatile SingularAttribute<Account, String> addressNumber;
	public static volatile SingularAttribute<Account, String> insertion;
	public static volatile SingularAttribute<Account, String> email;
	public static volatile SingularAttribute<Account, Boolean> activated;

}

