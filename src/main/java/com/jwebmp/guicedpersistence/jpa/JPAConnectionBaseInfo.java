package com.jwebmp.guicedpersistence.jpa;

import com.jwebmp.guicedpersistence.db.ConnectionBaseInfo;

import javax.sql.DataSource;

public class JPAConnectionBaseInfo
		extends ConnectionBaseInfo
{
	/**
	 * You can fetch it directly from the entity manager using (DataSource)managerFactory.getConnectionFactory()
	 *
	 * @return Null
	 */
	@Override
	@SuppressWarnings("unchecked")
	public DataSource toPooledDatasource()
	{
		return null;
	}
}
