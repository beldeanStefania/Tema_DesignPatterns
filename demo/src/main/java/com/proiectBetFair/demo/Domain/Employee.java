package com.proiectBetFair.demo.Domain;
import com.proiectBetFair.demo.Factory.Laptop;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop")
    private Laptop laptop;
    String laptopType;

    public Employee() {

    }
    public Employee(String firstName, String lastName, String emailId, String laptopType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.laptopType = laptopType;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    public Laptop getLaptop() {
        return laptop;
    }
    public String getLaptopType() {
        return laptopType;
    }
    public void setLaptopType(String laptopType) {
        this.laptopType = laptopType;
    }
}
