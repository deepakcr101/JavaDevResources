package Arrays;
import java.util.stream.*;

class Student {
    public int roll_no;
    public String name;

    Student(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}

public class LearnArray {
    public static void main(String args[]) {
        // initializing array
        int[] arr1 = { 40, 55, 63, 17, 22 };

        // size of array
        int n = arr1.length;
        System.out.println("Size of Array: " + n);
        // traversing array
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        // Array Declaration
        arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // accessing or updating elements
        arr1[0] = 2;
        arr1[1] = 4;
        arr1[2] = 8;
        arr1[3] = 12;
        arr1[4] = 16;
        System.out.println("Updated Array: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Array of Objects
        // declares an Array of Student
        Student[] arr;

        // allocating memory for 5 objects of type Student.
        arr = new Student[5];

        // initialize the elements of the array
        arr[0] = new Student(1, "aman");
        arr[1] = new Student(2, "vaibhav");
        arr[2] = new Student(3, "shikar");
        arr[3] = new Student(4, "dharmesh");
        arr[4] = new Student(5, "mohit");

        // accessing the elements of the specified array
        for (int i = 0; i < arr.length; i++)
            System.out.println("Element at " + i + " : { "
                    + arr[i].roll_no + " "
                    + arr[i].name + " }");

        // Passing Arrays as Parameters
        System.out.println(getSum(arr1));

        // Returning Arrays
        int marks[] = getMarks();
        System.out.println("Your Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();


        //Use of Streams
        int[] arr2 = IntStream.rangeClosed(1, 4).toArray();
        for(int i:arr2){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] arr3 = IntStream.of(5, 10, 15).toArray();
        for(int i:arr3){
            System.out.print(i+" ");
        }
        System.out.println();

        int [] arr4=IntStream.range(1,10).toArray();
        for(int i:arr4){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    private static int[] getMarks() {
        int[] marks = { 99, 98, 76 };
        return marks;
    }
}
