package filtro.skill.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import filtro.persona.domain.entity.Persona;
import filtro.persona.domain.entity.PersonaSkill;
import filtro.skill.domain.entity.Skill;
import filtro.skill.domain.service.SkillService;

public class SkillRepository implements SkillService {
    private Connection connection;

    public SkillRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
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
    public void crearSkill(Skill skill) {
        try {
            String query = "INSERT INTO skill(name) VALUES(?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, skill.getNombre());
            ps.executeUpdate();

            try (ResultSet generatedkeys = ps.getGeneratedKeys()) {
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
    //public List<Skill> listarSkill(int id) {
        // List<Skill> listSkill = new ArrayList<>();
        // String query = "SELECT id, name FROM persons WHERE id=?";
        // Skill skill = null;
        // try (PreparedStatement ps = connection.prepareStatement(query)) {
        //     ps.setInt(1, id);
        //     ResultSet rs = ps.executeQuery();

        //     while (rs.next()) {
        //         skill = new Skill();
        //         skill.setId(rs.getInt("id"));
        //         skill.setNombre(rs.getString("name"));

        //         listSkill.add(skill);
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        // return listSkill;
        public List<Skill> listarSkill() {
            List<Skill> listSkill = new ArrayList<>();
            String query = "SELECT id, name FROM skill"; // Ajusta la tabla y las columnas según tu base de datos
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
    
                while (rs.next()) {
                    Skill skill = new Skill();
                    skill.setId(rs.getInt("id"));
                    skill.setNombre(rs.getString("name"));
    
                    listSkill.add(skill);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listSkill;
        }
    

    @Override
    public void asignarSkillPerson(PersonaSkill personaSkill) {
        try {
            String query = "INSERT INTO persons_skill(registration_date,iperson,idskill) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, personaSkill.getFecha());
            ps.setInt(2, personaSkill.getIdPersona());
            ps.setInt(3, personaSkill.getIdSkill());
            ps.executeUpdate();

            try (ResultSet generatedkeys = ps.getGeneratedKeys()) {
                if (generatedkeys.next()) {
                    int id = generatedkeys.getInt(1);
                    personaSkill.setId(id);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
  
}
