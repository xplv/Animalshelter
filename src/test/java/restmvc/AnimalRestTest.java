package restmvc;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yanik on 4/13/15.
 */
public class AnimalRestTest extends AbstractRestControllerTest{
    private String animalExternalReference;

    @Autowired
    private AnimalRepository animalRepo;

    @Before
    public void setup() {
        animalRepo.deleteAll();
        Animal animal = new Animal(Animal.AnimalSpecies.Meerschweinchen,"rawr");
        animalRepo.save(animal);
        animalExternalReference = animal.getExternalReference();
        super.setup();
    }

    @Test
    public void verifySimplePostAnimal() throws Exception {
        ObjectNode contentJson = new ObjectMapper().createObjectNode();
        contentJson.put("Hund", "DogDog");
        mockMvc.perform(post("/animals").
                contentType(MediaType.APPLICATION_JSON).
                content(contentJson.toString())).
                andExpect(status().is2xxSuccessful()).
                andExpect(jsonPath("$.externalReference", notNullValue())).
                andDo(print());
    }

    @Test
    public void verifyGetAnimalsToReturnOneAnimal() throws Exception {
        mockMvc.perform(get("/animals")).
                andExpect(status().is2xxSuccessful()).
                andExpect(jsonPath("$.[*]", hasSize(1))).
                andDo(print());
    }

    @Test
    public void verifyThatGetWithExternalReferenceFindsAnimal() throws Exception {
        mockMvc.perform(get("/animals/" + animalExternalReference)).
                andExpect(status().is2xxSuccessful()).
                andExpect(jsonPath("$.externalReference", equalTo(animalExternalReference))).
                andDo(print());
    }
}
