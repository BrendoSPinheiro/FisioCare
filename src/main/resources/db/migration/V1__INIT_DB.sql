CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS tb_patient_records (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    photo VARCHAR(255),
    birthdate DATE,
    gender CHAR(1),
    zip_code VARCHAR(10) NOT NULL,
    address VARCHAR(100),
    number VARCHAR(5),
    complement VARCHAR(45),
    city VARCHAR(45),
    state VARCHAR(45),
    occupation VARCHAR(45) NOT NULL,
    clinical_diagnosis TEXT,
    complaint TEXT,
    hmp_hma TEXT,
    medications TEXT,
    complementary_exams TEXT,
    physical_exam TEXT,
    clinical_conduct TEXT,
    diagnosis TEXT,
    uuid UUID NOT NULL UNIQUE DEFAULT uuid_generate_v4(),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tb_users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    username VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tb_medias (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    url VARCHAR(255) NOT NULL,
    patient_record_id INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_record_id) REFERENCES tb_patient_records(id)
);