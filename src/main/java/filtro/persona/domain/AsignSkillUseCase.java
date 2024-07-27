package filtro.persona.domain;

import filtro.persona.aplication.entity.PersonaSkill;
import filtro.persona.aplication.service.PersonService;

public class AsignSkillUseCase {
    public final PersonService personService;
    public AsignSkillUseCase(PersonService personService) {
        this.personService = personService;
    }
    
    public void execute(PersonaSkill personaSkill){
        personService.AsignPerson(personaSkill);
    }

}
