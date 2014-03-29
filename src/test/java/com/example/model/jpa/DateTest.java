package com.example.model.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class DateTest {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Postgres");
        EntityManager manager = factory.createEntityManager();

        Query dateQuery = manager.createQuery("select d from Date d");
        List<Date> dates = dateQuery.getResultList();
        for(Date date : dates){
            System.out.println(date);
        }
        System.out.println(dateQuery.getResultList().size());

        Query recordQuery = manager.createQuery("select r from Record r");
        Record record = (Record) recordQuery.setMaxResults(1).getResultList().get(0);
        System.out.println("Record: " + record);
        manager.getTransaction().begin();
        Record recordToInsert = new Record();
        recordToInsert.setRecordId(UUID.randomUUID().toString());
        manager.persist(recordToInsert);

        Date date = new Date();
        date.setRecordId(recordToInsert.getRecordId());
        date.setDateId(UUID.randomUUID().toString());
        java.util.Date timestamp = new java.util.Date();
        date.setSinceEpoch(timestamp.getTime());
        date.setTime(timestamp);
        date.setPosition(1);
        manager.persist(date);
        manager.getTransaction().commit();
        manager.close();
    }
}
