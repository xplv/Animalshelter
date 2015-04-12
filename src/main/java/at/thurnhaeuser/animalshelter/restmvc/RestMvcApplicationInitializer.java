package at.thurnhaeuser.animalshelter.restmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RestMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RestApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{RestMvcWebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/restmvc/*"};
    }
}
