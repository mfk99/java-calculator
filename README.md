# java-calculator

## Description

This project uses OOP to program a calculator with a GUI.

A class diagram has been provided below:

```mermaid
classDiagram
    class Main{
        +main(String[] args)void
    }

    class CalculatorUI{
        +start(Stage primaryStage)void
    }

    class ButtonFactory{
        +createButtonGrid(TextField field)GridPane
        -createSymbolInputButtons(GridPane buttonGrid, TextField field)void
        -createOperatorInputButtons(GridPane buttonGrid, TextField field)void
    }

    class CalculatorController{
        +handleOperatorInput(TextField field, String operator)void
        +handleSymbolInput(TextField field, String symbol)void
        +formatAndInsertResult(double result, TextField field)void
    }

    class Parser{
        -String expression
        +Parser(String expression)Parser
        +parseOperator()String
        +parseOperand()Double[]
    }

    class CalculatorLogic{
        -Operation addition
        -Operation subtraction
        -Operation multiplication
        -Operation division
        -Operation exponent
        -Operation squareRoot
        +calculate(double a, double b, String operator)
    }

    class Operation{
        +operate(double a, double b)double*
    }
    <<Abstract>> Operation

    Main ..> CalculatorUI
    CalculatorUI ..> ButtonFactory
    ButtonFactory ..> CalculatorController
    CalculatorController ..> CalculatorLogic
    Parser <.. CalculatorController 
    CalculatorLogic ..> Addition
    CalculatorLogic ..> Subtraction
    CalculatorLogic ..> Division
    CalculatorLogic ..> Multiplication
    CalculatorLogic ..> Exponent
    CalculatorLogic ..> SquareRoot
    Addition --|> Operation
    Subtraction --|> Operation
    Division --|> Operation
    Multiplication --|> Operation
    Exponent --|> Operation
    SquareRoot --|> Operation
```

Additionally, a file diagram to represent the file herarchy.
(This diagram is also available as a .graphml-file).

![An image representing the file hierarchy](assets/file-diagram.png)

## Technologies

The project has been built with the following technologies:

- Apache Maven 3.9.9
- Java 23.0.2

Note: this project likely functions across multiple versions, but in case it doesn't, please use the versions specified above.

## Instructions

### Running

To clone the code from the repository, use the command

`git clone https://github.com/mfk99/java-calculator`

!Note: When running `mvn` commands, you must be in the `calculator`-directory, where e.g.`pom.xml` and `src` are located!

To compile the project, use

`mvn clean compile`

And to run the project, use

`mvn exec:java`

### Testing

To run the tests, use

`mvn test`

<!---
TODO: Create E-2-E and unit tests, add codecov
--->

### Documentation

The project uses Javadoc to produce code documentation.
Javadoc is integrated into Maven, so to generate the report, use 

```mvn javadoc:javadoc```

This will create the documentation into the `target/site/apidocs` folder. 
Drag the `index.html` to your browser of choice to view the documentation.
This opens up a view which looks like the following:
![An image of the Javadoc view](assets/javadoc.png)

<!---
TODO: Configure javadoc to create to seperate folder
--->

## Time used

- General setup: 1,5h
- Development: 11h
- Documentation: 2h
