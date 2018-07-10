package com.jwebmp.guicedpersistence.jpa.implementations;

import com.google.inject.Key;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedpersistence.db.annotations.Transactional;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.lang.annotation.Annotation;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("all")
public class InternalTransactionHandler
		implements MethodInterceptor
{
	private static final Logger log = Logger.getLogger("TransactionHandler");

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		Transactional t = invocation.getMethod()
		                            .getAnnotation(Transactional.class);
		Class<? extends Annotation> entityManagerKey = t.entityManagerAnnotation();
		EntityManager em = GuiceContext.get(Key.get(EntityManager.class, entityManagerKey));
		EntityTransaction emt = em.getTransaction();
		Object returnable = null;
		boolean alreadyActive = emt.isActive();
		if (!emt.isActive())
		{
			emt.begin();
		}
		try
		{
			returnable = invocation.proceed();
			if (!alreadyActive)
			{
				emt.commit();
			}
		}
		catch (IllegalStateException ise)
		{
			log.log(Level.FINEST, "Nothing to commit in transaction?", ise);
		}
		catch (Throwable T)
		{
			log.log(Level.SEVERE, "Exception In Commit : " + T.getMessage(), T);
			throw T;
		}
		return returnable;
	}
}
