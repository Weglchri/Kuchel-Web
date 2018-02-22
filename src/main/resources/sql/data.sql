INSERT INTO User(username, password, birthday) values ('bernhard', 'pass', '1980-04-02');
INSERT INTO User(username, password, birthday) values ('wegl', 'pass', '1969-01-02');
INSERT INTO User(username, password, birthday) values ('jasi', 'salute99', '1995-12-31');

INSERT INTO Ingredient(name,description) VALUES ('Bananen','Frucht');
INSERT INTO Ingredient(name,description) VALUES ('Feige','Frucht');
INSERT INTO Ingredient(name,description) VALUES ('Apfel','Frucht');
INSERT INTO Ingredient(name,description) VALUES ('Weintrauben','Frucht');

INSERT INTO Recipe(name,instruction) VALUES ('Obstkuchen','Banane und Apfel mixen.');

INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID,RECIPE_ID) VALUES (1,1);