CREATE SCHEMA transfer_api;

CREATE TABLE transfer_api.account (
    id int NOT NULL IDENTITY PRIMARY KEY,
    amount VARCHAR(255),
    currency VARCHAR(32)
);

CREATE TABLE transfer_api.transfer (
    id int NOT NULL IDENTITY PRIMARY KEY,
    sender int NOT NULL,
    receiver int NOT NULL,
    amount VARCHAR(255),
    currency VARCHAR(32),

    FOREIGN KEY (sender) REFERENCES transfer_api.account (id),
    FOREIGN KEY (receiver) REFERENCES transfer_api.account (id)
);

INSERT INTO transfer_api.account VALUES (1, '500.0', 'RUB');
INSERT INTO transfer_api.account VALUES (2, '300.0', 'RUB');