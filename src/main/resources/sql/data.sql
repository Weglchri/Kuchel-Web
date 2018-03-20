INSERT INTO User(username, password, birthday) values ('bernhard', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1980-04-02');
INSERT INTO User(username, password, birthday) values ('wegl', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1969-01-02');
INSERT INTO User(username, password, birthday) values ('jasi', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1995-12-31');
INSERT INTO User(username, password, birthday) values ('admin', '$2a$10$ZY8AZ8Nkskn7mMdg8AKAAuHxdeJQmqO3bn6lPn7x0KW/Yogt7dlVy', '1992-12-02');


INSERT INTO Ingredient(name,status) VALUES ('Bananen','NEW');
INSERT INTO Ingredient(name,status) VALUES ('Feige','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Apfel','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Weintrauben','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Karotten','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Zucker','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Eier','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Olivenöl','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Vanilleschote','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Zimt','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Muskatnuss','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Lebkuchengewürz','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Salz','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Natron','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Mehl (glatt)','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Butter','APPROVED');
INSERT INTO Ingredient(name,status) VALUES ('Staubzucker','APPROVED');

INSERT INTO Recipe(name, user_id,duration,difficulty) VALUES ('Obstkuchen', 1,30,1);
INSERT INTO Recipe(name, user_id,duration,difficulty) VALUES ('Wiener Schnitzel', 2,40,3);
INSERT INTO Recipe(name, user_id,duration,difficulty) VALUES ('Karotten-Olivenölkuchen im Glas', 1,60,1);

INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Banane und Apfel mixen.',1,1);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Servieren.',2,1);

INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Schnitzel klopfen',1,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Panieren',2,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Fritieren',3,2);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Servieren',4,2);

INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Für den Karotten-Olivenölkuchen im Glas zunächst die Karotten mit Zucker in einer Schüssel gut vermischen. Eier mit einem Handmixer schaumig schlagen und untermengen. Olivenöl und Vanille hinzufügen. Gewürze und Natron zum Mehl geben und in die Eiermasse einrühren bis der Teig gut verbunden ist.',1,3);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Rexgläser mit handwarmer Butter gut ausfetten, die Masse bis zur Mitte der Gläser einfüllen und im vorgeheizten Backrohr bei 180 °C für ca. 20 bis 25 Minuten backen. Stäbchenprobe machen.',2,3);
INSERT INTO INSTRUCTION(INSTRUCTION_DESCRIPTION,step,recipe_id) VALUES ('Karotten-Olivenölkuchen im Glas mit Staubzucker bestreut servieren.',3,3);

INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY) VALUES (1,1,5);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (5,3,180,'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (6,3,110,'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (7,3,2,'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (8,3,180,'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (9,3,1,'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (10,3,1,'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (11,3,0.25,'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (12,3,0.5,'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (13,3,0.25,'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (14,3,0.5,'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (15,3,150,'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (16,3,null,null);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID,QUANTITY,QUALIFIER) VALUES (17,3,null,null);

INSERT INTO ROLE VALUES (1,'USER');
INSERT INTO ROLE VALUES (2,'ADMIN');

INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (1,2);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (2,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (3,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (4,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (4,2);
