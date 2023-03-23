package Exception_Problem3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadContentFromOneToOther {

	public static void main(String[] args) {
		String str="";
		try {
		 FileInputStream fis=new FileInputStream("source.txt");
	        
	        int c=fis.read();
	        while(c!=-1) {
	        	str+=(char)c;
	        	c=fis.read();
	        }
	        System.out.println(str);
	        fis.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			 FileOutputStream fos=new FileOutputStream("target.txt");
		        fos.write(str.getBytes());
		        fos.flush();
		        fos.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		} 
	}

}
