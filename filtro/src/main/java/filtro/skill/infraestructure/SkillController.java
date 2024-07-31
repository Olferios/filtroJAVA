package filtro.skill.infraestructure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import filtro.persona.application.ListarPersonaUseCase;
import filtro.persona.domain.entity.Persona;
import filtro.persona.domain.entity.PersonaSkill;
import filtro.skill.application.AsignSkillPersonUseCase;
import filtro.skill.application.CrearSkillUseCase;
import filtro.skill.application.ListarSkillUseCase;
import filtro.skill.domain.entity.Skill;
import filtro.skill.domain.service.SkillService;

public class SkillController {
    private final CrearSkillUseCase crearSkillUseCase;
    private final ListarSkillUseCase listarSkillUseCase;
    private final AsignSkillPersonUseCase asignSkillPersonUseCase;
    private final ListarPersonaUseCase listarPersonaUseCase;

    public SkillController(CrearSkillUseCase crearSkillUseCase, ListarSkillUseCase listarSkillUseCase,
            AsignSkillPersonUseCase asignSkillPersonUseCase, ListarPersonaUseCase listarPersonaUseCase) {
        this.crearSkillUseCase = crearSkillUseCase;
        this.listarSkillUseCase = listarSkillUseCase;
        this.asignSkillPersonUseCase = asignSkillPersonUseCase;
        this.listarPersonaUseCase = listarPersonaUseCase;
    }

    public void crearSkill() {
        String inputname = JOptionPane.showInputDialog(null, "ingrese nombre de Skilll");

        Skill skill = new Skill();
        skill.setNombre(inputname);
        crearSkillUseCase.execute(skill);

        JOptionPane.showMessageDialog(null, "Skill creada correctamente");

    }

    // public void asignarSkillPersona() {
    // // Skill skill = new Skill();
    // // int id = skill.getId();
    // List<Skill> listSkill = listarSkillUseCase.execute();

    // JFrame frame = new JFrame("Lista de Habilidades");
    // JPanel panel = new JPanel();

    // if (listSkill != null && !listSkill.isEmpty()) {
    // JList<Skill> jList = new JList<>(listSkill.toArray(new Skill[0]));
    // JScrollPane scrollPane = new JScrollPane(jList);
    // panel.add(scrollPane);
    // } else {
    // panel.add(new javax.swing.JLabel("No hay habilidades disponibles."));
    // }

    // frame.getContentPane().add(panel);
    // frame.setSize(300, 200);
    // frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // frame.setVisible(true);

    // }

    public void asignarSkillPersona() {
        List<Skill> listSkill = listarSkillUseCase.execute();
    
        JFrame frameSkill = new JFrame("Lista de Habilidades");
        JPanel panelSkill = new JPanel();
        panelSkill.setLayout(new BoxLayout(panelSkill, BoxLayout.Y_AXIS));
    
        if (listSkill != null && !listSkill.isEmpty()) {
            JList<Skill> jListSkill = new JList<>(listSkill.toArray(new Skill[0]));
            JScrollPane scrollPaneSkill = new JScrollPane(jListSkill);
            panelSkill.add(scrollPaneSkill);
    
            JButton selectButtonSkill = new JButton("Seleccionar");
            panelSkill.add(selectButtonSkill);
    
            selectButtonSkill.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Skill selectedSkill = jListSkill.getSelectedValue();
                    if (selectedSkill != null) {
                        int selectedSkillId = selectedSkill.getId();
                        System.out.println("ID de la habilidad seleccionada: " + selectedSkillId);
                        frameSkill.dispose();
    
                        // Listar Persona
                        List<Persona> listPersona = listarPersonaUseCase.execute();
                        System.out.println("Lista de personas obtenida: " + listPersona);
                        
                        JFrame framePersona = new JFrame("Lista de Personas");
                        JPanel panelPersona = new JPanel();
                        panelPersona.setLayout(new BoxLayout(panelPersona, BoxLayout.Y_AXIS));
    
                        if (listPersona != null && !listPersona.isEmpty()) {
                            JList<Persona> jListPersona = new JList<>(listPersona.toArray(new Persona[0]));
                            JScrollPane scrollPanePersona = new JScrollPane(jListPersona);
                            panelPersona.add(scrollPanePersona);
    
                            JButton selectButtonPersona = new JButton("Seleccionar");
                            panelPersona.add(selectButtonPersona);
    
                            selectButtonPersona.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Persona selectedPersona = jListPersona.getSelectedValue();
                                    if (selectedPersona != null) {
                                        int selectedPersonaId = selectedPersona.getId();
                                        System.out.println("ID de la persona seleccionada: " + selectedPersonaId);
                                        framePersona.dispose();
    
                                        // Asigna el skill a la persona aquí
                                        String inpuFecha=JOptionPane.showInputDialog(null, "Ingrese fecha");

                                        PersonaSkill personaSkill=new PersonaSkill();
                                        personaSkill.setFecha(inpuFecha);
                                        personaSkill.setIdPersona(selectedPersonaId);
                                        personaSkill.setIdSkill(selectedSkillId);
                                        asignSkillPersonUseCase.execute(personaSkill);
                                        
                                        JOptionPane.showMessageDialog(null, "Skill asignada correctamente.");
                                    } else {
                                        JOptionPane.showMessageDialog(framePersona, "Por favor, selecciona una persona.");
                                    }
                                }
                            });
    
                            framePersona.getContentPane().add(panelPersona);
                            framePersona.setSize(300, 200);
                            framePersona.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            framePersona.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(frameSkill, "No hay personas disponibles.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frameSkill, "Por favor, selecciona una habilidad.");
                    }
                }
            });
    
            frameSkill.getContentPane().add(panelSkill);
            frameSkill.setSize(300, 200);
            frameSkill.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameSkill.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(frameSkill, "No hay habilidades disponibles.");
        }
    }
}
