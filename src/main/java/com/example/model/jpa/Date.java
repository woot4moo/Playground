package com.example.model.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a date / time field.  This class will record but a timestamp as well as a numeric to
 * determine how long it has been since the epoch.  This should facilitate more efficient
 * date / time queries at a higher level
 */
@Entity
@Table(name="DATES")
public class Date implements Serializable {
    @JoinColumn(name="record_id")
    @Column(name="record_id")
    private String recordId;
    @Id
    @Column(name="date_id")
    private String dateId;
    @Column(name="since_epoch")
    private Long sinceEpoch;
    @Column
    private java.util.Date time;
    @Column
    private int position;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public Long getSinceEpoch() {
        return sinceEpoch;
    }

    public void setSinceEpoch(Long sinceEpoch) {
        this.sinceEpoch = sinceEpoch;
    }

    public java.util.Date getTime() {
        return new java.util.Date(time.getTime());
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        if (position != date.position) return false;
        if (dateId != null ? !dateId.equals(date.dateId) : date.dateId != null) return false;
        if (recordId != null ? !recordId.equals(date.recordId) : date.recordId != null) return false;
        if (sinceEpoch != null ? !sinceEpoch.equals(date.sinceEpoch) : date.sinceEpoch != null) return false;
        if (time != null ? !time.equals(date.time) : date.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId != null ? recordId.hashCode() : 0;
        result = 31 * result + (dateId != null ? dateId.hashCode() : 0);
        result = 31 * result + (sinceEpoch != null ? sinceEpoch.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + position;
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "recordId='" + recordId + '\'' +
                ", dateId='" + dateId + '\'' +
                ", sinceEpoch=" + sinceEpoch +
                ", time=" + time +
                ", position=" + position +
                '}';
    }
}
