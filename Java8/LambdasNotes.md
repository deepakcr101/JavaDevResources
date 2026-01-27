# Java Lambda Expressions
allow developers to write concise, functional-style code by representing anonymous functions

They enable passing code as parameters or assigning it to variables, resulting in cleaner and more readable programs.

* Lambda expressions implement a functional interface (An interface with only one abstract function)
* Enable passing code as data (method arguments).
* Allow defining behavior without creating separate classes.

## Syntax
* Parameter List: Parameters for the lambda expression
* Arrow Token (->): Separates the parameter list and the body
* Body: Logic to be executed.

# Java Method References
They are a shorthand way to refer to an existing method without invoking it. They were introduced in Java 8 to make lambda expressions shorter, cleaner, and more readable. Method references use the double colon (::) operator and are mainly used with functional interfaces.

* Introduced in Java 8 as an alternative to lambda expressions
* Improve code readability and reduce boilerplate
* Used only when a lambda expression calls a single existing method*