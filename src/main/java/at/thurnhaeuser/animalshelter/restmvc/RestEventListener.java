package at.thurnhaeuser.animalshelter.restmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

/**
 * Created by joachim on 09/12/14.
 */
@RepositoryEventHandler
public class RestEventListener extends AbstractRepositoryEventListener {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void onBeforeCreate(Object entity) {
        logger.info("onBeforeCreate for: " + entity);
    }

    @Override
    protected void onAfterCreate(Object entity) {
        logger.info("onAfterCreate for: " + entity);
    }

    @Override
    protected void onBeforeSave(Object entity) {
        logger.info("onBeforeSave for: " + entity);
    }

    @Override
    protected void onAfterSave(Object entity) {
        logger.info("onAfterSave for: " + entity);
    }
}
