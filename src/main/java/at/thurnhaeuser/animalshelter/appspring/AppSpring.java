package at.thurnhaeuser.animalshelter.appspring;

import at.thurnhaeuser.animalshelter.servicespring.SpringSampleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpring {
    private ApplicationContext applicationContext;

    public AppSpring() {

    }

    private void initialize() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
    }

    private void execute(String args[]) {
        SpringSampleService springSampleService = applicationContext.getBean(SpringSampleService.class);
        springSampleService.useCaseA();
    }

    private void shutdown() {
    }

    public static final void main(String args[]) {
        AppSpring appSpring = new AppSpring();
        appSpring.initialize();
        appSpring.execute(args);
        appSpring.shutdown();
    }
}
