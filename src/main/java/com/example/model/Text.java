package com.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model to allow for conversions from the service layer.
 *
 * @see com.example.service.rest.RecordService
 */
@XmlRootElement(name="text")
@XmlAccessorType(XmlAccessType.FIELD)
public final class Text {

    private String recordId;
    private String textId;
    private String name;
    private String value;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (position != text.position) return false;
        if (name != null ? !name.equals(text.name) : text.name != null) return false;
        if (recordId != null ? !recordId.equals(text.recordId) : text.recordId != null) return false;
        if (textId != null ? !textId.equals(text.textId) : text.textId != null) return false;
        if (value != null ? !value.equals(text.value) : text.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId != null ? recordId.hashCode() : 0;
        result = 31 * result + (textId != null ? textId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + position;
        return result;
    }

    @Override
    public String toString() {
        return "Text{" +
                "recordId='" + recordId + '\'' +
                ", textId='" + textId + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", position=" + position +
                '}';
    }
}
