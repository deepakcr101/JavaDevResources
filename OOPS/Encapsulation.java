package OOPS;

class Employee{
    // Private fields (encapsulated data)
    private int id;
    private String name;
    
    public Employee(){
        
    }
    // Setter methods 
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
public class Encapsulation {
    public static void main(String args[]){
        Employee emp = new Employee();
        
        // Using setters
        emp.setId(101);
        emp.setName("Rahul");

        // Using getters
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
    }
}
