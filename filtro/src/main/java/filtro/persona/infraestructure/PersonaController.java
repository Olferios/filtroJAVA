package filtro.persona.infraestructure;

import javax.swing.JOptionPane;

import filtro.persona.application.ActualizarPersonaUseCase;
import filtro.persona.application.DeletePersonId;
import filtro.persona.application.DeletePersonSkillId;
import filtro.persona.application.FindIdPersonaUseCase;
import filtro.persona.application.RegistrarPersonaUseCase;
import filtro.persona.domain.entity.Persona;

public class PersonaController {

    private final RegistrarPersonaUseCase registrarPersonaUseCase;
    private final ActualizarPersonaUseCase actualizarPersonaUseCase;
    private final FindIdPersonaUseCase findIdPersonaUseCase;
    private final DeletePersonId deletePersonId;
    private final DeletePersonSkillId deletePersonSkillId;

    

    public PersonaController(RegistrarPersonaUseCase registrarPersonaUseCase,
            ActualizarPersonaUseCase actualizarPersonaUseCase, FindIdPersonaUseCase findIdPersonaUseCase,
            DeletePersonId deletePersonId, DeletePersonSkillId deletePersonSkillId) {
        this.registrarPersonaUseCase = registrarPersonaUseCase;
        this.actualizarPersonaUseCase = actualizarPersonaUseCase;
        this.findIdPersonaUseCase = findIdPersonaUseCase;
        this.deletePersonId = deletePersonId;
        this.deletePersonSkillId = deletePersonSkillId;
    }

    public void crearPersona() {
        String inputname = JOptionPane.showInputDialog(null, "Ingrese nombre de persona");

        String inputapellido = JOptionPane.showInputDialog(null, "Ingrese apellido de persona");

        String inputCity = JOptionPane.showInputDialog(null, "Ingrese id de ciudad");
        int ciudad = Integer.parseInt(inputCity);

        String inputaddress = JOptionPane.showInputDialog(null, "Ingrese direccion de la persona");

        String inputage = JOptionPane.showInputDialog(null, "Ingrese edad de la persona");
        int edad = Integer.parseInt(inputage);

        String inputemail = JOptionPane.showInputDialog(null, "Ingrese email de la persona");

        String inputgenero = JOptionPane.showInputDialog(null, "Ingrese id genero de la persona");
        int genero = Integer.parseInt(inputgenero);

        Persona persona = new Persona();
        persona.setNombre(inputname);
        persona.setApellido(inputapellido);
        persona.setCity(ciudad);
        persona.setAddress(inputaddress);
        persona.setAge(edad);
        persona.setEmail(inputemail);
        persona.setGenero(genero);

        registrarPersonaUseCase.execute(persona);
        JOptionPane.showMessageDialog(null, "Persona registrada correctamente");

    }

    public void actualizarPersona() {
        String inputId = JOptionPane.showInputDialog(null, "Ingrese id de la persona para actualizar");
        int id = Integer.parseInt(inputId);
    
        Persona personaExistente = findIdPersonaUseCase.execute(id);
    
        if (personaExistente != null) {
            String inputName = JOptionPane.showInputDialog(null, "Ingrese nuevo nombre de persona");
    
            String inputApellido = JOptionPane.showInputDialog(null, "Ingrese nuevo apellido de persona");
    
            String inputCity = JOptionPane.showInputDialog(null, "Ingrese nuevo id de ciudad");
            int city = Integer.parseInt(inputCity);
    
            String inputAddress = JOptionPane.showInputDialog(null, "Ingrese nueva direccion de la persona");
    
            String inputAge = JOptionPane.showInputDialog(null, "Ingrese nueva edad de la persona");
            int edad = Integer.parseInt(inputAge);
    
            String inputEmail = JOptionPane.showInputDialog(null, "Ingrese nuevo email de la persona");
    
            String inputGenero = JOptionPane.showInputDialog(null, "Ingrese nuevo id genero de la persona");
            int genero = Integer.parseInt(inputGenero);
    
            // Usar el objeto existente para actualizarlo
            personaExistente.setNombre(inputName);
            personaExistente.setApellido(inputApellido);
            personaExistente.setCity(city);
            personaExistente.setAddress(inputAddress);
            personaExistente.setAge(edad);
            personaExistente.setEmail(inputEmail);
            personaExistente.setGenero(genero);
    
            actualizarPersonaUseCase.execute(personaExistente);
            JOptionPane.showMessageDialog(null, "Persona actualizada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Id no existe");
        }
    }

    public void eliminarPersona(){
        String inputId = JOptionPane.showInputDialog(null, "Ingrese id de la persona para eliminar");
        int id = Integer.parseInt(inputId);

        Persona personaExistente = findIdPersonaUseCase.execute(id);

        if (personaExistente!= null){
            deletePersonSkillId.execute(id);
            deletePersonId.execute(id);            
            JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Id no existe");
        }
    }
    

}
