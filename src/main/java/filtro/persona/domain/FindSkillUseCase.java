package filtro.persona.domain;

import filtro.persona.aplication.entity.Skill;
import filtro.persona.aplication.service.PersonService;

public class FindSkillUseCase {
    public PersonService personService;
    public FindSkillUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Skill skill){
        personService.findSkill(skill);
    }
}
