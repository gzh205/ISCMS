package tools;

import java.util.Date;
import java.util.regex.Pattern;

public class ShowArray {
	public static void ShowStringArray(String[] arr){
		System.out.print("[");
		int i;
		for(i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]+" ");
		}
		System.out.println("]");
	}
	public static boolean isInteger(String str) {  
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
		return pattern.matcher(str).matches();  
	}
	
	@SuppressWarnings("deprecation")
	public static boolean isAfterToday(String date){
		String[] day = date.split("-");
		Date d = new Date();
		System.out.println(date);
		if((d.getYear()+1900)>Integer.parseInt(day[0]))
			return false;
		else if((d.getYear()+1900)<Integer.parseInt(day[0]))
			return true;
		else{
			if((d.getMonth()+1)>Integer.parseInt(day[1]))
				return false;
			else if((d.getMonth()+1)<Integer.parseInt(day[1]))
				return true;
			else{
				if(d.getDate()>Integer.parseInt(day[2]))
					return false;
				else if(d.getDate()<Integer.parseInt(day[2]))
					return true;
				else
					return true;
			}
		}
	}
}
