package cl.smile.javatest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import java.util.Date;
import java.util.Calendar;
import org.apache.commons.lang3.time.DateUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
@PropertySource(value = {"file:JavaTest.properties"})
public class App {
    public static void main(String[] args) {
        Date cal = new Date();
        Date cale = DateUtils.addHours(cal, -48);
      

        for(Date i=cal;i.compareTo(cale)>=0;i = DateUtils.addHours(i, -6)){
            System.out.println(strSeter("HH:mm:ss",i));
            System.out.println(i.compareTo(cale));
            System.out.println(i);
        }
    }

    public synchronized static String strSeter(String pattern,Date fecha){

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(fecha);
    }
}