CREATE TABLE IF NOT EXISTS
    categories (
        category_id SERIAL,
        category_name VARCHAR,

        PRIMARY KEY (category_id)
);

CREATE TABLE IF NOT EXISTS
    status (
        status_id SERIAL,
        status_type VARCHAR,

        PRIMARY KEY (status_id)
);

CREATE TABLE IF NOT EXISTS
    discounts (
        discount_id SERIAL,
        discount_value DECIMAL,

        PRIMARY KEY (discount_id)
);

CREATE TABLE IF NOT EXISTS
    price_types (
        price_type_id SERIAL,
        price_type_value VARCHAR,

        PRIMARY KEY (price_type_id)
);

CREATE TABLE IF NOT EXISTS
    publish_houses (
        publish_house_id SERIAL,
        publish_house_name VARCHAR,

        PRIMARY KEY (publish_house_id)
);

CREATE TABLE IF NOT EXISTS
    books (
        book_id SERIAL,
        category_id INTEGER,
        status_id INTEGER,
        discount_id INTEGER,
        price_type_id INTEGER,
        publish_house_id INTEGER,
        stock_count INTEGER,
        icon_url VARCHAR,

        PRIMARY KEY (book_id),

    CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories (category_id),
    CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES status (status_id),
    CONSTRAINT fk_discount_id FOREIGN KEY (discount_id) REFERENCES discounts (discount_id),
    CONSTRAINT fk_price_type_id FOREIGN KEY (price_type_id) REFERENCES price_types (price_type_id),
    CONSTRAINT fk_publish_house_id FOREIGN KEY (publish_house_id) REFERENCES publish_houses (publish_house_id)

);


CREATE TABLE IF NOT EXISTS
    promotional_month (
        book_id INTEGER,
        discount_id INTEGER,

        PRIMARY KEY (book_id),

    CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES books (book_id),
    CONSTRAINT fk_discount_id FOREIGN KEY (discount_id) REFERENCES discounts (discount_id)
);

CREATE TABLE IF NOT EXISTS
    news_letters (
        book_id INTEGER,

        PRIMARY KEY (book_id),

    CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES books (book_id)
);
