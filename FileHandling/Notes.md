# File Handling
In Java, file handling means working with files like creating them, reading data, writing data or deleting them. It helps a program save and use information permanently on the computer

## File Class
File class in Java (from the java.io package) is used to represent the name and path of a file or directory. It provides methods to create, delete, and get information about files and directories.

 ## Default/Standard Streams in Java
 * **System.in:** This is the standard input stream that is used to read characters from the keyboard or any other standard input device.
 * **System.out:** This is the standard output stream that is used to produce the result of a program on an output device like the computer screen.
 * **System.err:** This is the standard error stream that is used to display error messages separately from normal output.

## 1. System.in
System.in is an InputStream, so it provides methods from the InputStream class. Commonly used ones are:

* **int read():** reads one byte of data.
* **int read(byte[] b):** reads bytes into an array.
* **int read(byte[] b, int off, int len):** reads bytes into part of an array.
* **void close():** closes the input stream.
* **int available():** returns the number of bytes that can be read without blocking.
```
 Usually, System.in is wrapped with classes like Scanner or BufferedReader for easier input handling.
 ```

## 2. System.out
* **print():** This Java method displays text on the console, keeping the cursor at the end of the printed text so the next output continues from the same line.
* **println():** This method in Java is also used to display a text on the console. It prints the text on the console and the cursor moves to the start of the next line at the console. The next printing takes place from the next line.
* **printf():** The printf() method in Java is used for formatted output and can take multiple arguments, making it more flexible than print() or println().

## 3.3. System.err
* It is used to display the error messages. It works similarly to System.out with print(), println(), and printf() methods.
---

## STREAMS
1. **ByteStream:**
 * Byte streams in Java are used to perform input and output of 8-bit bytes. They are suitable for handling raw binary data such as images, audio, and video, using classes like InputStream and OutputStream.
 
 The two main abstract classes for byte streams are:

* InputStream: for reading data (input)
* OutputStream: for writing data (output)

Since abstract classes cannot be used directly, we use their implementation classes to perform actual I/O operations.
---
* FileInputStream: reads raw bytes from a file.
* FileOutputStream: writes raw bytes to a file.
* BufferedInputStream / BufferedOutputStream: use buffering for faster performance.
* ByteArrayInputStream: reads data from a byte array as if it were an input stream.
* ByteArrayOutputStream: writes data into a byte array, which grows automatically.
---

2. **CharacterStream:**

* Character streams in Java are used to perform input and output of 16-bit Unicode characters. They are best suited for handling text data, using classes like Reader and Writer which automatically handle character encoding and decoding.

The two main abstract classes for character streams are:

* Reader: Base class for all character-based input streams (reading).
* Writer: Base class for all character-based output streams (writing).

Since abstract classes cannot be used directly, we use their implementation classes to perform actual I/O operations.
---
* FileReader: reads characters from a file.
* FileWriter: writes characters to a file.
* BufferedReader: reads text efficiently using buffering; also provides readLine() for reading lines.
* BufferedWriter: writes text efficiently using buffering.
* StringReader: reads characters from a string.
* StringWriter: writes characters into a string buffer.

---
```
Use Byte Streams when working with binary data (images, audio, video, executable files) and use Character Streams when working with text data (characters, strings, text files).
```

## Write Class
* The Java writer class is an abstract class in the java.io package. It is designed for writing character streams. It provides methods for writing characters, arrays of characters and strings to files, memory, or other output destinations.
* Since it’s an abstract class, we can’t instantiate it directly; instead, we use concrete subclasses like FileWriter, BufferedWriter or PrintWriter.

* Uses BufferedWriter to improve performance by temporarily storing data before writing it. Writes two lines of text into buffered.txt and automatically closes the stream using try-with-resources.

## Java FileDescriptor
The java.io.FileDescriptor class represents an open file or socket handle in the underlying operating system. It acts as an opaque reference to a particular file, device, or socket. This class is mainly used as a bridge between Java I/O streams and the native file system resources.