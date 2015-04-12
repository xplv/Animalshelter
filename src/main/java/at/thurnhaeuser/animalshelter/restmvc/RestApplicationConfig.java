/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.thurnhaeuser.animalshelter.restmvc;


import at.thurnhaeuser.animalshelter.model.DomainConfiguration;
import at.thurnhaeuser.animalshelter.repositories.RepositoryConfiguration;
import at.thurnhaeuser.animalshelter.servicespring.ServiceSpringConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


import javax.sql.DataSource;

@Import(value = {DomainConfiguration.class, RepositoryConfiguration.class, ServiceSpringConfiguration.class})
@Configuration
public class RestApplicationConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public RestEventListener restEventListener() {
        return new RestEventListener();
    }

}
