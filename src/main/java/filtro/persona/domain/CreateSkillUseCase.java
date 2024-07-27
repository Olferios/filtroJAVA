package filtro.persona.domain;

import filtro.persona.aplication.entity.Skill;
import filtro.persona.aplication.service.PersonService;

public class CreateSkillUseCase {
    public final PersonService personService;

    public CreateSkillUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Skill skill){
        personService.createSkill(skill);
    }
}
