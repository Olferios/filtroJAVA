package filtro.persona.domain.entity;

public class PersonaSkill {
    private int id;
    private String fecha;
    private int idPersona;
    private int idSkill;
    
    public PersonaSkill() {
    }

    public PersonaSkill(int id, String fecha, int idPersona, int idSkill) {
        this.id = id;
        this.fecha = fecha;
        this.idPersona = idPersona;
        this.idSkill = idSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }
    

}
