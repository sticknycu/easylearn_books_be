CREATE TABLE IF NOT EXISTS
    authors (
        author_id BIGSERIAL,
        author_name VARCHAR,

        PRIMARY KEY (author_id)
);

ALTER TABLE books
    ADD COLUMN author_id INTEGER,
    ADD CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES authors (author_id);
