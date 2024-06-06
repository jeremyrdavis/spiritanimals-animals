package io.arrogantprogrammer;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/animals")
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {

    @Inject
    AnimalService animalService;
    @GET
    @Path("/random")
    public AnimalJson getRandomAnimal() {
        Log.debugf("Getting random animal");
        String animal = animalService.getAnimalName();
        Log.debugf("Returning animal: %s", animal);
        return new AnimalJson(animal);
    }
}
