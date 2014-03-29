package com.example.ejb;

import com.example.model.jpa.Text;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * DAO for handling information related to the TEXTS table.
 *
 * @see com.example.model.jpa.Text
 */
@Stateless
public class TextDAO {

    @PersistenceContext(unitName = "postgresDS")
    private EntityManager manager;

    public void persist(Text text){
        manager.persist(text);
    }

    public Collection<Text> getAllText(){
        TypedQuery<Text> query = manager.createQuery("select t from Text t",Text.class);
        return query.getResultList();
    }
}
