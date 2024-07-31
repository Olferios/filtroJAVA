package filtro.persona.application;

import filtro.persona.domain.entity.Persona;
import filtro.persona.domain.service.PersonaService;

public class RegistrarPersonaUseCase {
    public PersonaService personaService;
    
    public RegistrarPersonaUseCase(PersonaService personaService) {
        this.personaService = personaService;
    }

    public void execute (Persona persona){
        personaService.crearPersona(persona);
    }

}
