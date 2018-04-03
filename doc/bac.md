##Prio

###Features

| Prio| Thema|Bearbeiter|
|---|---|---|
|<del> 1 | Neues Rezept Schritt autogeneriert im HTML (sieht new Recipe Seite) | Bernhard </del>
|<del> 1 | Rezept Detailseite quantity und qualifier | Bernhard </del>
|<del> 1 | DEBUG enablen | Bernhard</del>
|<del> 1 | 404 Error Page | Bernhard </del>
|<del> 1 | Responsive Design detaillierte Rezepte | Wegl</del>
|<del> 1 |  Responsive Design Rezepterstellung | Wegl </del>
|<del> 1 | meine Rezepte implemenieren |Wegl </del>
|<del> 2 | Logging|Bernhard</del>
|<del> 2 | Interceptor für logging|Bernhard</del>
|<del> 4 | mehr Sampel Daten|Bernhard</del>
|<del> 1 | Valdiator für Rezepte |Wegl</del>
| 1 | Image Controller load all images with id (array) | Bernhard
|<del> 1 | Delete and Update Button| Wegl </del>
|<del> 2 | User see only delete and update on their own recipe| Wegl </del>
|<del> 1 | Difficulty and Duration | Wegl </del>
| 4 | Recommendation of the day |Wegl
| 4 | Suche implementieren mit Namen des Rezeptes und Ansicht Matches | Wegl


###Refactoring

| Prio | Thema | Observed | Expected | Bearbeiter |
|---|---|---|---|---|
|<del> 0 | Duplizierung Ingredients</del> |  |  |
|<del> 1 | REST | http://localhost:8080/recipes?id=3# | http://localhost:8080/recipes/3 | Bernhard</del>
|<del> 2 | Dropdown für ingredients| Nur rudimentäre Auswahl | Auswahl passt sich an den Input an | Wegl</del>
|<del> 3 | responsive header| verdeckt formular | Header passt sich an | Wegl </del>
|<del> 3 | vorauswahl für ingredients | reduziert wenn schon gewählt | in eigene Service-Klasse | Bernhard</del>
|<del> 1 | Qualifier erweitern und auch nullable| | | Bernhard</del>
| 4 | RecipeServiceImpl.extractToControllerSomeDay() refactores|  |  |


###Android

| Prio |Ref| Thema |  Bearbeiter |
|---|---|---|---|
| 1 |1| Startseite - rein statisch|Wegl|
| 1 |2| Alle Rezepte - Rest Call auf recipes| Wegl|
| 1 |3| Detail Rezept - Rest Call auf recipes/{id}| Wegl |
| 2 |4| Authentification| Bernhard |
| 3 |5| Speichern von Einstellungen| Bernhard|
| 5 |6| Suche| |



<!-- TODO: Recipe of the to implement
        <div th:if="${recipe}">
            <p>Die Empfehlung des Tages:</p>
            <a th:href="@{/recipes/__${recipe.id}__}" th:text="${recipe.name}"></a>
        </div>
-->