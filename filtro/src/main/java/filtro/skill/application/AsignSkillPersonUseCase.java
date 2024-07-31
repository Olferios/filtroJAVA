package filtro.skill.application;

import filtro.persona.domain.entity.PersonaSkill;

import filtro.skill.domain.service.SkillService;

public class AsignSkillPersonUseCase {
    public SkillService skillService;
    
    public AsignSkillPersonUseCase(SkillService skillService) {
        this.skillService = skillService;
    }
    public void execute(PersonaSkill personaSkill) {
        skillService.asignarSkillPerson(personaSkill);
    }

}
