package com.example.model.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a key/value text entry.  Has a direct link to the {@link Record} type.
 *
 * Example:
 *
 * key = Name
 * value = "Steve"
 *
 * There is no uniqueness of key/value storage.  So the following is also viable:
 *
 * Insert one:
 *  key = Name
 *  value = "Steve"
 * Insert two:
 *  key = Name
 *  value = "Steve"
 *
 */
@Entity
@Table(name="TEXTS")
public class Text implements Serializable {

    @JoinColumn(name="record_id")
    @Column(name="record_id")
    private String recordId;
    @Id
    @Column(name="text_id")
    private String textId;
    @Column(name="name")
    private String key;
    @Column
    private String value;
    @Column
    private int position;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Text{" +
                "recordId='" + recordId + '\'' +
                ", textId='" + textId + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (position != text.position) return false;
        if (key != null ? !key.equals(text.key) : text.key != null) return false;
        if (recordId != null ? !recordId.equals(text.recordId) : text.recordId != null) return false;
        if (textId != null ? !textId.equals(text.textId) : text.textId != null) return false;
        if (value != null ? !value.equals(text.value) : text.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId != null ? recordId.hashCode() : 0;
        result = 31 * result + (textId != null ? textId.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + position;
        return result;
    }
}
