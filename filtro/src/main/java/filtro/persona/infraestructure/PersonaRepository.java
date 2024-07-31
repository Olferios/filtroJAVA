package filtro.persona.infraestructure;

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
import filtro.persona.domain.service.PersonaService;
import filtro.skill.domain.entity.Skill;

public class PersonaRepository implements PersonaService {
    private Connection connection;

    public PersonaRepository() {
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
    public void crearPersona(Persona persona) {
        try {
            String query = "INSERT INTO persons(name,lastname,idcity,adddress,age,email,idgender) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, persona.getCity());
            ps.setString(4, persona.getAddress());
            ps.setInt(5, persona.getAge());
            ps.setString(6, persona.getEmail());
            ps.setInt(7, persona.getGenero());

            ps.executeUpdate();

            try (ResultSet generatedkeys = ps.getGeneratedKeys()) {
                if (generatedkeys.next()) {
                    int id = generatedkeys.getInt(1);
                    persona.setId(id);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actualizarPersona(Persona persona) {
        try {
            String query = "UPDATE persons set name=?, lastname=?, idcity=?, adddress=?, age=?, email=?, idgender=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, persona.getCity());
            ps.setString(4, persona.getAddress());
            ps.setInt(5, persona.getAge());
            ps.setString(6, persona.getEmail());
            ps.setInt(7, persona.getGenero());
            ps.setInt(8, persona.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona findPersonaId(int id) {
        Persona persona = null;
        try {
            String query = "SELECT name, lastname FROM persons WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt(id));
                persona.setNombre(rs.getString("name"));
                persona.setApellido(rs.getString("lastname"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persona;

    }

    @Override
    public void eliminarPersonaId(int id) {

        String query = "DELETE FROM persons where id=?";
       
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        
    }

    @Override
    public void eliminarPersonsSkill(int id) {
        String query = "DELETE FROM persons_skill where id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> listpersonas = new ArrayList<>();
        String query = "SELECT id, name FROM persons";
        //Persona persona= null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
    
                while (rs.next()) {
                    Persona persona = new Persona();
                    persona.setId(rs.getInt("id"));
                    persona.setNombre(rs.getString("name"));
    
                    listpersonas.add(persona);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listpersonas;
        
        
    }

    

}
