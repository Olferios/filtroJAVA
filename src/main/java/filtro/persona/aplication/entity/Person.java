package filtro.persona.aplication.entity;

public class Person {
    private String name;
    private String lastname;
    private int idcity;
    private String addres;
    private int age;
    private String email;
    private int idgender;
    public Person(String name, String lastname, int idcity, String addres, int age, String email, int idgender) {
        this.name = name;
        this.lastname = lastname;
        this.idcity = idcity;
        this.addres = addres;
        this.age = age;
        this.email = email;
        this.idgender = idgender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getIdcity() {
        return idcity;
    }
    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }
    public String getAddres() {
        return addres;
    }
    public void setAddres(String addres) {
        this.addres = addres;
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
    public int getIdgender() {
        return idgender;
    }
    public void setIdgender(int idgender) {
        this.idgender = idgender;
    }

    
}
