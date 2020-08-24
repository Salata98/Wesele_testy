package pl.weseleam.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.weseleam.model.Guest;
import pl.weseleam.model.GuestDetails;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class GuestDao {

    private EntityManager em;

    @Autowired
    public GuestDao(EntityManager em){
        this.em = em;
    }

    public Guest get(Long id){
        Guest guest = em.find(Guest.class, id);
        return guest;
    }

    public void save(Guest guest){
        GuestDetails gd = guest.getDetails();
        if(gd != null && gd.getId()==null) {
            em.persist(gd);
        }
        em.persist(guest);
    }

    public void update(Guest guest){
        GuestDetails gd = guest.getDetails();
        if (gd != null){
            gd = em.merge(gd);
            guest.setDetails(gd);
        } em.merge(guest);
    }

    public void delete(Guest guest){
        Guest guestToDelete = em.merge(guest);
        em.remove(guestToDelete.getDetails());
        em.remove(guestToDelete);
    }


}
