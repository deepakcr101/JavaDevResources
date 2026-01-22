# Java Exception Handling
```
             +-------------+
              |  Throwable  |
              +-------------+
                    |
      +-------------+-------------+
      |                           |
+-----------+               +-------------+
|   Error   |               |  Exception  |
+-----------+               +-------------+
      |                           |
      |                           +---------------------+
      |                           |                     |
Serious problems          +-------------------+   +--------------------+
you shouldn't             | RuntimeException  |   | Other Exceptions   |
try to catch.             | (Unchecked)       |   | (Checked)          |
(e.g., OutOfMemoryError)  +-------------------+   +--------------------+
                              |                     |
                         Programming errors      External factors
                         (e.g., NullPointer)   (e.g., IOException)
```
* **Error**: Represents serious problems that are not reasonably expected to be caught by an application. Examples include OutOfMemoryError or StackOverflowError. Your application should generally crash, not try to handle these.

* **Exception**: Represents conditions that a reasonable application might want to catch. This is where we will focus. It's further divided into two crucial categories:
   * **Checked Exceptions**: These are exceptional conditions that a well-written application should anticipate and recover from. The Java compiler checks that you have handled them. If a method can throw a checked exception, it must either handle it with a try-catch block or declare it using the throws keyword. Examples: IOException, SQLException. Think of these as errors related to external factors (files, network).

   * **Unchecked Exceptions (Runtime Exceptions)**: These are exceptions that are typically caused by programming bugs, such as logic errors or improper use of an API. The compiler does not force you to handle them. Examples: NullPointerException, ArrayIndexOutOfBoundsException.
            
## The Five Keywords of Exception Handling



**try:** The block of code to be monitored for exceptions.

**catch:** The block of code that gets executed if an exception of a specific type occurs in the try block.

**finally**: A block of code that is always executed after the try and any catch blocks, regardless of whether an exception was thrown or caught. It's perfect for cleanup code (like closing files or network connections).

**throw**: Used to manually throw an exception object.

**throws**: Used in a method's signature to declare the types of checked exceptions it might throw to its caller.
