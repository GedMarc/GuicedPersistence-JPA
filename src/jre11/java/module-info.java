module com.jwebmp.guicedpersistence.jpa {
	exports com.jwebmp.guicedpersistence.jpa;

	requires aopalliance;
	requires java.logging;
	requires java.persistence;
	requires com.jwebmp.guicedinjection;
	requires com.google.guice;
	requires transitive com.jwebmp.guicedpersistence;
	requires com.jwebmp.logmaster;
	requires java.sql;
	requires java.transaction;
	requires com.google.guice.extensions.persist;
	requires java.validation;

	exports com.jwebmp.guicedpersistence.jpa.implementations to com.jwebmp.guicedinjection, com.jwebmp.examples.demos.homepage;

	provides com.jwebmp.guicedpersistence.services.ITransactionHandler with com.jwebmp.guicedpersistence.jpa.implementations.JPAAutomatedTransactionHandler;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.guicedpersistence.jpa.implementations.JPAModuleExclusions;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions with com.jwebmp.guicedpersistence.jpa.implementations.JPAModuleExclusions;

	opens com.jwebmp.guicedpersistence.jpa to com.fasterxml.jackson.databind, com.google.guice;
	opens com.jwebmp.guicedpersistence.jpa.implementations to com.fasterxml.jackson.databind, com.google.guice;
}
