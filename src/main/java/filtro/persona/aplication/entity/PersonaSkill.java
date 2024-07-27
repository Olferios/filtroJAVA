package filtro.persona.aplication.entity;

import java.sql.Date;

public class PersonaSkill {
    private int id;
    private Date registrationDate;
    private int personId;
    private int skillId;
    public PersonaSkill() {
    }
    public PersonaSkill(int id, Date registrationDate, int personId, int skillId) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.personId = personId;
        this.skillId = skillId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public int getSkillId() {
        return skillId;
    }
    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
    


}
