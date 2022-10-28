package org.howard.edu.lsp.midterm.problem2;

public class Driver {
	public static void main(String[] args) {
		Person p1 = new Person("Marshal Mathers", "123-456-789", 46);
		Person p2 = new Person("Eminem", "987-654-321", 23);
		Person p3 = new Person("Slim Shady", "987-654-321", 34);
		
		System.out.println("Comparing\n" + p1 + "\nto\n" + p2);
		if (p1.equals(p2)) {
		    System.out.println("Marshal Mathers and Eminem are the same people!");
		} else {
		    System.out.println("Marshal Mathers and Eminem are not the same people!");
		}
		
		System.out.println("\nComparing\n" + p2 + "\nto\n" + p3);
		if (p2.equals(p3)) {
		    System.out.println("Eminem and Slim Shady are the same people!");
		} else {
		    System.out.println("Eminem and Slim Shady are not the same people!");
		}

	}
}
