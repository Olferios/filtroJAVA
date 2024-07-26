package filtro.persona.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import filtro.persona.aplication.entity.Person;
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
        String query = "INSERT INTO sgpzf.persons (name,lastname,idcity,address,age,email,idgender) VALUES (?,?,?,?,?,?,?,)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, person.getName());
            ps.setString(2, person.getLastname());
            ps.setInt(3, person.getIdcity());
            ps.setString(4, person.getAddres());
            ps.setInt(5, person.getAge());
            ps.setString(6, person.getEmail());
            ps.setInt(7, person.getIdgender());
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}

   