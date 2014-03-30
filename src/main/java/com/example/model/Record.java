package com.example.model;

import javax.xml.bind.annotation.*;
import java.util.Collection;

/**
 * Container type to hold a dynamically defined record.
 *
 * @see com.example.model.Text
 */
@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
public final class Record {
    @XmlElementWrapper(name="texts")
    @XmlElement(name="text")
    Collection<Text> texts;

    public Collection<Text> getTexts() {
        return texts;
    }

    public void setTexts(Collection<Text> texts) {
        this.texts = texts;
    }

    public Record(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (texts != null ? !texts.equals(record.texts) : record.texts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return texts != null ? texts.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Record{" +
                "texts=" + texts +
                '}';
    }
}
