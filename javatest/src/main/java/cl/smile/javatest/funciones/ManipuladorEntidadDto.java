package cl.smile.javatest.funciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import cl.smile.javatest.model.FechaDto;
import lombok.Getter;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
public class ManipuladorEntidadDto {

    @Getter
    private static List<FechaDto> listTramo = new ArrayList<>();
    @Getter
    private static List<FechaDto> listNoTramo = new ArrayList<>();
    
    /**
     * @param fechaActual Parametro que requiere fecha habil actual entregada por comando
     * @param fechaAnterior Parametro que requiere fecha habil anterior entregada por comando
     */
    public synchronized static void setTramos(Date fechaActual,Date fechaAnterior){

        for(Date i = fechaActual;(i.compareTo(fechaAnterior))>=0;i = DateUtils.addHours(i,-12)){
            FechaDto auxTramo = new FechaDto();
            auxTramo.setFechaDate(i);
            String fecha = TimeModifier.dateToString("ddMMyyyy", i);
            auxTramo.setFechaC(fecha);
            String hora = TimeModifier.dateToString("HH:mm:ss", i);
            auxTramo.setHoraStr(hora);
            auxTramo.setTramoInt(0);
            
            ManipuladorEntidadDto.listTramo.add(auxTramo);
        }

        for(Date i = fechaActual;(i.compareTo(fechaAnterior))>=0;i = DateUtils.addHours(i,-24)){
            FechaDto auxTramo = new FechaDto();
            auxTramo.setFechaDate(i);
            String fecha = TimeModifier.dateToString("ddMMyyyy", i);
            auxTramo.setFechaC(fecha);
            String hora = TimeModifier.dateToString("HH:mm:ss", i);
            auxTramo.setHoraStr(hora);
            auxTramo.setTramoInt(1);
            
            ManipuladorEntidadDto.listNoTramo.add(auxTramo);
        }
    }
}
