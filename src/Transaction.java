import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Transaction {

	public static boolean isValidDate(String scanDate) {
        String date = "MM/dd/yyyy";

        try {
            SimpleDateFormat format = new SimpleDateFormat(date);
            format.setLenient(false);
            format.parse(scanDate);
        } catch (ParseException e) {
        	//System.out.println("ParseException e")
        	System.out.println("Invalid date!");
        	System.exit(0);
            return false;
        } catch (IllegalArgumentException e) {
        	//System.out.println("IllegalArgumentException e");
            return false;
        }
        return true;
		}
    }
