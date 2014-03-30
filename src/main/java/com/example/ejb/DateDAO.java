package com.example.ejb;

import com.example.model.jpa.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Stateless
/**
 * DAO for interactions with date/ time
 *
 * @see com.example.model.jpa.Date
 */
public class DateDAO {

    @PersistenceContext(unitName = "postgresDS")
    private EntityManager manager;

    public void persist(Date date) {
        manager.persist(date);
    }

    public Collection<Date> getAllDates() {
        TypedQuery<Date> query = manager.createQuery("select d from Date d", Date.class);
        return query.getResultList();
    }
}
