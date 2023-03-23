package Problem2;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeAccordingToZone {

	public static void main(String[] args) {
//      for(String s:ZoneId.getAvailableZoneIds()) {
//    	System.out.println(s);
//    }
		
		System.out.println("Our Current Zone:"+ZoneId.systemDefault());
		
        LocalTime ldt=LocalTime.now();
        DateTimeFormatter d=DateTimeFormatter.ofPattern("HH:mm:ss ");
        String system=ldt.format(d);
        System.out.println("Present Time in India:"+" "+system);
        
        
        ldt=LocalTime.now(ZoneId.of("Asia/Tokyo"));
        String Tokyo=ldt.format(d);
        System.out.println("Present Time in Tokyo:"+" "+Tokyo);
      
    }

}
