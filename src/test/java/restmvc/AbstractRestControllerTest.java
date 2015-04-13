package restmvc;

import at.thurnhaeuser.animalshelter.model.DomainConfiguration;
import at.thurnhaeuser.animalshelter.repositories.RepositoryConfiguration;
import at.thurnhaeuser.animalshelter.restmvc.RestApplicationConfig;
import at.thurnhaeuser.animalshelter.restmvc.RestMvcWebConfiguration;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by philip on 13.04.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DomainConfiguration.class, RepositoryConfiguration.class, RestApplicationConfig.class, RestMvcWebConfiguration.class} )
@WebAppConfiguration
public abstract class AbstractRestControllerTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void setup(){mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();}
}
