CREATE TABLE cars (
    car_id BIGINT NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    gender ENUM('Male', 'Female', 'Nonbinary') NOT NULL,
    country varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    street_number varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    credit_card_type varchar(255) NOT NULL,
    credit_card BIGINT NOT NULL,
    currency varchar(255) NOT NULL,
    ethnicity  varchar(255) NOT NULL,
    car_make varchar(255) NOT NULL,
    car_model varchar(255) NOT NULL,
    car_model_year INT NOT NULL,
    car_vin varchar(255) NOT NULL,
    PRIMARY KEY (car_id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
