package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		//java.util.Date date = new java.util.Date();
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		System.out.println(new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()));
		System.out.println(new Date());
		
		System.out.println(Double.valueOf(String.format("%.2f",(double)2827/1024)));
		double value = Double.valueOf(String.format("%.2f",(double)2827/1024));
		
		if(value > 3)
		{
			System.out.println("Haan Bada Hia Bhai");
		} else System.out.println("Haan Chota Bada Hia Bhai");
		
	}
}
