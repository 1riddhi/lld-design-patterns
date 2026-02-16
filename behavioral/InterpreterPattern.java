//Interpreter pattern is used to define a grammar for a language and 
// to interpret sentences in that language.


//Grammar defines the structure and valid combinations of expressions in a language.

// Our grammar here is
// Expression →
//   Role
//   Department
//   Expression AND Expression
//   Expression OR Expression

import java.util.*;

// Expression Interface
interface Expression {
    boolean interpret(User user);
}


// Context Object
class User {
    String role;
    String department;

    public User(String role, String department) {
        this.role = role;
        this.department = department;
    }
}


// Terminal Expression (Check Role)
class RoleExpression implements Expression {

    private String role;

    public RoleExpression(String role) {
        this.role = role;
    }

    @Override
    public boolean interpret(User user) {
        return user.role.equalsIgnoreCase(role);
    }
}


// Terminal Expression (Check Department)
class DepartmentExpression implements Expression {

    private String department;

    public DepartmentExpression(String department) {
        this.department = department;
    }

    @Override
    public boolean interpret(User user) {
        return user.department.equalsIgnoreCase(department);
    }
}


// Non-Terminal AND
class AndExpression implements Expression {

    private Expression left;
    private Expression right;

    public AndExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(User user) {
        return left.interpret(user) && right.interpret(user);
    }
}


// Non-Terminal OR
class OrExpression implements Expression {

    private Expression left;
    private Expression right;

    public OrExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(User user) {
        return left.interpret(user) || right.interpret(user);
    }
}


// MAIN
public class Main {

    public static void main(String[] args) {

        // Build rule: (ADMIN AND IT) OR SUPERUSER
        Expression admin = new RoleExpression("ADMIN");
        Expression itDept = new DepartmentExpression("IT");
        Expression superUser = new RoleExpression("SUPERUSER");

        Expression adminAndIT = new AndExpression(admin, itDept);
        Expression finalRule = new OrExpression(adminAndIT, superUser);

        // Test users
        User user1 = new User("ADMIN", "IT");
        User user2 = new User("ADMIN", "HR");
        User user3 = new User("SUPERUSER", "Finance");

        System.out.println("User1 access: " + finalRule.interpret(user1)); // true
        System.out.println("User2 access: " + finalRule.interpret(user2)); // false
        System.out.println("User3 access: " + finalRule.interpret(user3)); // true
    }
}
