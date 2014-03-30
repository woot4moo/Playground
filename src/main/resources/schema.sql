--PostgreSQL dialect

CREATE TABLE records
(
  record_id VARCHAR PRIMARY KEY NOT NULL
);

CREATE TABLE dates
(
  date_id VARCHAR PRIMARY KEY NOT NULL,
  record_id VARCHAR NOT NULL,
  since_epoch BIGINT NOT NULL,
  time TIMESTAMP NOT NULL,
  position INT NOT NULL,
  FOREIGN KEY ( record_id ) REFERENCES records ( record_id )
);
CREATE INDEX fki_dates_record_fk ON dates ( record_id );

CREATE TABLE texts
(
  text_id VARCHAR PRIMARY KEY NOT NULL,
  record_id VARCHAR NOT NULL,
  name VARCHAR NOT NULL,
  value VARCHAR NOT NULL,
  position INT NOT NULL,
  FOREIGN KEY ( record_id ) REFERENCES records ( record_id )
);
CREATE INDEX fki_texts_record_fk ON texts ( record_id );

CREATE TABLE binaries
(
  record_id VARCHAR NOT NULL,
  binary_id VARCHAR PRIMARY KEY NOT NULL,
  name VARCHAR NOT NULL,
  content BYTEA NOT NULL,
  position INT NOT NULL
);

CREATE TABLE booleans
(
  record_id VARCHAR NOT NULL,
  boolean_id VARCHAR PRIMARY KEY NOT NULL,
  value VARCHAR NOT NULL,
  position INT NOT NULL
);

CREATE TABLE numerics
(
  record_id VARCHAR NOT NULL,
  numeric_id VARCHAR PRIMARY KEY NOT NULL,
  decimal BIGINT NOT NULL,
  number VARCHAR NOT NULL,
  base VARCHAR NOT NULL,
  position INT NOT NULL
);

CREATE TABLE selections
(
  record_id VARCHAR NOT NULL,
  selection_id VARCHAR PRIMARY KEY NOT NULL,
  label VARCHAR NOT NULL,
  value VARCHAR NOT NULL,
  position INT NOT NULL,
  FOREIGN KEY ( record_id ) REFERENCES records ( record_id )
);
CREATE INDEX fki_selections_records_fk ON selections ( record_id );
