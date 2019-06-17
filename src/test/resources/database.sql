CREATE SCHEMA IF NOT EXISTS transfer_api;

CREATE TABLE IF NOT EXISTS transfer_api.account (
    id int NOT NULL IDENTITY PRIMARY KEY,
    amount VARCHAR(255),
    currency VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS transfer_api.transfer (
    id int NOT NULL IDENTITY PRIMARY KEY,
    sender int NOT NULL,
    receiver int NOT NULL,
    amount VARCHAR(255),
    currency VARCHAR(32),
    status VARCHAR(16) NOT NULL,

    FOREIGN KEY (sender) REFERENCES transfer_api.account (id),
    FOREIGN KEY (receiver) REFERENCES transfer_api.account (id)
);

INSERT INTO transfer_api.account VALUES (1, '500.0', 'RUB') ON DUPLICATE KEY UPDATE amount = '500.0';
INSERT INTO transfer_api.account VALUES (2, '300.0', 'RUB') ON DUPLICATE KEY UPDATE amount = '300.0';
INSERT IGNORE INTO transfer_api.transfer VALUES (1, 1, 2, '100.0', 'RUB', 'ERROR');