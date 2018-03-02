INSERT INTO User(username, password, birthday) values ('bernhard', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1980-04-02');
INSERT INTO User(username, password, birthday) values ('wegl', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1969-01-02');
INSERT INTO User(username, password, birthday) values ('jasi', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1995-12-31');

INSERT INTO Ingredient(name,description,status) VALUES ('Bananen','Frucht','NEW');
INSERT INTO Ingredient(name,description) VALUES ('Feige','Frucht');
INSERT INTO Ingredient(name,description) VALUES ('Apfel','Frucht');
INSERT INTO Ingredient(name,description) VALUES ('Weintrauben','Frucht');

INSERT INTO Recipe(name) VALUES ('Obstkuchen');
INSERT INTO Recipe(name) VALUES ('Wiener Schnitzel');

INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Banane und Apfel mixen.',1,1);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Servieren.',2,1);

INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Schnitzel klopfen',1,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Panieren',2,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Fritieren',3,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Servieren',4,2);


INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID) VALUES (1,1);

INSERT INTO ROLE VALUES (1,'USER');

INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (2,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (3,1);

