package vn.scrip.buoi13_bvn.model;
public class Person {
    private Long id;
    private String name;
    private String gender;
    public Person() {

    }
    public Person(Long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}





