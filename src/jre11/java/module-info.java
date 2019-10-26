module com.guicedee.guicedpersistence.jpa {
	exports com.guicedee.guicedpersistence.jpa;

	requires aopalliance;
	requires java.logging;
	requires java.persistence;
	requires com.guicedee.guicedinjection;
	requires com.google.guice;
	requires transitive com.guicedee.guicedpersistence;
	requires com.guicedee.logmaster;
	requires java.sql;
	requires java.transaction;
	requires com.google.guice.extensions.persist;
	requires java.validation;

	exports com.guicedee.guicedpersistence.jpa.implementations to com.guicedee.guicedinjection;

	provides com.guicedee.guicedpersistence.services.ITransactionHandler with com.guicedee.guicedpersistence.jpa.implementations.JPAAutomatedTransactionHandler;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.guicedee.guicedpersistence.jpa.implementations.JPAModuleExclusions;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanJarExclusions with com.guicedee.guicedpersistence.jpa.implementations.JPAModuleExclusions;

	opens com.guicedee.guicedpersistence.jpa to com.fasterxml.jackson.databind, com.google.guice;
	opens com.guicedee.guicedpersistence.jpa.implementations to com.fasterxml.jackson.databind, com.google.guice;
}
