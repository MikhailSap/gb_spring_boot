INSERT INTO usrs (name, password) VALUES ('Vasya', '$2y$12$c.mZFwZDOgHxONNkdrBGZ.rmbDy11VjoVzjRLwlqrEsaiIcts3EYq');
INSERT INTO usrs (name, password) VALUES ('Goga', '$2y$12$PCaSxA3F1lAHYrkjrRCuJOFezLkA.93cRZKtmnXBFDrwfI0PstW.q');
INSERT INTO usrs (name, password) VALUES ('Mike', '$2y$12$csk0uCD8oHcknD5DhFOVNevdPuKh4vm7IJY9H8xGPGbJFpWocQFCi');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_MANAGER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_SUPERADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);




