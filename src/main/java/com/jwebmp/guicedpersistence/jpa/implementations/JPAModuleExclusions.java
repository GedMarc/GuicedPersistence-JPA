package com.jwebmp.guicedpersistence.jpa.implementations;

import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class JPAModuleExclusions
		implements IGuiceScanModuleExclusions<JPAModuleExclusions>,
				           IGuiceScanJarExclusions<JPAModuleExclusions>
{
	@Override
	public @NotNull Set<String> excludeJars()
	{
		Set<String> strings = new HashSet<>();
		strings.add("guiced-persistence-jpa-*");
		return strings;
	}

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.guicedpersistence.jpa");
		return strings;
	}
}
