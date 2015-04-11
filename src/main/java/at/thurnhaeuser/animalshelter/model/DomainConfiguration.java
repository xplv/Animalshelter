package at.thurnhaeuser.animalshelter.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DomainConfiguration {

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

		hibernateJpaVendorAdapter.setShowSql(true);

		hibernateJpaVendorAdapter.setGenerateDdl(true);

		hibernateJpaVendorAdapter.setDatabase(Database.H2);

		return hibernateJpaVendorAdapter;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource,

			JpaVendorAdapter jpaVendorAdapter) {

		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();

		lef.setDataSource(dataSource);

		lef.setJpaVendorAdapter(jpaVendorAdapter);

		lef.setPackagesToScan(DomainPackage.class.getPackage().getName());

		return lef;

	}

	@Bean
	public JpaTransactionManager transactionManager(
			EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager jtm = new JpaTransactionManager();

		jtm.setEntityManagerFactory(entityManagerFactory);

		return jtm;

	}

}
