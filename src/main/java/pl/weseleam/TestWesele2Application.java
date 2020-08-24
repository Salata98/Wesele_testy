package pl.weseleam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.weseleam.dao.GuestDao;
import pl.weseleam.model.Guest;
import pl.weseleam.model.GuestDetails;

@SpringBootApplication
public class TestWesele2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(TestWesele2Application.class, args);

        GuestDao guestDao = ctx.getBean(GuestDao.class);
        Guest guest = new Guest("Magda", "Nowak");
        guestDao.save(guest);

        GuestDetails guestDetails = new GuestDetails();
        guest.setDetails(guestDetails);
        guestDao.update(guest);
    }

}
