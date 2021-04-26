package springboot.course.exercise3.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import springboot.course.exercise3.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

@Disabled(value = "Until learn how to mock")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        service = new OwnerSDJpaService(null,null,null);
    }

    @Disabled
    @Test
    void findByLastName() {
        Owner foundOwner = service.findByLastName("Perez");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}