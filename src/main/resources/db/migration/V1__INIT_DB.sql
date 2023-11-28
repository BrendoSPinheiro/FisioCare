CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE PATIENT_STATUS_ENUM AS ENUM ('pending', 'in_treatment', 'completed', 'cancelled', 'on_hold');

CREATE TYPE GENDER_ENUM AS ENUM ('male', 'female', 'non_binary', 'other');

CREATE TABLE IF NOT EXISTS tb_users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tb_patient_records (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    photo VARCHAR(255),
    birthdate DATE NOT NULL,
    gender GENDER_ENUM NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    address VARCHAR(100),
    number VARCHAR(5),
    complement VARCHAR(45),
    city VARCHAR(45),
    state VARCHAR(2),
    occupation VARCHAR(45) NOT NULL,
    clinical_diagnosis TEXT,
    complaint TEXT NOT NULL,
    hmp_hma TEXT,
    medications TEXT,
    complementary_exams TEXT,
    physical_exam TEXT,
    clinical_conduct TEXT,
    diagnosis TEXT,
    status PATIENT_STATUS_ENUM NOT NULL,
    uuid UUID NOT NULL UNIQUE DEFAULT uuid_generate_v4(),
    therapist_id INT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (therapist_id) REFERENCES tb_users(id)
);

CREATE TABLE IF NOT EXISTS tb_medias (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    size BIGINT,
    url VARCHAR(255) NOT NULL,
    patient_record_id INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_record_id) REFERENCES tb_patient_records(id)
);