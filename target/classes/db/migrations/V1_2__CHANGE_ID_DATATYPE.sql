CREATE SEQUENCE id_seq START WITH 1 INCREMENT BY 1;

ALTER TABLE categories ALTER COLUMN category_id TYPE BIGINT;
ALTER TABLE categories ALTER COLUMN category_id SET NOT NULL;
ALTER TABLE categories ALTER COLUMN category_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY categories.category_id;

ALTER TABLE status ALTER COLUMN status_id TYPE BIGINT;
ALTER TABLE status ALTER COLUMN status_id SET NOT NULL;
ALTER TABLE status ALTER COLUMN status_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY status.status_id;

ALTER TABLE discounts ALTER COLUMN discount_id TYPE BIGINT;
ALTER TABLE discounts ALTER COLUMN discount_id SET NOT NULL;
ALTER TABLE discounts ALTER COLUMN discount_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY discounts.discount_id;

ALTER TABLE price_types ALTER COLUMN price_type_id TYPE BIGINT;
ALTER TABLE price_types ALTER COLUMN price_type_id SET NOT NULL;
ALTER TABLE price_types ALTER COLUMN price_type_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY price_types.price_type_id;

ALTER TABLE publish_houses ALTER COLUMN publish_house_id TYPE BIGINT;
ALTER TABLE publish_houses ALTER COLUMN publish_house_id SET NOT NULL;
ALTER TABLE publish_houses ALTER COLUMN publish_house_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY publish_houses.publish_house_id;

ALTER TABLE books ALTER COLUMN book_id TYPE BIGINT;
ALTER TABLE books ALTER COLUMN book_id SET NOT NULL;
ALTER TABLE books ALTER COLUMN book_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY books.book_id;

ALTER TABLE promotional_month ALTER COLUMN book_id TYPE BIGINT;
ALTER TABLE promotional_month ALTER COLUMN book_id SET NOT NULL;
ALTER TABLE promotional_month ALTER COLUMN book_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY promotional_month.book_id;

ALTER TABLE authors ALTER COLUMN author_id TYPE BIGINT;
ALTER TABLE authors ALTER COLUMN author_id SET NOT NULL;
ALTER TABLE authors ALTER COLUMN author_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY authors.author_id;

ALTER TABLE news_letters ALTER COLUMN book_id TYPE BIGINT;
ALTER TABLE news_letters ALTER COLUMN book_id SET NOT NULL;
ALTER TABLE news_letters ALTER COLUMN book_id SET DEFAULT nextval('id_seq'::regclass);
ALTER SEQUENCE id_seq OWNED BY news_letters.book_id;
