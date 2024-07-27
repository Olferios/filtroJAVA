package filtro.persona.domain;

import filtro.persona.aplication.entity.Person;
import filtro.persona.aplication.service.PersonService;

public class UpdatePersonUseCase {
    public PersonService personService;
    public UpdatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person){
        personService.updatePerson(person);
    }
}
