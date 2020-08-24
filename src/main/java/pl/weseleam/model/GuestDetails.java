package pl.weseleam.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Dodatkowe informacje")
public class GuestDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_szczegóły")
    private Long id;

    @Column(name = "menu")
    private Menu menu;

    @Column(name = "nocleg")
    private boolean accommodation;

    @Column(name = "imię_os_tow")
    private String firstNameT;

    @Column(name = "nazwisko_os_tow")
    private String lastNameT;

    @Column(name = "obecność")
    private boolean confirm;

    @Column(name = "poprawiny")
    private boolean secondDay;

    @OneToOne(mappedBy = "details") //cascade = CascadeType.ALL?
    private Guest guest;



    public GuestDetails(){}

    public GuestDetails(Menu menu){

        this.menu = menu;
        this.accommodation = false;
        this.confirm = false;
        this.secondDay = false;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    public boolean isAccommodation() {
        return accommodation;
    }

    public void setAccommodation(boolean accommodation) {
        this.accommodation = accommodation;
    }

    public String getFirstNameT() {
        return firstNameT;
    }

    public void setFirstNameT(String firstNameT) {
        this.firstNameT = firstNameT;
    }

    public String getLastNameT() {
        return lastNameT;
    }

    public void setLastNameT(String lastNameT) {
        this.lastNameT = lastNameT;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isSecondDay() {
        return secondDay;
    }

    public void setSecondDay(boolean secondDay) {
        this.secondDay = secondDay;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
