# Java 8 Stream
Stream allows developers to process collections of data in a functional and declarative way. Streams make it easier to perform operations such as filtering, mapping, reducing and collecting data without writing complex loops.

* Unlike Collections, a Stream does not store data it only processes it.

## Features of Streams
* Declarative: Write concise and readable code using functional style.
* Lazy Evaluation: Operations are executed only when needed (terminal operation).
* Parallel Execution: Supports parallel streams to leverage multi-core processors.
* Reusable Operations: Supports chaining of operations like map(), filter(), sorted().
* No Storage: Streams don’t store data; they only process it.

## How does Stream Work Internally?
* Create a Stream: From collections, arrays or static methods.
* Apply Intermediate Operations: Transform data (e.g., filter(), map(), sorted()).
* Apply Terminal Operation: Produce a result (e.g., forEach(), collect(), reduce()).

## Creation of Streams
Streams Creation can be done by multiple ways:

* From a Collection: Create a stream directly from a List, Set or any Collection using stream()
* From an Array: Use Arrays.stream(array) to convert an array into a stream.
* Using Stream.of(): Create a stream from a fixed set of values using Stream.of().
* Infinite Stream: Generate an unbounded sequence using Stream.iterate() or Stream.generate()

## Stream Pipeline
A Stream Pipeline defines how data flows through different stages. It has three parts:
### 1. Source
The source provides the data for the stream. It can be a collection, array, file or even an infinite generator.

Example:
```
List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

Stream<Integer> stream = numbers.stream(); // Source
```
### 2. Intermediate Operations
Intermediate operations transform a stream into another stream. Some common intermediate operations include:

* **filter():** Filters elements based on a specified condition.
* **map():** Transforms each element in a stream to another value.
* **Sorted():** Sorts the elements of a stream.
* **Distinct():** Remove duplicates.
* **Skip():** Skip first n elements.

### 3. Terminal Operations
Terminal Operations are the operations that on execution return a final result as an absolute value.

* **ForEach():** It iterates all the elements in a stream.
* **collect(Collectors.toList()):** It collects stream elements into a list (or other collections like set/map).
* **Reduce():** It reduces stream elements into a single aggregated result.
* **count():** It returns the total number of elements in a stream.
* **anyMatch() / allMatch() / noneMatch():** They check whether elements match a given condition.
* **findFirst() / findAny():** They return the first or any element from a stream.

## Stream vs Collection difference
* Collection stores data in memory and represents a data structure (e.g., List, Set, Map).
* Stream does not store data; it processes data from a source (like a collection) in a functional, declarative way.
