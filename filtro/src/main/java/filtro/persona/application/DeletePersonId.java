package filtro.persona.application;

import filtro.persona.domain.service.PersonaService;

public class DeletePersonId {
    public PersonaService personaService;
    
    public DeletePersonId(PersonaService personaService) {
        this.personaService = personaService;
    }
    public void execute (int id){
        personaService.eliminarPersonaId(id);
    }

}
