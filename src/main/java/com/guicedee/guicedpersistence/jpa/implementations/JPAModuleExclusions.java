package com.guicedee.guicedpersistence.jpa.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class JPAModuleExclusions
		implements IGuiceScanModuleExclusions<JPAModuleExclusions>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.guicedee.guicedpersistence.jpa");
		return strings;
	}
}
