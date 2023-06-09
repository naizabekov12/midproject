package kg.ulan.SpringSecurityApp.utils;

import kg.ulan.SpringSecurityApp.models.Person;
import kg.ulan.SpringSecurityApp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personService.findPersonByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username", "", "Username is already exist");
    }

}
