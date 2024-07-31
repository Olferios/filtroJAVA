package filtro.skill.domain.service;

import java.util.List;

import filtro.persona.domain.entity.Persona;
import filtro.persona.domain.entity.PersonaSkill;
import filtro.skill.domain.entity.Skill;

public interface SkillService {
    void crearSkill (Skill skill);
    List<Skill> listarSkill();
    void asignarSkillPerson (PersonaSkill personaSkill);
    

}
