package pl.weseleam.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

@Entity
@Table(name = "goście")
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gosc")
    private Long id;

    @Column(name = "imie1")
    private String firstName1;

    @Column(name = "nazwisko1")
    private String lastName1;

    @Column(name = "imie2")
    private String firstName2;

    @Column(name = "nazwisko2")
    private String lastName2;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "haslo")
    private String password;

    @OneToOne
    @JoinColumn(name = "id_details")
    private GuestDetails details;

    //@Transient
    //Random r = new Random();



    public Guest(){}

    public Guest(String firstName1, String lastName1){
        this.firstName1 = firstName1;
        this.lastName1 = lastName1;
        this.login = getLastName1() + getFirstName1() + ".06";
        this.password = getFirstName1() + ".2021";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public GuestDetails getDetails() {
        return details;
    }

    public void setDetails(GuestDetails details) {
        this.details = details;
    }
}