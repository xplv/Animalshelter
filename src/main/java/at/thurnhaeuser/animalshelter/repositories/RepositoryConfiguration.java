package at.thurnhaeuser.animalshelter.repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration of the Spring data repositories. Just referencing the base package containing the Spring data
 * repositories.
 * <p>
 */
@Configuration
@EnableJpaRepositories
@ComponentScan(basePackageClasses = RepositoryPackage.class)
public class RepositoryConfiguration {
}
