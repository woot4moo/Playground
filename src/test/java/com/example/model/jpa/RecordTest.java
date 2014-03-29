package com.example.model.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class RecordTest {


    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Postgres");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select r from Record r");
        List<Record> records = query.getResultList();
        for(Record record : records){
            System.out.println(record);
        }
        System.out.println(query.getResultList().size());

        manager.getTransaction().begin();
        Record record = new Record();
        record.setRecordId(UUID.randomUUID().toString());
        manager.persist(record);
        manager.getTransaction().commit();
        manager.close();
    }
}
