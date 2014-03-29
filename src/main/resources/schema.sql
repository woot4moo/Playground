--PostgreSQL dialect

CREATE TABLE records
(
    record_id uuid PRIMARY KEY NOT NULL
);

CREATE TABLE dates
(
    record_id uuid NOT NULL,
    date_id uuid PRIMARY KEY NOT NULL,
    since_epoch BIGINT NOT NULL,
    time TIMESTAMP NOT NULL,
    position INT NOT NULL,
    FOREIGN KEY ( record_id ) REFERENCES records ( record_id )
);
CREATE INDEX fki_record_dates_fk ON dates ( record_id );

CREATE TABLE texts
(
    record_id uuid NOT NULL,
    text_id uuid PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    value VARCHAR NOT NULL,
    position INT NOT NULL,
    FOREIGN KEY ( record_id ) REFERENCES records ( record_id )
);
CREATE INDEX fki_record_texts_fk ON texts ( record_id );
