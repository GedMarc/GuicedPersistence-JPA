package com.guicedee.guicedpersistence.jpa;

import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;
import com.guicedee.logger.logging.LogColourFormatter;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

public class GuicedPersistenceBindingTest
{
	@Test
	public void testMe() throws InterruptedException
	{
		LogFactory.configureConsoleSingleLineOutput(Level.FINE);
		LogColourFormatter.setRenderBlack(false);
		GuiceContext.inject();

	}
}
