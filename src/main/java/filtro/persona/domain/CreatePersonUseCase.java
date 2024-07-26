package filtro.persona.domain;

import filtro.persona.aplication.entity.Person;
import filtro.persona.aplication.service.PersonService;

public class CreatePersonUseCase {
    public final PersonService personService;

    

    public CreatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }



    public void execute(Person person){
        personService.createPerson(person);
    }
}
