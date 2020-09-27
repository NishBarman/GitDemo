import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat hms= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		System.out.println(sdf.format(d));
		System.out.println(hms.format(d));
		System.out.println(d.toString());
	}

}
