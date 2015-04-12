package at.thurnhaeuser.animalshelter.restmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by philip on 12.04.2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = RestPackage.class)
public class RestMvcWebConfiguration extends WebMvcConfigurerAdapter{
}
