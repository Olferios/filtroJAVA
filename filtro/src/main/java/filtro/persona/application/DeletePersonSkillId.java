package filtro.persona.application;

import filtro.persona.domain.service.PersonaService;

public class DeletePersonSkillId {
    public PersonaService personaService;
    
    public DeletePersonSkillId(PersonaService personaService) {
        this.personaService = personaService;
    }
    public void execute(int id) {
        personaService.eliminarPersonsSkill(id);
    }

}
