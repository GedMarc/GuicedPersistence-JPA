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

	exports com.jwebmp.guicedpersistence.jpa.implementations to com.jwebmp.guicedinjection;
}
