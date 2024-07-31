package filtro.persona.application;

import java.util.List;

import filtro.persona.domain.entity.Persona;
import filtro.persona.domain.service.PersonaService;

public class ListarPersonaUseCase {
    private final PersonaService personaService;
    
    public ListarPersonaUseCase(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    public List<Persona> execute() {
        return personaService.listarPersonas();
    }
}
