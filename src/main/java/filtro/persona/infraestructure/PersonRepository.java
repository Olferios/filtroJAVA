package filtro.persona.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import filtro.persona.aplication.entity.Person;
import filtro.persona.aplication.entity.PersonaSkill;
import filtro.persona.aplication.entity.Skill;
import filtro.persona.aplication.service.PersonService;

public class PersonRepository implements PersonService {

        private Connection connection;

    public PersonRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            System.out.println("URL: " + url); // Verificar la URL cargada
            System.out.println("User: " + user); // Verificar el usuario cargado
            // N
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    @Override
    public void createPerson(Person person) {
        
        try {
            String query = "INSERT INTO sgpzf.persons (name,lastname,idcity,address,age,email,idgender) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getName());
            ps.setString(2, person.getLastname());
            ps.setInt(3, person.getIdcity());
            ps.setString(4, person.getAddres());
            ps.setInt(5, person.getAge());
            ps.setString(6, person.getEmail());
            ps.setInt(7, person.getIdgender());
            ps.executeUpdate();
            try (ResultSet generatedkeys=ps.getGeneratedKeys()){
                if (generatedkeys.next()) {
                    int id = generatedkeys.getInt(1);
                    person.setId(id);
                }
                
            }         

        } catch (Exception e) {
            e.printStackTrace();
        }         
                    
        
    }


    @Override
    public void AsignPerson(PersonaSkill personaSkill) {
        String query = "INSERT INTO sgpzf.persons_skills (registration_date,iperson,idskill) VALUES (?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDate(1, personaSkill.getRegistrationDate());
            ps.setInt(2, personaSkill.getPersonId());
            ps.setInt(3, personaSkill.getSkillId());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void createSkill(Skill skill) {
        try {
            String query ="INSERT INTO sgpzf.skill (name) VALUES ?";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, skill.getName());
            ps.executeUpdate();
            try (ResultSet generatedkeys=ps.getGeneratedKeys()){
                if (generatedkeys.next()) {
                    int id = generatedkeys.getInt(1);
                    skill.setId(id);
                }
                
            }

          

        } catch (Exception e) {
            e.printStackTrace();
        }      


        
    }


    @Override
    public void findSkill(Skill skill) {
        try {
            String query ="SELECT  iperson FROM sgpzf.persons_skill WHERE idskill=? ";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1, skill.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                skill.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }


    @Override
    public void updatePerson(Person person) {
        try {
            String query="UPDATE persons SET (name,lastname,idcity,address,age,email) values(?,?,?,?,?,?)= WHERE id= ?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1, person.getName());
            ps.setString(2, person.getLastname());
            ps.setInt(3, person.getIdcity());
            ps.setString(4, person.getAddres());
            ps.setInt(5, person.getAge());
            ps.setString(6, person.getEmail());
            ps.setInt(7, person.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Person deletePerson(int id) {
        String query = "DELETE FROM sgpzf.persons WHERE id=?";
        Person person = null;

        try (PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(1,person.getId());          
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return person;

       
    }
   

    
       
}

