package other;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args){
		Date d=new Date(System.currentTimeMillis());
		System.out.println(d);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String ds=sdf.format(d);
		System.out.println(ds);
	}
}
