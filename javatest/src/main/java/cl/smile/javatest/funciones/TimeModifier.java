package cl.smile.javatest.funciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@Slf4j
public class TimeModifier {

    /**
     * @param pattern Formato de salida de fecha Ej: ddMMyy
     * @param fecha Parametro de entrada de typo Date
     * @return variable de respuesta de la funcion que retorna un String
     */
    public synchronized static String dateToString(String pattern,Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(fecha);
    }

    /**
     * @param fecha Parametro de entrada de typo String Ej: 10-07-1994
     * @param pattern Formato de entrada de fecha Ej: fecha = 07/03/22 -> pattern = dd/MM/yy
     * @return variable de respuesta de la funcion que retorna un Date
     */
    public synchronized static Date stringToDate(String pattern, String fecha){

        try{
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.parse(fecha);
        }catch (ParseException e) {
            log.info("ERROR | Error Parse en: {}",e);
            return null;
        }
    }
}
