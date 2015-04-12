package at.thurnhaeuser.animalshelter.servicespring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by joachim on 18/11/14.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = ServiceSpringPackage.class)
public class ServiceSpringConfiguration {
}
