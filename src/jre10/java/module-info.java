import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.guicedpersistence.jpa.implementations.JPAAutomatedTransactionHandler;
import com.jwebmp.guicedpersistence.jpa.implementations.JPAGuicedPersistenceInterceptionBinding;
import com.jwebmp.guicedpersistence.services.ITransactionHandler;

module com.jwebmp.guicedpersistence.jpa {
	exports com.jwebmp.guicedpersistence.jpa;

	requires transitive com.jwebmp.guicedpersistence;

	exports com.jwebmp.guicedpersistence.jpa.implementations to com.jwebmp.guicedinjection;

	provides ITransactionHandler with JPAAutomatedTransactionHandler;
	provides IGuiceDefaultBinder with JPAGuicedPersistenceInterceptionBinding;

	opens com.jwebmp.guicedpersistence.jpa to com.fasterxml.jackson.databind, com.google.guice;
	opens com.jwebmp.guicedpersistence.jpa.implementations to com.fasterxml.jackson.databind, com.google.guice;
}
