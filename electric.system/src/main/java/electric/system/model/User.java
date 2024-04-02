package electric.system.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surName;
    private String firstName;
    private String email;
    private String password;

    // Constructors

    // Default constructor
    public User() {
    }

    // Constructor with parameters
    public User(String surName, String firstName, String email, String password) {
        this.surName = surName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    // Constructor with all fields including ID
    public User(Long id, String surName, String firstName, String email, String password) {
        this.id = id;
        this.surName = surName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
