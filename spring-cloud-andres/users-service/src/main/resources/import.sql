INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');

INSERT INTO users (username, password, enabled, name, surname, email) VALUES ('admin', '12345', true, 'Admin', 'Admin', 'admin@email.com');
INSERT INTO users (username, password, enabled, name, surname, email) VALUES ('abel', '12345', true, 'Abel', 'Abel', 'abel@email.com');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
