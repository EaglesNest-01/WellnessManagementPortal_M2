package model;

public class Counselor {
    private String empId;
    private String name;
    private String specialization;
    private String availability;

    public Counselor() {}

    public Counselor(String empId, String name, String specialization, String availability) {
        this.empId = empId;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}

