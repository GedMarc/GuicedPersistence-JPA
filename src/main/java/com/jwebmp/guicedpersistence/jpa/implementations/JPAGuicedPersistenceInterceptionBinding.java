package com.jwebmp.guicedpersistence.jpa.implementations;

import com.google.inject.matcher.Matchers;
import com.jwebmp.guicedinjection.abstractions.GuiceInjectorModule;
import com.jwebmp.guicedinjection.interfaces.GuiceDefaultBinder;

@SuppressWarnings("unused")
public class JPAGuicedPersistenceInterceptionBinding
		extends GuiceDefaultBinder
{

	@Override
	public void onBind(GuiceInjectorModule module)
	{
		module.bindInterceptor(Matchers.any(), Matchers.annotatedWith(com.jwebmp.guicedpersistence.db.annotations.Transactional.class), new InternalTransactionHandler());
	}

}
