package filtro.persona.domain.service;

import java.util.List;

import filtro.persona.domain.entity.Persona;
//import filtro.persona.domain.entity.PersonaSkill;

public interface PersonaService {
    void crearPersona (Persona persona);
    void actualizarPersona (Persona persona);
    Persona findPersonaId(int id);
    void eliminarPersonaId (int id);
    void eliminarPersonsSkill (int id);
    List<Persona> listarPersonas();
    

}
