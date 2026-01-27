package FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class FileClass {
    public static void main(String[] args) {
        // Accept file name or directory name through
        // command line args
        String fname = args[0];

        // pass the filename or directory name to File
        // object
        File f = new File(fname);

        // apply File class methods on File object
        System.out.println("File name :" + f.getName());
        System.out.println("Path: " + f.getPath());
        System.out.println("Absolute path:"
                           + f.getAbsolutePath());
        System.out.println("Parent:" + f.getParent());
        System.out.println("Exists :" + f.exists());

        if (f.exists()) {
            System.out.println("Is writable:"
                               + f.canWrite());
            System.out.println("Is readable" + f.canRead());
            System.out.println("Is a directory:"
                               + f.isDirectory());
            System.out.println("File Size in bytes "
                               + f.length());
        }


        // Enter the path and dirname
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.print("Enter directory path : ");
        String dirpath = br.readLine();
      
        System.out.print("Enter the directory name : ");
        String dname = br.readLine();
        // Create File object with dirpath and dname
        File mf = new File(dirpath, dname);
        // If directory exists,then
        if (mf.exists()) {
            
          	// Get the contents into arr[], now arr[i] represent either a File or Directory
            String arr[] = mf.list();

            // Find no. of entries in the directory
            int n = arr.length;

            // Displaying the entries
            for (int i = 0; i < n; i++) {

                System.out.print(arr[i] + " ");

                // Create File object with the entry and test if it is a file or directory
                File f1 = new File(mf,arr[i]);

                if (f1.isFile())
                    System.out.println(": is a file");
                if (f1.isDirectory())
                    System.out.println(": is a directory");
            }

            System.out.println("\nNo of entries in this directory : " + n);
        }
        else
            System.out.println("Directory not found");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        

    }
}
