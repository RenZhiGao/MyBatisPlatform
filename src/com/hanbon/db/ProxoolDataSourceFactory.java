package com.hanbon.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

public class ProxoolDataSourceFactory implements DataSourceFactory {
	private ProxoolDataSource dataSource = null;

	@Override
	public void setProperties(Properties properties) {
		try {
			try {
				JAXPConfigurator.configure(
						ProxoolDataSourceFactory.class.getResource("/../proxool.xml").getPath().replace("%20", " "), false);
			} catch (Exception e) {
				JAXPConfigurator.configure("test/proxool.xml", false);
			}
			dataSource = new ProxoolDataSource(properties.getProperty("use-alias"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataSource getDataSource() {
		return this.dataSource;
	}
}
