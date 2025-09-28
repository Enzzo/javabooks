DROP TABLE IF EXISTS taco_order CASCADE;
DROP TABLE IF EXISTS taco;
DROP TABLE IF EXISTS ingredient_ref;
DROP TABLE IF EXISTS ingredient;

CREATE TABLE taco_order(
	id IDENTITY,
	delivery_name varchar(50) NOT NULL,
	delivery_street varchar(50) NOT NULL,
	delivery_city varchar(50) NOT NULL,
	delivery_state varchar(20) NOT NULL,
	delivery_zip varchar(10) NOT NULL,
	cc_number varchar(16) NOT NULL,
	cc_expiration varchar(5) NOT NULL,
	cc_cvv varchar(3) NOT NULL,
	placed_at timestamp NOT NULL,
	PRIMARY key(id)
);

CREATE TABLE taco(
	id IDENTITY,
	name varchar(50) NOT NULL,
	taco_order bigint NOT NULL,
	taco_order_key bigint NOT NULL,
	created_at timestamp NOT NULL,
	PRIMARY key(id)
);

CREATE TABLE ingredient_ref(
	ingredient varchar(4) NOT NULL,
	taco bigint NOT NULL,
	taco_key bigint NOT NULL
);

CREATE TABLE ingredient(
	id varchar(4) NOT NULL,
	name varchar(25) NOT NULL,
	TYPE varchar(10) NOT NULL,
	PRIMARY key(id)
);

ALTER TABLE taco
ADD FOREIGN KEY (taco_order) REFERENCES taco_order(id);

ALTER TABLE ingredient_ref
ADD FOREIGN KEY (ingredient) REFERENCES ingredient(id);