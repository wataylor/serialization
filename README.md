# serialization
Shows how various object serialization schema work.  It contains the following major directories:

## asst.pojo

This defines three classes which are used in the serialization examples in asst.thatsbiz.serialization.AppMain.java.

### AnAddress.java

Contains JAXB2 XML annotations and jackson annotations for converting the object to JSON.

### Individual.java

Contains XML and JSON annotations for fields which contain a few data about an individual.  This class has no fields which contain non-Java classes.

### IndividualWithAddress.java

Contains the same fields and annotations as **Individual.java** with the addition of a field which contains **AnAddress**.  The purpose is to show that both XML and JSON support arrays of objects which contain objects.

# Other Classes

The other POJOs are sued in the jUnit tests in **src/text/java** to show the flexibility of the Jackson JSON system.  These tests were written early in the Jackson project when it wasn't clear what worked and what did not.

# Flame Wars

## Getters and Setters

I rarely use getters or setters.  I was hanging around MIT while structured programming and object-oriented programming were debated.  Getters and setters were part of "information hiding."  The thought was that if the definition of an internal parameter changed, the get and set methods could be augmented to do the conversion and programs which called get and set would not have to change.

I've been earning a living in software since June of 1964 and losing market share every year.  *Not once* in all those years have I *ever* seen an example of a program minimizing code changes by writing code in a getter or setter to support a new variable.  Why pay the cost of calling methods to manipulate data fields?

Writing getters and setters is such a pain that people are using Lompoc which runs after compilation and sneaks byte code into .class files to implement getters and setters which the programmers were too lazy to ask the IDE write.

Setters *can* avoid multiple constructors when a class has many fields which may or may not be set.  If setters return **this** instead of **void**, we can chain them as in **AppMail.java**:

    AnAddress address = new AnAddress().setLine1("al1").setLine2("al2")
	.setCity("City").setState("state").setZip("zip");

## Functional Programming

Java 8 makes a *huge* deal about supporting functional programming.  Java static classes have supported functional programming since Java 1.  Java 8 adds many new ways of expressing computation which don't add functionality.  This makes Java programs harder to read because you have to be familiar with more forms of notation.

## Dependency Injection

Spring and friends make a big deal out of dependency injection.  You create a singleton class of which there will be only one instance, then in each method that needs it, you annotate a variable so that the Spring framework fills in the value of the variable with a pointer to the singleton.  You code **<variable name>.<method name>** to call methods in the singleton.

Those same methods could be implemented as static methods of which there is only one instance by definition.  Instead of coding **<variable name>.<method name>**, you'd code **<class name>.<method name>**.  What's wrong with that?
