package springboot.course.exercise3.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springboot.course.exercise3.fauxspring.Model;
import springboot.course.exercise3.fauxspring.ModelMapImplementation;
import springboot.course.exercise3.model.Speciality;
import springboot.course.exercise3.model.Vet;
import springboot.course.exercise3.services.SpecialtyService;
import springboot.course.exercise3.services.VetService;
import springboot.course.exercise3.services.map.SpecialityMapService;
import springboot.course.exercise3.services.map.VetMapService;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;
    Vet vet1, vet2;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        Set<Speciality> specialities = new HashSet<>();

        specialities.add(new Speciality("Skin"));

        vetController = new VetController(vetService);
        vet1 = new Vet(1234L, "Pepito","Perez",specialities);
        vet2 = new Vet(5678L, "Jacinto","Jerez",specialities);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImplementation();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modelAttribute = (Set) ((ModelMapImplementation) model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}