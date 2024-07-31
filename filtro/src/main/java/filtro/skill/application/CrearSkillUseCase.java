package filtro.skill.application;

import filtro.skill.domain.entity.Skill;
import filtro.skill.domain.service.SkillService;

public class CrearSkillUseCase {
    public SkillService skillService;
    
    public CrearSkillUseCase(SkillService skillService) {
        this.skillService = skillService;
    }
    public void execute (Skill skill){
        skillService.crearSkill(skill);
    }

}
