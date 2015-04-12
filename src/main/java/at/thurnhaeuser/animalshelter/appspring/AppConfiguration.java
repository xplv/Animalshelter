package at.thurnhaeuser.animalshelter.appspring;


import at.thurnhaeuser.animalshelter.model.DomainConfiguration;
import at.thurnhaeuser.animalshelter.repositories.RepositoryConfiguration;
import at.thurnhaeuser.animalshelter.servicespring.ServiceSpringConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@Import({DomainConfiguration.class, RepositoryConfiguration.class, ServiceSpringConfiguration.class})
public class AppConfiguration {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}
