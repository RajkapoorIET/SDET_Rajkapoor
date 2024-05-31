package practice;

import java.time.Month;

public class SwitchExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int days = 0;
		Month m = Month.APRIL;
		
		days = switch(m) {
		case JANUARY, MARCH, MAY,JULY,AUGUST,OCTOBER, DECEMBER ->31;
		case FEBRUARY ->29;
		case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
		default -> throw new IllegalStateException();
		};

	}

}
