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

	/**
	 * Sets this Automated transaction handler to active
	 *
	 * @param active
	 */
	public static void setActive(boolean active)
	{
		JPAAutomatedTransactionHandler.ACTIVE = active;
	}

	@Override
	public void beginTransacation(boolean createNew, EntityManager entityManager)
	{
		if (createNew)
		{
			if (!entityManager.getTransaction()
			                  .isActive() && !transactionExists(entityManager))
			{
				entityManager.getTransaction()
				             .begin();
			}
		}
		if (!entityManager.getTransaction()
		                  .isActive() && !transactionExists(entityManager))
		{
			entityManager.getTransaction()
			             .begin();
		}
	}

	@Override
	public void commitTransacation(boolean createNew, EntityManager entityManager)
	{
		if (transactionExists(entityManager))
		{
			entityManager.getTransaction()
			             .commit();
		}
	}

	@Override
	public boolean transactionExists(EntityManager entityManager)
	{
		return entityManager.getTransaction()
		                    .isActive();
	}

	@Override
	public boolean active()
	{
		return ACTIVE;
	}
}
