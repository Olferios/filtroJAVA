package filtro.persona.infraestructure;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import filtro.persona.aplication.entity.Person;
import filtro.persona.aplication.entity.PersonaSkill;
import filtro.persona.aplication.entity.Skill;
import filtro.persona.domain.AsignSkillUseCase;
import filtro.persona.domain.CreatePersonUseCase;
import filtro.persona.domain.UpdatePersonUseCase;

public class PersonController {

    private final CreatePersonUseCase createPersonUseCase;
    private final AsignSkillUseCase asignSkillUseCase;
    private final UpdatePersonUseCase updatePersonUseCase;

    
    


    //public void start(){
    public PersonController(CreatePersonUseCase createPersonUseCase, AsignSkillUseCase asignSkillUseCase,
            UpdatePersonUseCase updatePersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
        this.asignSkillUseCase = asignSkillUseCase;
        this.updatePersonUseCase = updatePersonUseCase;
    }





    public void start() {

        JPanel menu = new JPanel(new GridLayout(0, 1));

        menu.add(new JLabel("bienvenido"));
        menu.add(new JLabel("1: crear una Persona:"));
        menu.add(new JLabel("2: Asignar Habilidad"));
        menu.add(new JLabel("3: Crear Habilidad:"));
        menu.add(new JLabel("4: Consultar Personas por Habilidad:"));
        menu.add(new JLabel("5: Actualizar Información de Persona:"));
        menu.add(new JLabel("6: Eliminar Persona:"));

   

        JTextField opcion = new JTextField();
        menu.add(opcion);

        int seleccion = JOptionPane.showConfirmDialog(null, menu, "Tipo Usuario",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (seleccion == JOptionPane.OK_OPTION) {
            if (opcion.getText().equals("1")) {
               // JPanel panel = new JPanel(new GridLayout(0, 2));
                String nombre=JOptionPane.showInputDialog(null,"ingrese  nombre");
            

                String apellido=JOptionPane.showInputDialog(null,"Ingrese apellido");

                String direccion=JOptionPane.showInputDialog(null,"Ingrese de la dirección");

                String inputEdad=JOptionPane.showInputDialog(null,"Ingrese edad");
                int edad=Integer.parseInt(inputEdad);

                String inputEmail=JOptionPane.showInputDialog(null,"Ingrese email");

                String inputGenero=JOptionPane.showInputDialog(null,"Ingrese id genero");
                int genero=Integer.parseInt(inputGenero);

                Person person=new Person();
            
                person.setName(nombre);
                person.setLastname(apellido);
                person.setAddres(direccion);
                person.setAge(edad);
                person.setEmail(inputEmail);
                person.setIdgender(genero);

                createPersonUseCase.execute(person);
                
                JOptionPane.showMessageDialog(null, "Persona creada con éxito");

              
            }
            if(opcion.getText().equals("2")){
                String inputIdPerson=JOptionPane.showInputDialog(null,"ingrese id de la person");
                int idPerson=Integer.parseInt(inputIdPerson);

                String inputIdSkill=JOptionPane.showInputDialog(null,"ingrese id de la habilidad");
                int idSkill=Integer.parseInt(inputIdSkill);

                String inputDate=JOptionPane.showInputDialog(null, "Ingrese fecha");

                PersonaSkill personaSkill = new PersonaSkill();
                personaSkill.setRegistrationDate(java.sql.Date.valueOf(inputDate));
                personaSkill.setPersonId(idPerson);
                personaSkill.setSkillId(idSkill);
                
                asignSkillUseCase.execute(personaSkill);
                
                JOptionPane.showMessageDialog(null, "Persona-Habilidad creada con éxito");             


            }
            if(opcion.getText().equals("3")){
                String nombreSkill=JOptionPane.showInputDialog(null,"ingrese nombre de la habilidad");

                Skill skill=new Skill();
                skill.setName(nombreSkill);

                // SkillRepository skillRepository = new SkillRepository();
                // skillRepository.save(skill);

                JOptionPane.showMessageDialog(null, "Habilidad creada con éxito");

             }
             if(opcion.getText().equals("5")){
                String inputIdPerson=JOptionPane.showInputDialog(null,"Ingrese id de persona");
                int idPerson=Integer.parseInt(inputIdPerson);

                String nombre=JOptionPane.showInputDialog(null,"ingrese  nombre");
            

                String apellido=JOptionPane.showInputDialog(null,"Ingrese apellido");

                String direccion=JOptionPane.showInputDialog(null,"Ingrese de la dirección");

                String inputEdad=JOptionPane.showInputDialog(null,"Ingrese edad");
                int edad=Integer.parseInt(inputEdad);

                String inputEmail=JOptionPane.showInputDialog(null,"Ingrese email");

                Person personaupdt=new Person();
                personaupdt.setId(idPerson);
                personaupdt.setName(nombre);
                personaupdt.setLastname(apellido);
                personaupdt.setAddres(direccion);
                personaupdt.setAge(edad);
                personaupdt.setEmail(inputEmail);

                updatePersonUseCase.execute(personaupdt);

                JOptionPane.showMessageDialog(null, "Persona actualizada con éxito");

                

                
             }

                

            } else {
                
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
            
             
             
             if(opcion.getText().equals("6")){

             }

            



            


        }

    }

   

    


