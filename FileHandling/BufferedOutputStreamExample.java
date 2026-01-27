package FileHandling;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
    public static void main(String[] args) {
        String data = "BufferedOutputStream in Java Example";

        try {
            FileOutputStream fileOut = new FileOutputStream("output1.txt");
            BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut);

            byte[] bytes = data.getBytes();
            bufferOut.write(bytes);

            bufferOut.close();
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //flush
        try {
            FileOutputStream fileOut = new FileOutputStream("flush.txt");
            BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut);

            bufferOut.write("Hello".getBytes());
            bufferOut.flush();  // ensures data is written immediately

            bufferOut.close();
            System.out.println("Flush example completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //large data writing
        try {
            FileOutputStream fileOut = new FileOutputStream("large.txt");
            BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut, 8192); // custom buffer size

            for (int i = 0; i < 1000; i++) {
                bufferOut.write(("Line " + i + "\n").getBytes());
            }

            bufferOut.close();
            System.out.println("Large data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
