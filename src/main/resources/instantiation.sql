CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
    );

INSERT INTO users (username, password, role) VALUES
                                                 ('john_doe', 'password123', 'ROLE_USER'),
                                                 ('jane_smith', 'securePass!1', 'ROLE_ADMIN'),
                                                 ('alice_jones', 'passAlice2023', 'ROLE_USER'),
                                                 ('bob_brown', 'bobSecure#9', 'ROLE_USER'),
                                                 ('charlie_clark', 'charlie789', 'ROLE_MODERATOR'),
                                                 ('david_evans', 'david!pass123', 'ROLE_USER'),
                                                 ('emma_white', 'emma2023pass', 'ROLE_ADMIN'),
                                                 ('frank_wright', 'franklySecure1', 'ROLE_USER'),
                                                 ('grace_king', 'gracePass$5', 'ROLE_USER'),
                                                 ('henry_hill', 'henrySecure*7', 'ROLE_MODERATOR');