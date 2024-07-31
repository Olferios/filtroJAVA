package filtro.skill.application;

import java.util.List;


import filtro.skill.domain.entity.Skill;
import filtro.skill.domain.service.SkillService;

public class ListarSkillUseCase {
    private final SkillService skillService;
    
    public ListarSkillUseCase(SkillService skillService) {
        this.skillService = skillService;
    }
    public List<Skill> execute (){
        return skillService.listarSkill();
    }

}
