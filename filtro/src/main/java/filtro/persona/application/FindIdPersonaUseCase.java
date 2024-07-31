package filtro.persona.application;

import filtro.persona.domain.entity.Persona;
import filtro.persona.domain.service.PersonaService;

public class FindIdPersonaUseCase {

    public PersonaService personaservice;

    public FindIdPersonaUseCase(PersonaService personaservice) {
        this.personaservice = personaservice;
    }
    public Persona execute (int id){
        return personaservice.findPersonaId(id);
    }


    
}
