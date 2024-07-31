package filtro.persona.application;

import filtro.persona.domain.entity.Persona;
import filtro.persona.domain.service.PersonaService;

public class ActualizarPersonaUseCase {
    public PersonaService personaService;

    public ActualizarPersonaUseCase(PersonaService personaService) {
        this.personaService = personaService;

    }
    public void execute (Persona persona){
        personaService.actualizarPersona(persona);
        
    }


}
