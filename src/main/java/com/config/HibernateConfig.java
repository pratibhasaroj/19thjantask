package com.config;

//import java.util.Properties;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class HibernateConfig {

	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/TechLib";
	private final static String DATABASE_DRIVER ="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String USERNAME="sa";
	private final static String PASSWORD="" ;
	
	@Autowired
	@Bean
	private BasicDataSource getDataSource()
	{
		BasicDataSource datasource= new BasicDataSource();
		 //connection information
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(USERNAME);
		datasource.setPassword(PASSWORD);
		
		return datasource;
		
	}
	
	@SuppressWarnings("deprecation")
	@Autowired
	@Bean
	
	public SessionFactory getSessionFactory(DataSource datasource){
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder((javax.sql.DataSource) datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.TechLibBackEnd");
		
		return builder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties(){
		
		Properties properties= new Properties();
		//hibernate properties
		properties.put("hibernate.dielect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.format_sql","true");
		return properties;
		
		
	}
	
	//transactionmanager
	@Autowired
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
