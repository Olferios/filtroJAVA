package filtro;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import filtro.persona.application.ActualizarPersonaUseCase;
import filtro.persona.application.DeletePersonId;
import filtro.persona.application.DeletePersonSkillId;
import filtro.persona.application.FindIdPersonaUseCase;
import filtro.persona.application.ListarPersonaUseCase;
import filtro.persona.application.RegistrarPersonaUseCase;
import filtro.persona.domain.service.PersonaService;
import filtro.persona.infraestructure.PersonaController;
import filtro.persona.infraestructure.PersonaRepository;
import filtro.skill.application.AsignSkillPersonUseCase;
import filtro.skill.application.CrearSkillUseCase;
import filtro.skill.application.ListarSkillUseCase;
import filtro.skill.domain.service.SkillService;
import filtro.skill.infraestructure.SkillController;
import filtro.skill.infraestructure.SkillRepository;

public class Main {
    public static void main(String[] args) {
        PersonaService personaService=new PersonaRepository();
        SkillService skillService=new SkillRepository();


        RegistrarPersonaUseCase registrarPersonaUseCase=new RegistrarPersonaUseCase(personaService);
        ActualizarPersonaUseCase actualizarPersonaUseCase=new ActualizarPersonaUseCase(personaService);
        FindIdPersonaUseCase findIdPersonaUseCase=new FindIdPersonaUseCase(personaService);
        DeletePersonId deletePersonaId=new DeletePersonId(personaService);
        DeletePersonSkillId deletePersonaSkillId=new DeletePersonSkillId(personaService);
        CrearSkillUseCase crearSkillUseCase=new CrearSkillUseCase(skillService);
        AsignSkillPersonUseCase asignSkillPersonUseCase=new AsignSkillPersonUseCase(skillService);
        ListarSkillUseCase listarSkillUseCase=new ListarSkillUseCase(skillService);
        ListarPersonaUseCase listarPersonaUseCase=new ListarPersonaUseCase(personaService);


        PersonaController personaController= new PersonaController(registrarPersonaUseCase,actualizarPersonaUseCase,
        findIdPersonaUseCase,deletePersonaId,deletePersonaSkillId);
        SkillController skillController=new SkillController(crearSkillUseCase,listarSkillUseCase,asignSkillPersonUseCase,listarPersonaUseCase);

        JPanel menu= new JPanel(new GridLayout(0,1));
        menu.add(new JLabel("Bienvenido"));
        menu.add(new JLabel("1. Crear Persona"));
        menu.add(new JLabel("2: Asignar Habilidad"));
        menu.add(new JLabel("3: Crear Habilidad:"));
        menu.add(new JLabel("4: Consultar Personas por Habilidad:"));
        menu.add(new JLabel("5: Actualizar Información de Persona:"));
        menu.add(new JLabel("6: Eliminar Persona:"));

        
        boolean continuar = true;

        while (continuar) {
            // Mostrar el diálogo de entrada
            String opcion = JOptionPane.showInputDialog(null, menu, "Tipo Usuario", JOptionPane.PLAIN_MESSAGE);

            if (opcion != null) {
                switch (opcion) {
                    case "1":
                        personaController.crearPersona();
                        break;
                    case "2":
                        skillController.asignarSkillPersona();
                        break;
                    case "3":
                        skillController.crearSkill();
                        break;
                    case "4":
                        // Lógica para consultar personas por habilidad
                        break;
                    case "5":
                        personaController.actualizarPersona();
                        break;
                    case "6":
                        personaController.eliminarPersona();
                        break;
                    case "0":
                        continuar = false; // Salir del bucle
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción del menú.");
                }
            } else {
                continuar = false; // Salir si el usuario cancela el diálogo
            }
        }

        JOptionPane.showMessageDialog(null, "Programa terminado.");
    }
}