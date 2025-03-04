package vn.scrip.buoi12_bvn.model;
public class People {
    private String fullName;
    private String job;
    private String city;
    private double salary;

    public People(String fullName, String job, String city, double salary) {
        this.fullName = fullName;
        this.job = job;
        this.city = city;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }
    public String getJob()
    {
        return job;
    }
    public String getCity() {
        return city;
    }
    public double getSalary() {
        return salary;
    }
}

