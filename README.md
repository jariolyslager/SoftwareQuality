# SoftwareQuality - Herontwerp JabberPoint
Deze repository bevat de code voor JabberPoint. De code is herontworpen en aangepast zodat deze voldoet aan kwaliteitsrichtlijnen zoals deze aangeleerd zijn in de lessen op NHL Stenden Emmen. Er is gebruik gemaakt van design patterns, code conventies en algemene richtlijnen zoals beschreven in *Clean Code: A Handbook of Agile Software Craftsmanship* van Robert C. Martin.

## Naslagwerken
\> [*Dive into Design Patterns*, Alexander Shvetz](https://refactoring.guru/design-patterns/book)

\> *Clean Code: A Handbook of Agile Software Craftsmanship*, Robert C. Martin.

\> [NHL Stenden Emmen code conventions](https://github.com/NHL-Stenden-Emmen/coding-conventions)

\> [Super linter voor OTAP-straat](https://github.com/super-linter/super-linter)


## Opbouw
De repository bevat 5 folders en een aantal losse bestanden.
- *.github* bevat de bestanden voor de OTAP-straat en de linter die gebruik wordt door de super-linter. Deze linter is geschreven zodat deze voldoet aan de code conventies van NHL Stenden Emmen. Er zijn 4 workflows gemaakt; 1 voor elk van de 4 fasen van OTAP (ontwikkel, test, acceptatie, productie). De voornaamste taken van de OTAP-straat zijn het bouwen van de app, het controleren van de code op conventies en fouten, unit tests runnen en een release aanmaken.
- *Astah* bevat de diagrammen die gebruikt zijn voor de systeemanalyse en het ontwerp van de vernieuwde JabberPoint. Ook bevat deze folder een use-case diagram voor de werking van de applicatie.
- *src* bevat alle code van JabberPoint. De *main*-subfolder bevat de code van de applicatie en de nodige resources. De *test*-subfolder bevat de code van de unit tests.
- De overige folders en bestanden zijn gerelateerd aan Git en Gradle. Gradle wordt gebruikt voor het bouwen van de applicatie en Git wordt gebruikt voor het onderhouden van de repository.

## Design patterns
In dit herontwerp van JabberPoint is 4 keer een design pattern toegepast. Namelijk 2 keer een Factory Method Pattern, 1 keer een Singleton Pattern en 1 keer een Command Pattern.

### Factory Method
Bij de abstracte Accessor-klasse is een Factory Method Pattern toegepast. Hiervoor zijn de AccessorCreator- en de AccessorEnum-klassen aangemaakt. De AccessorCreator bestaat uit een switch-case, met een case voor elke enum constant in AccessorEnum. Dit maakt het makkelijk om andere typen accessors toe te voegen.

Op dezelfde manier is een Factory Method Pattern voor de abstracte SlideItem-klasse. Hiervoor zijn de SlideItemCreator- en de SlideItemType-klassen aangemaakt. De SlideItemCreator bestaat uit een switch-case, met een case voor elke enum constant in SlideItemType.

### Singleton
De Singleton Pattern is gebruikt voor de Presentation-klasse. Er wordt in deze klasse een instance aangemaakt van de Presentation. Hierdoor is er ten alle tijden slechts 1 Presentation-object aanwezig. Hier is voor gekozen, omdat JabberPoint hetzelfde Presentation-object kan hergebruiken voor meerdere presentaties.

### Command
Er is gekozen om KeyController en MenuController gebruik te laten maken van commands. Hiervoor is er een abstracte Command-klasse aangemaakt. Elke command is dan een extensie van deze abstracte klasse. Er zijn commands toegevoegd voor NextSlide, PrevSlide, Quit, Open, New en Save. Beide de KeyController en de MenuController kunnen gebruik maken van dezelfde commands, wat dubbele code voorkomt. Verder kunnen nieuwe commands makkelijk toegevoegd worden door de abstracte Command-klasse te extenden.

## SOLID principes
In het herontwerp van JabberPoint zijn op meerdere plaatsen de SOLID-principes toegepast.

### Single Responsibility Principle
- KeyController 
    - Was eerst verantwoordelijk voor zowel het bijhouden van KeyEvents als de logica die moest worden uitgevoerd als gevolg van een KeyEvent. 
    - Nu is de Keycontroller alleen nog maar verantwoordelijk voor het bijhouden van de KeyEvents en dat koppelen aan een actie. De logica staat nu apart in een command. 

- MenuController 
    - Was eerst verantwoordelijk voor het aanmaken van de menu items en de logica dat moest uitgevoerd worden wanneer er op iets geklikt werd. 
    - Nu is het alleen nog maar verantwoordelijk voor de menu items. De logica dat moet worden uitgevoerd zit nu in een command. 

- SlideItemLoader 
    - Het aanmaken van SlideItems bij het openen van een XML-bestand gebeurde voorheen in de XMLAccessor. Dit betekent dat die zowel verantwoordelijk was voor de interactie met XML-bestanden als voor het maken van SlideItems. 
    - Nu is XMLAccessor alleen maar verantwoordelijk voor interactie met XML-bestanden en is SlideItemLoader alleen verantwoordelijk om SlideItems aan te maken. 
### Open/Closed Principle
- De command pattern zorgt ervoor dat de presentation class niet bewerkt hoeft te worden en ook de abstracte command klasse 
    - De abstracte command klasse is wel open voor extensie 

- De abstracte Accessor-klasse bevat alle basis gedragingen en hoeft niet meer bewerkt te worden. Er kunnen wel altijd nieuwe extensies gemaakt worden van deze klasse, denk aan een JSONAccessor, welke weer extra gedragingen kan bevatten en de basis gedragingen kan overriden. 
### Liskov Substitution Principle
- De commands 
    - Alle subclasses zijn compatible met de functionaliteit van de superclass 
    - De parent field is om deze reden optioneel bij een command 
    - Een subclass object zoals NewCommand of SaveCommand zou op de plaats van een Command kunnen staan 

- Accessors 
    - Alle subclasses zijn compatible met de Accessor class 
        - Eerst was dit niet zo door dat er een error kwam als je bij de DemoAccessor saveFile uitvoerde. 
            - SaveFile method is nu alleen verplicht met de SaveAccessor interface 
### Interface Segregation Principle
- Accessors met de SaveAccessor interface 
    - Niet elke accessor kan een file saven, bijv. de DemoAccessor kan dat niet. Het is dan onnodig dat de saveFile method verplicht is.  
    - Elke accessor die een file kan saven moet daarom de SaveAccessor interface hebben. 
