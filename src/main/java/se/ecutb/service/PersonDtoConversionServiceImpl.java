package se.ecutb.service;

import org.springframework.stereotype.Component;
import se.ecutb.dto.PersonDto;
import se.ecutb.dto.PersonDtoWithTodo;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.util.List;
@Component
public class PersonDtoConversionServiceImpl implements PersonDtoConversionService {
    @Override
    public PersonDto convertToPersonDto(Person person) {
        PersonDto personDto = new PersonDto(person.getPersonId(), person.getFirstName(), person.getLastName());
        return personDto;
    }

    @Override
    public PersonDtoWithTodo convertToPersonDtoWithTodo(Person person, List<Todo> assignedTodos) {
        //PersonDtoWithTodo personDtoWithTodo = new PersonDtoWithTodo(person.getPersonId(), person.g)
        return null;
    }
}
