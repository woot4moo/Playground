package com.example.model.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class TextTest {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Postgres");
        EntityManager manager = factory.createEntityManager();

        Query textQuery = manager.createQuery("select t from Text t");
        List<Text> texts = textQuery.getResultList();
        for(Text text : texts){
            System.out.println(text);
        }
        System.out.println(textQuery.getResultList().size());

        Query recordQuery = manager.createQuery("select r from Record r");
        Record record = (Record) recordQuery.setMaxResults(1).getResultList().get(0);
        System.out.println("Record: " + record);
        manager.getTransaction().begin();
        Record recordToInsert = new Record();
        recordToInsert.setRecordId(UUID.randomUUID().toString());
        manager.persist(recordToInsert);

        Text text = new Text();
        text.setRecordId(recordToInsert.getRecordId());
        text.setTextId(UUID.randomUUID().toString());
        text.setKey("name");
        text.setValue("Tim");
        text.setPosition(1);

        manager.persist(text);
        manager.getTransaction().commit();
        manager.close();
    }
}
