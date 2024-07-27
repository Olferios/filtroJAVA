package filtro.persona.domain;

import filtro.persona.aplication.service.PersonService;

public class DeleteUseCase {
    public PersonService personService;
    public DeleteUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(int id){
        personService.deletePerson(id);
    }
}
