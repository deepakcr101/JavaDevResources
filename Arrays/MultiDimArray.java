package Arrays;

import java.util.stream.*;
import java.util.Scanner;

//import java.util.Arrays;
public class MultiDimArray {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // 2-D Array and Matrix
        int mat[][] = new int[5][10];
        int lowerLimit = 1;
        for (int i = 0; i < mat.length; i++) {
            mat[i] = IntStream.range(lowerLimit, lowerLimit + 10).toArray();
            lowerLimit += 10;
        }

        System.out.println();

        for (int row[] : mat) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

        System.out.println();

        // 3-D aRRAY ITS again array of arrays or array
        int[][][] cube = new int[5][5][5];
        System.out.println(cube.hashCode());

        // Dynamic ArraySize
        System.out.println("Enter the size of Record: ");
        int n = sc.nextInt();
        int[][] record = new int[n][];
        int count = 1;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the size of this row: ");
            int m = sc.nextInt();
            record[i] = new int[m];

            record[i] = IntStream.range(count, m + count).toArray();
            count += m;
        }

        System.out.println("Records are: ");

        for (int row[] : record) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Jagged Array
        int r = 5;

        // Declaring 2-D array with 5 rows
        int arr[][] = new int[r][];

        // Creating a 2D array such that first row has 1 element, second row has two
        // elements and so on
        for (int i = 0; i < arr.length; i++)
            arr[i] = new int[i + 1];

        // Initializing array
        count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = count++;

        // Displaying the values of 2D Jagged array
        System.out.println("Contents of 2D Jagged Array");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}

// Multidimensional arrays store data in the form of rows and columns where each
// row can itself be an array. They are useful when data needs to be structured
// in table-like or matrix-like formats.
