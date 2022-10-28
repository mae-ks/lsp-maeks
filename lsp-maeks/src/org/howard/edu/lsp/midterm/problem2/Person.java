package org.howard.edu.lsp.midterm.problem2;

public class Person { 
	private String name;
	private int age; 
	private String socialSecurityNumber;

	public Person(String name,  String socialSecurityNumber, int age) {
		// initialize private variables
		this.name = name;
		this.socialSecurityNumber = socialSecurityNumber;
		this.age = age;
	}
	
	@Override
    public String toString() {
		String res = new String();
		res += "Name: " + this.name + ", ";
		res += "Age: " + this.age + ", ";
		res += "Social Security: " + this.socialSecurityNumber;
        return res;
    }
	
	@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person c = (Person) o;
        return socialSecurityNumber.equals(c.socialSecurityNumber);
    }
} 
