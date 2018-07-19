package com.jwebmp.guicedpersistence.jpa.implementations;

import com.jwebmp.guicedpersistence.services.ITransactionHandler;

import javax.persistence.EntityManager;

public class JPAAutomatedTransactionHandler
		implements ITransactionHandler
{
	private static boolean ACTIVE = false;

	public JPAAutomatedTransactionHandler()
	{
		//No config required
	}

	public static void setActive(boolean ACTIVE)
	{
		JPAAutomatedTransactionHandler.ACTIVE = ACTIVE;
	}

	@Override
	public void beginTransacation(boolean createNew, boolean transactionExists, EntityManager entityManager)
	{
		if (createNew)
		{
			if (!entityManager.getTransaction()
			                  .isActive() && !transactionExists)
			{
				entityManager.getTransaction()
				             .begin();
			}
		}
		if (!entityManager.getTransaction()
		                  .isActive() && !transactionExists)
		{
			entityManager.getTransaction()
			             .begin();
		}
	}

	@Override
	public void commitTransacation(boolean createNew, boolean transactionExists, EntityManager entityManager)
	{
		if (createNew)
		{
			if (entityManager.getTransaction()
			                 .isActive() && !transactionExists)
			{
				entityManager.getTransaction()
				             .commit();
			}
		}
		if (entityManager.getTransaction()
		                 .isActive() && !transactionExists)
		{
			entityManager.getTransaction()
			             .commit();
		}
	}

	@Override
	public boolean active()
	{
		return ACTIVE;
	}
}