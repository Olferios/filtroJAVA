package filtro.persona.domain.entity;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int city;
    private String address;
    private int age;
    private String email;
    private int genero;
    
    public Persona() {
    }
    public Persona(int id, String nombre, String apellido, int city, String address, int age, String email,
            int genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.city = city;
        this.address = address;
        this.age = age;
        this.email = email;
        this.genero = genero;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getCity() {
        return city;
    }
    public void setCity(int city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getGenero() {
        return genero;
    }
    public void setGenero(int genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre='" + nombre + "'}";
    }

    

}
