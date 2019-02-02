INSERT INTO User (username, password, birthday)
VALUES ('bernhard', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1980-04-02');
INSERT INTO User (username, password, birthday)
VALUES ('wegl', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1969-01-02');
INSERT INTO User (username, password, birthday)
VALUES ('jasi', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1995-12-31');
INSERT INTO User (username, password, birthday)
VALUES ('admin', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1992-12-02');

INSERT INTO ROLE VALUES (1, 'USER');
INSERT INTO ROLE VALUES (2, 'ADMIN');

INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (2, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (3, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (4, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (4, 2);