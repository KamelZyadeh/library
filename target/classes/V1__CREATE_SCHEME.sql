CREATE TABLE author(
	id bigserial primary key,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL
);

CREATE TABLE category(
	id bigserial PRIMARY KEY,
	category VARCHAR(30) NOT NULL
);

CREATE TABLE book(
	id bigserial PRIMARY KEY,
	author_id int NOT NULL,
	category_id int NOT NULL,
	tittle VARCHAR(30) NOT NULL,
	number_of_pages int not null,
	CONSTRAINT book_to_author_id FOREIGN KEY (author_id) REFERENCES author (id),
	CONSTRAINT book_to_category_id FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE address(
	id bigserial PRIMARY KEY,
	country VARCHAR(30) NOT NULL,
	region VARCHAR(30) NOT NULL,
	street VARCHAR(30) NOT NULL,
	apartment int NOT NULL
);

CREATE TABLE users(
	id bigserial PRIMARY KEY,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	phone_number VARCHAR(30) NOT NULL,
	status BOOLEAN NOT NULL,
	address_id int NOT NULL,
	CONSTRAINT user_to_address_id FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE TABLE transactions(
	id bigserial PRIMARY KEY,
	date VARCHAR(30) NOT NULL,
	price DECIMAL NOT NULL,
	user_id int NOT NULL,
	book_id int NOT NULL,
	CONSTRAINT transaction_to_user_id FOREIGN KEY (user_id) REFERENCES  users (id),
	CONSTRAINT transaction_to_book_id FOREIGN KEY (book_id) REFERENCES  book (id)
);

CREATE TABLE shelf(
	id bigserial PRIMARY KEY,
	book_id int NOT NULL,
	CONSTRAINT shelf_to_book_id FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE orders(
	id bigserial PRIMARY KEY,
	transactions_id int NOT NULL,
	book_id int NOT NULL,
	CONSTRAINT shelf_to_transaction_id FOREIGN KEY (transactions_id) REFERENCES transactions (id),
	CONSTRAINT shelf_to_book_id FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE closet(
	id bigserial PRIMARY KEY,
	shelf_id int NOT NULL,
	CONSTRAINT closet_to_shelf_id FOREIGN KEY (shelf_id) REFERENCES shelf (id)
);

CREATE TABLE library(
	id bigserial PRIMARY KEY,
	closet_id int NOT NULL,
	CONSTRAINT library_to_closet_id FOREIGN KEY (closet_id) REFERENCES closet (id)
);

CREATE TABLE basket(
	id bigserial PRIMARY KEY,
	book_id int NOT NULL,
	CONSTRAINT basket_to_book_id FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE account(
	id bigserial PRIMARY KEY,
	username VARCHAR(30) NOT NULL,
	password VARCHAR(30) NOT NULL,
	role VARCHAR(30) NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT account_to_user_id FOREIGN KEY (user_id) REFERENCES  users (id)
);