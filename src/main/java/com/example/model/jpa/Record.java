package com.example.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Represents the abstract container of a record.  A record allows us to link together attributes.
 *
 * <br />
 * Example:
 *
 * A record can consist of text values as well as dates.  The only appropriate way to link these
 * items back together is to ensure that the recordId field is common between the elements.
 *
 * a text has a recordId
 * a date has a recordId
 *
 * etc.
 *
 */
@Entity
@Table(name= "records")
public class Record implements Serializable{
    @Id
    @Column(name="record_id")
    private String recordId;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (recordId != null ? !recordId.equals(record.recordId) : record.recordId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return recordId != null ? recordId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId='" + recordId + '\'' +
                '}';
    }
}
