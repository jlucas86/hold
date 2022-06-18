package com.example.FoodMap.componets.users;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

@Entity(name = "users")
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name = "", columnNames = "email" )
    }
)
public class users {
    /*@Id
    @SequenceGenerator(name="webuser_idwebuser_seq",
                       sequenceName="webuser_idwebuser_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="webuser_idwebuser_seq")
    @Column(name = "idwebuser", updatable=false)*/
    
    @Id
    @Column(columnDefinition = "serial", 
        name = "id", 
        nullable = false, 
        updatable = false
    )
    @SequenceGenerator(
        name= "users_sequence",
        sequenceName = "users_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "users_sequence"
    )
    private Long id;

    @Column(
        name="email",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String email;

    @Column(
        name="user_name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String user_name;

    @Column(
        name="avalability",
        nullable = false,
        columnDefinition = "BIT"
    )
    private int avalability;

    @Column(
        name="role",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String role;

    @Column(
        name="password",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String password;

    public users() {
    }

    public users(Long id, String email, String user_name, int avalability, String role, String password) {
        this.id = id;
        this.email = email;
        this.user_name = user_name;
        this.avalability = avalability;
        this.role = role;
        this.password = password;
    }

    public users( String email, String user_name, int avalability, String role, String password) {
        this.email = email;
        this.user_name = user_name;
        this.avalability = avalability;
        this.role = role;
        this.password = password;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAvalability() {
        return this.avalability;
    }

    public void setAvalability(int avalability) {
        this.avalability = avalability;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
