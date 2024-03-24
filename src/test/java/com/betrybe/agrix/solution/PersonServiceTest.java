package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPersonById_WhenPersonExists_ShouldReturnPerson() {
        final long personId = 10;
        Person mockPerson = new Person();
        when(personRepository.findById(personId)).thenReturn(Optional.of(mockPerson));
        Person result = personService.getPersonById(personId);

        assertEquals(mockPerson, result);
    }

    @Test
    public void testGetPersonById_WhenPersonDoesNotExist_ShouldThrowPersonNotFoundException() {
        final long personId = 10;
        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(personId));
    }

    @Test
    public void testGetPersonByUsername_WhenPersonExists_ShouldReturnPerson() {
        final String username = "Fulano";
        Person mockPerson = new Person();
        when(personRepository.findByUsername(username)).thenReturn(Optional.of(mockPerson));
        Person result = personService.getPersonByUsername(username);
        assertEquals(mockPerson, result);
    }

    @Test
    public void testGetPersonByUsername_WhenPersonDoesNotExist_ShouldThrowPersonNotFoundException() {
        final String username = "Ciclano";
        when(personRepository.findByUsername(username)).thenReturn(Optional.empty());
        assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername(username));
    }

    @Test
    public void testCreatePerson_ShouldReturnCreatedPerson() {
        Person mockPerson = new Person();
        when(personRepository.save(any())).thenReturn(mockPerson);
        Person result = personService.create(new Person());
        assertEquals(mockPerson, result);
        verify(personRepository, times(1)).save(any());
    }
}