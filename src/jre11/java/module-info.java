import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.guicedpersistence.jpa.implementations.JPAAutomatedTransactionHandler;
import com.jwebmp.guicedpersistence.jpa.implementations.JPAModuleExclusions;
import com.jwebmp.guicedpersistence.services.ITransactionHandler;

module com.jwebmp.guicedpersistence.jpa {
	exports com.jwebmp.guicedpersistence.jpa;

	requires aopalliance;
	requires java.logging;
	requires java.persistence;
	requires com.jwebmp.guicedinjection;
	requires com.google.guice;
	requires com.jwebmp.guicedpersistence;
	requires com.jwebmp.logmaster;
	requires java.sql;
	requires java.transaction;
	requires com.google.guice.extensions.persist;
	requires java.validation;

	exports com.jwebmp.guicedpersistence.jpa.implementations to com.jwebmp.guicedinjection, com.jwebmp.examples.demos.homepage;

	provides ITransactionHandler with JPAAutomatedTransactionHandler;

	provides IGuiceScanModuleExclusions with JPAModuleExclusions;
	provides IGuiceScanJarExclusions with JPAModuleExclusions;

	opens com.jwebmp.guicedpersistence.jpa to com.fasterxml.jackson.databind, com.google.guice;
	opens com.jwebmp.guicedpersistence.jpa.implementations to com.fasterxml.jackson.databind, com.google.guice;
}
