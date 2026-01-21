package OOPS;

class Book implements Cloneable {
    private String t; // title
    private String a; // author
    private int y; // year

    public Book(String t, String a, int y) {
        this.t = t;
        this.a = a;
        this.y = y;
    }

    // Override the toString method
    @Override
    public String toString() {
        return t + " by " + a + " (" + y + ")";
    }

    // Override the equals method
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Book)) {
            return false;
        }
        Book other = (Book) o;
        return this.t.equals(other.getTitle())
                && this.a.equals(other.getAuthor())
                && this.y == other.getYear();
    }

    // Override the hashCode method
    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + t.hashCode();
        res = 31 * res + a.hashCode();
        res = 31 * res + y;
        return res;
    }

    // Override the clone method
    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Override the finalize method
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + this);
    }

    public String getTitle() {
        return t;
    }

    public String getAuthor() {
        return a;
    }

    public int getYear() {
        return y;
    }
}

public class LearnObjectClass {
    public static void main(String[] args) {
        // Create a Book object and print its details
        Book b1 = new Book(
                "The Hitchhiker's Guide to the Galaxy",
                "Douglas Adams", 1979);
        System.out.println(b1);

        // Create a clone of the Book object and print its
        // details
        Book b2 = b1.clone();
        System.out.println(b2);

        // Check if the two objects are equal
        System.out.println("b1 equals b2: "
                + b1.equals(b2));

        // Get the hash code of the two objects
        System.out.println("b1 hash code: "
                + b1.hashCode());
        System.out.println("b2 hash code: "
                + b2.hashCode());

        // Set book1 to null to trigger garbage collection
        // and finalize method
        b1 = null;
        System.gc();
    }
}
