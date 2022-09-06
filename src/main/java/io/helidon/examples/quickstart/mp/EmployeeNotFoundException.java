package io.helidon.examples.quickstart.mp;

import java.sql.SQLOutput;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(int id) {
        super("EmpID " + id + " was not found!");
        System.out.println("Please enter valid details.");
    }

}
