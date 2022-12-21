# Product Trading and Bidding System

## Java application to buy and sell products with basic text based db - to showcase use of different java design patterns used.

### Steps to run the program -

#### CLI - 

```
cd SER515-Fall22/design-patterns-individual/ptbs/src
javac com/rhattark/Main.java
java com/rhattark/Main
```

#### Intellij -

Import project SER515-Fall22/design-patterns-individual
Run from IDE

### Files where Design Patterns are used -

- Facade - 

    - businessLogic/Facade.java

- Bridge -

    - businessLogic/Person.java
    - businessLogic/Buyer.java
    - businessLogic/Seller.java
    - businessLogic/ProductMenu.java
    - gui/MeatProductMenu.java
    - gui/ProduceProductMenu.java

- Factory -

    - businessLogic/Person.java
    - businessLogic/Buyer.java
    - businessLogic/Seller.java
    - businessLogic/ProductMenu.java
    - gui/MeatProductMenu.java
    - gui/ProduceProductMenu.java

- Iterator -

    - businessLogic/ListIterator.java
    - businessLogic/OfferingList.java
    - businessLogic/OfferingList.OfferingIterator (inner class)
    - businessLogic/ClassProductList.java
    - businessLogic/ClassProductList.ProductIterator (inner class)

- Visitor -

    - businessLogic/Reminder.java
    - businessLogic/NodeVisitor.java
    - businessLogic/ClassProductList.java
    - businessLogic/ReminderVisitor.java
    - gui/Trading.java

- Singleton -

    - businessLogic/Facade.java
    - util/FileManager.java

- Builder -

    - businessLogic/ProductListBuilder.java
    - businessLogic/OfferingListBuilder.java

### Technical Configurations -

Java version used - openjdk version "18.0.2.1" 2022-08-18
Javac version used - javac 18.0.2.1
Intellij version used - IntelliJ IDEA 2022.2.1 (Community Edition)