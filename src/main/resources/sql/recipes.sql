INSERT INTO Ingredient (name, status) VALUES ('Bananen', 'NEW');
INSERT INTO Ingredient (name, status) VALUES ('Feige', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Apfel', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Weintrauben', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Karotten', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Zucker', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Eier', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Olivenöl', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Vanilleschote', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Zimt', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Muskatnuss', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Lebkuchengewürz', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Salz', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Natron', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Mehl (glatt)', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Butter', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Staubzucker', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Kartoffeln', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Hühnerfilet', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Lauch', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Bauchspeck', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Parmesan', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Pfeffer', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Kümmel', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Hühnerbrustfilet', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Frühlingszwiebeln', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Knoblauchzehen', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Ingwer', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Chilischote (grün)', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Zuckerschoten', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Erdnussöl', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Koriander (gemahlen)', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Kreuzkümmel (gemahlen)', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Kurkuma (gemahlen)', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Garam masala', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Hühnersuppe', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Rinderfleisch', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Tomaten', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Zwiebeln', 'APPROVED');
INSERT INTO Ingredient (name, status) VALUES ('Salat', 'APPROVED');


-- Karotten-Olivenölkuchen im Glas
INSERT INTO Recipe (name, user_id, duration, difficulty, modified_date, CREATION_DATE)
VALUES ('Karotten-Olivenölkuchen im Glas', 1, 60, 1, parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'),
        parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY) VALUES (1, 1, 5);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (5, 1, 180, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (6, 1, 110, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (7, 1, 2, 'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (8, 1, 180, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (9, 1, 1, 'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (10, 1, 1, 'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (11, 1, 0.25, 'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (12, 1, 0.5, 'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (13, 1, 0.25, 'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (14, 1, 0.5, 'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (15, 1, 150, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (16, 1, NULL, NULL);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (17, 1, NULL, NULL);

INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id) VALUES (
  'Für den Karotten-Olivenölkuchen im Glas zunächst die Karotten mit Zucker in einer Schüssel gut vermischen. Eier mit einem Handmixer schaumig schlagen und untermengen. Olivenöl und Vanille hinzufügen. Gewürze und Natron zum Mehl geben und in die Eiermasse einrühren bis der Teig gut verbunden ist.',
  1, 1);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id) VALUES (
  'Rexgläser mit handwarmer Butter gut ausfetten, die Masse bis zur Mitte der Gläser einfüllen und im vorgeheizten Backrohr bei 180 °C für ca. 20 bis 25 Minuten backen. Stäbchenprobe machen.',
  2, 1);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES ('Karotten-Olivenölkuchen im Glas mit Staubzucker bestreut servieren.', 3, 1);

INSERT INTO Image (id, RECIPE_ID, data, modified_date)
VALUES ('1', '1', FILE_READ('C:/karotten.jpg'), parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));

-- Knusprige Erdäpfel-Roulade mit Hendl
INSERT INTO Recipe (name, user_id, duration, difficulty, modified_date, CREATION_DATE)
VALUES
  ('Knusprige Erdäpfel-Roulade mit Hendl', 1, 60, 3, parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'),
   parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (18, 2, 750, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (19, 2, 500, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (20, 2, 1, 'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (21, 2, 150, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (22, 2, 100, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (16, 2, 50, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (13, 2, NULL, NULL);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (23, 2, NULL, NULL);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (11, 2, NULL, NULL);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (24, 2, 0.5, 'TL');

INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Für die knusprige Erdäpfel-Roulade mit Hendl Backrohr auf 240 °C Ober-/Unterhitze bzw. 210 °C Heißluft vorheizen.',
   1, 2);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Erdäpfeln schälen und sehr feinblättrig schneiden (max. 2 mm dick). Ein Backblech mit Backpapier auslegen, die Hälfte des geriebenen Parmesans gleichmäßig dünn darauf streuen.
Die Erdäpfelscheiben fächerförmig darauf auflegen, sodass ein Schuppen-Muster entsteht. Den restlichen Parmesan wiederum darauf verteilen und im vorgeheizten Backrohr ca. 25-30 Minuten knusprig vorbacken.',
   2, 2);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Den Lauch waschen, trockentupfen und die Enden abschneiden. Anschließend in feine Ringe schneiden.
Die Butter in einer vorgeheizten Pfanne schmelzen und den Lauch darin unter gelegentlichem Rühren anbraten.
Mit Salz, Pfeffer, Muskatnuss und Kümmel abschmecken und beiseite stellen.',
   3, 2);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Die vorgebackenen Erdäpfeln ein wenig abkühlen lassen. Speckscheiben und Lauch gleichmäßig darauf verteilen.
Die Hühnerschnitzel ebenfalls gleichmäßig auf dem Teig auflegen.',
   4, 2);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Mit Salz und Pfeffer würzen und mithilfe des Backpapiers breitseits zu einer straffen Rolle einrollen.
Mit dem Abschluss nach unten wieder mittig auf ein Backpapier legen und im Backofen bei gleichbleibender Temperatur 25 Minuten fertig backen.',
   5, 2);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Vor dem Anschneiden die knusprige Erdäpfel-Roulade mit Hendl etwa 5 Minuten abkühlen lassen.',
   6, 2);

INSERT INTO Image (RECIPE_ID, data, modified_date)
VALUES
  ('2', FILE_READ('C:/knusprigeerdaepfel.jpg'), parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));

-- Indisches Hühnercurry mit Zuckerschoten und Ingwer
INSERT INTO Recipe (name, user_id, duration, difficulty, modified_date, CREATION_DATE)
VALUES
  ('Indisches Hühnercurry mit Zuckerschoten und Ingwer', 2, 45, 2, parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'),
   parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (25, 3, 600, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (26, 3, 4, 'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (27, 3, 3, 'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (28, 3, 3, 'cm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (29, 3, 1, 'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (30, 3, 400, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (31, 3, 3, 'EL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (13, 3, NULL, NULL);
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (32, 3, 1, 'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (35, 3, 1, 'TL');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (36, 3, 200, 'ml');

INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Für indisches Hühnercurry mit Zuckerschoten und Ingwer zunächst das Hühnerfleisch waschen, trocken tupfen und in mundgerechte Würfel schneiden. Die Frühlingszwiebeln waschen, putzen und in feine Ringe schneiden. Den Knoblauch und den Ingwer schälen und beides fein hacken. Die Chilischote waschen, putzen und fein würfeln. Die Zuckerschoten waschen und putzen.',
   1, 3);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Im Wok oder einer großen Pfanne 2 EL Öl erhitzen und das Hühnerfleisch darin portionsweise kurz anbraten, leicht salzen und wieder herausnehmen.',
   2, 3);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Das restliche Öl erhitzen und die Frühlingszwiebeln mit dem Knoblauch und dem Ingwer darin 1-2 Minuten anbraten. Mit Koriander, Kreuzkümmel, Kurkuma und Garam masala würzen, die Zuckerschoten dazugeben, leicht salzen und ca. 4 Minuten unter Rühren mitbraten.',
   3, 3);
INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES
  ('Das Hühnerfleisch wieder einlegen, mit Suppe aufgießen und alles wieder erhitzen. Indisches Hühnercurry mit Zuckerschoten und Ingwer zugedeckt bei geringer Hitze noch ca. 5 Minuten köcheln lassen, abschmecken, auf Teller verteilen und servieren.',
   4, 3);

INSERT INTO Image (RECIPE_ID, data, modified_date)
VALUES
  ('3', FILE_READ('C:/ingwer.jpg'), parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));


-- Gedämpfte Huscheln
INSERT INTO Recipe (name, user_id, duration, difficulty, modified_date, CREATION_DATE)
VALUES
  ('Gedämpfte Huscheln', 2, 10, 1, parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'),
   parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (37, 4, 300, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (38, 4, 200, 'Gramm');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (39, 4, 100, 'Stück');
INSERT INTO RECIPE_INGREDIENT (INGREDIENT_ID, RECIPE_ID, QUANTITY, QUALIFIER) VALUES (40, 4, 300, 'Gramm');

INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES ('Den Braten im Ofen verbrennen lassen.', 1, 4);

INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES ('Isometrische Übungen am Fensterbrett.', 2, 4);

INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES ('Hambuger bei örtlicher Fastfoodkette besorgen.', 3, 4);

INSERT INTO INSTRUCTION (INSTRUCTION_DESCRIPTION, step, recipe_id)
VALUES ('Gedämpfte Huscheln servieren.', 4, 4);

INSERT INTO Image (RECIPE_ID, data, modified_date)
VALUES
  ('4', FILE_READ('C:/huscheln.jpg'), parsedatetime('23-02-2018 11:42:21.544', 'dd-MM-yyyy hh:mm:ss.SS'));
