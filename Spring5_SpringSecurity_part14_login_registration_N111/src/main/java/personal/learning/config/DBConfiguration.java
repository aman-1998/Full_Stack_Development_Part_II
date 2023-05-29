package personal.learning.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		
		ComboPooledDataSource cpDataSource = new ComboPooledDataSource();
		try {
			// set database properties
			
			cpDataSource.setDriverClass(env.getProperty("db.driver"));
			cpDataSource.setJdbcUrl(env.getProperty("db.url"));
			cpDataSource.setUser(env.getProperty("db.user"));
			cpDataSource.setPassword(env.getProperty("db.password"));
			
			// set connection pool properties
			
			cpDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			cpDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			cpDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
			cpDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
			
		} catch (PropertyVetoException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		return cpDataSource;
	}
	
	/**
	 * It is helper method to convert property value in string
	 * to property in integer
	 * 
	 * @param propName: Name of property
	 * @return intPropValue: Value of property in integer
	 */
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		int intPropValue = Integer.valueOf(propVal);
		return intPropValue;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
		sessionFactoryBean.setHibernateProperties(setHibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	private final Properties setHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
	    //hibernateProperties.setProperty(org.hibernate.cfg.Environment.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current_session_context_class"));
		
		//setting pool properties in hibernate
		hibernateProperties.setProperty("hibernate.c3p0.min_size", env.getProperty("connection.pool.minPoolSize"));
		hibernateProperties.setProperty("hibernate.c3p0.max_size", env.getProperty("connection.pool.maxPoolSize"));
		hibernateProperties.setProperty("hibernate.c3p0.idle_test_period", env.getProperty("connection.pool.idle_test_period"));
		hibernateProperties.setProperty("hibernate.c3p0.max_statements", env.getProperty("connection.pool.max_statements"));
		hibernateProperties.setProperty("hibernate.c3p0.timeout", env.getProperty("connection.pool.maxIdleTime"));
		hibernateProperties.setProperty("hibernate.c3p0.acquire_increment", env.getProperty("connection.pool.acquireIncrement"));
		hibernateProperties.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
		
		return hibernateProperties;
	}
	
}
