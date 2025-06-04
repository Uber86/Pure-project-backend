-- liquibase formatted sql

-- changeset oss:1
CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    birthday DATE,
    sex VARCHAR(20),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    google_account_linked BOOLEAN DEFAULT FALSE
);

-- changeset oss:2
CREATE TABLE profile(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    bio VARCHAR(350),
    search VARCHAR(50),
    CONSTRAINT fk_profile_user FOREIGN KEY (user_id)
    REFERENCES users(id) ON DELETE CASCADE
);

-- changeset oss:3
CREATE TABLE profile_image(
    profile_id BIGINT NOT NULL,
    image_url VARCHAR(500) NOT NULL,
    CONSTRAINT fk_image_profile FOREIGN KEY (profile_id)
    REFERENCES profile(id) ON DELETE CASCADE
);

-- changeset oss:4
CREATE TABLE profile_temptation(
    profile_id BIGINT NOT NULL,
    temptation VARCHAR(50) NOT NULL,
    CONSTRAINT fk_temptation_profile FOREIGN KEY (profile_id)
    REFERENCES profile(id) ON DELETE CASCADE
);

-- changeset oss:5
CREATE TABLE chat(
    id BIGSERIAL PRIMARY KEY
);

-- changeset oss:6
CREATE TABLE chat_participants(
    chat_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_chat_participants_chat FOREIGN KEY (chat_id)
    REFERENCES chat(id) ON DELETE CASCADE,
    CONSTRAINT fk_chat_participants_user FOREIGN KEY (user_id)
    REFERENCES users(id) ON DELETE CASCADE,
    PRIMARY KEY (chat_id, user_id)
);

-- changeset oss:7
CREATE TABLE message(
    id BIGSERIAL PRIMARY KEY,
    chat_id BIGINT NOT NULL,
    sender_id BIGINT NOT NULL,
    content TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_message_chat FOREIGN KEY (chat_id)
    REFERENCES chat(id) ON DELETE CASCADE,
    CONSTRAINT fk_sender_user FOREIGN KEY (sender_id)
    REFERENCES users(id) ON DELETE CASCADE
);

-- changeset oss:8
ALTER TABLE profile ADD COLUMN height INTEGER;



