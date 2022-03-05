package self.java.grammar;

public class SwitchCaseUpgrade {

    public static Employee create(String name, String type) {
        return switch (type) {
            case "engineer" -> new Engineer(name);
            case "manager" -> new Manager(name);
            case "salesman" -> new Salesman(name);
            case "parttime" -> new PartTimeEmployee(name, false);
            case "fulltime" -> new FullTimeEmployee(name);
            default -> new Employee(name);
        };
    }

    public static Employee create(String name, WorkType type) {
        return switch (type) {
            case ENGINEER -> new Engineer(name);
            case MANAGER -> new Manager(name);
            case SALESMAN -> new Salesman(name);
            case PARTTIME -> new PartTimeEmployee(name, false);
            case FULLTIME -> new FullTimeEmployee(name);
            default -> new Employee(name);
        };
    }

    enum WorkType {
        ENGINEER, MANAGER, SALESMAN,
        PARTTIME, FULLTIME
    }
}

class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Salesman extends Employee {

    public Salesman(String name) {
        super(name);
    }
}

class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }
}

class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }
}

class PartTimeEmployee extends Employee {

    private boolean longTerm;

    public PartTimeEmployee(String name, boolean longTerm) {
        super(name);
        this.longTerm = longTerm;
    }

    public void setLongTerm(boolean longTerm) {
        this.longTerm = longTerm;
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name) {
        super(name);
    }
}