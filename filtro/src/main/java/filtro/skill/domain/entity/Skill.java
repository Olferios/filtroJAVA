package filtro.skill.domain.entity;

public class Skill {
    private int id;
    private String nombre;
    public Skill() {
    }
    public Skill(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    @Override
    public String toString() {
        return nombre; // Muestra solo el nombre de la habilidad
    }
    

}
