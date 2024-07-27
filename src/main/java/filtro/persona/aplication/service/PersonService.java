package filtro.persona.aplication.service;

import filtro.persona.aplication.entity.Person;
import filtro.persona.aplication.entity.PersonaSkill;
import filtro.persona.aplication.entity.Skill;

public interface PersonService {

    void createPerson(Person person);
    void AsignPerson(PersonaSkill personaSkill);
    void createSkill(Skill skill);
    void findSkill (Skill skill);
    void updatePerson(Person person);
    Person deletePerson(int id);
    

}
