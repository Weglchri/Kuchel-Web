INSERT INTO User(username, password, birthday) values ('bernhard', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1980-04-02');
INSERT INTO User(username, password, birthday) values ('wegl', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1969-01-02');
INSERT INTO User(username, password, birthday) values ('jasi', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1995-12-31');
INSERT INTO User(username, password, birthday) values ('admin', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1992-12-02');


INSERT INTO Ingredient(name,description,status) VALUES ('Bananen','Frucht','NEW');
INSERT INTO Ingredient(name,description,status) VALUES ('Feige','Frucht','APPROVED');
INSERT INTO Ingredient(name,description,status) VALUES ('Apfel','Frucht','APPROVED');
INSERT INTO Ingredient(name,description,status) VALUES ('Weintrauben','Frucht','APPROVED');

INSERT INTO Recipe(name, user_id) VALUES ('Obstkuchen', 1);
INSERT INTO Recipe(name, user_id) VALUES ('Wiener Schnitzel', 2);

INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Banane und Apfel mixen.',1,1);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Servieren.',2,1);

INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Schnitzel klopfen',1,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Panieren',2,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Fritieren',3,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Servieren',4,2);


INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID) VALUES (1,1);

INSERT INTO ROLE VALUES (1,'USER');
INSERT INTO ROLE VALUES (2,'ADMIN');

INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (1,2);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (2,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (3,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (4,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (4,2);

