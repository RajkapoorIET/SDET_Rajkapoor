package session2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class PersonAge {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in)) {
			String dob = sc.nextLine();
			
			LocalDate birth = LocalDate.parse(dob);
			LocalDate currentdate =  LocalDate.now();
			
			System.out.println(Period.between(birth,currentdate).getYears());
		}

	}

}
