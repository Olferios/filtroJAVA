package filtro;

import filtro.persona.aplication.service.PersonService;
import filtro.persona.domain.AsignSkillUseCase;
import filtro.persona.domain.CreatePersonUseCase;
import filtro.persona.domain.UpdatePersonUseCase;
import filtro.persona.infraestructure.PersonController;
import filtro.persona.infraestructure.PersonRepository;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonRepository();

        CreatePersonUseCase createUserUseCase = new CreatePersonUseCase(personService);
        AsignSkillUseCase asignSkillUseCase = new AsignSkillUseCase(personService);
        UpdatePersonUseCase updatePersonUseCase = new UpdatePersonUseCase(personService);
        
       
       PersonController personController = new PersonController(createUserUseCase, asignSkillUseCase,updatePersonUseCase);
       
       
       
       personController.start();       
    }
}