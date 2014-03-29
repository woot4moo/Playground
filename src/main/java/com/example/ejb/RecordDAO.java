package com.example.ejb;

import com.example.model.jpa.Record;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for persisting records into the system.
 * @see com.example.model.jpa.Record
 */
@Stateless
public class RecordDAO {

    @PersistenceContext(unitName = "postgresDS")
    private EntityManager manager;

    public void persist(Record record){
        manager.persist(record);
    }
}
