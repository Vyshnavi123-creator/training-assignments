package Problem2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DisplayDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);
        DateTimeFormatter d=DateTimeFormatter.ofPattern("dd-MM-yyyy     HH:mm:ss ");
        String currentDateTime=ldt.format(d);
        System.out.println(currentDateTime);
	}

}
