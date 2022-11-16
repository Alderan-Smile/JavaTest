package cl.smile.javatest.funciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import cl.smile.javatest.model.FechaEntity;
import cl.smile.javatest.model.pk.FechaPk;
import lombok.Getter;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
public class ManipuladorEntidadDto {

    @Getter
    private static List<FechaEntity> listTramo = new ArrayList<>();
    @Getter
    private static List<FechaEntity> listNoTramo = new ArrayList<>();
    
    /**
     * @param fechaActual Parametro que requiere fecha habil actual entregada por comando
     * @param fechaAnterior Parametro que requiere fecha habil anterior entregada por comando
     */
    public synchronized static void setTramos(Date fechaActual,Date fechaAnterior){

        for(Date i = fechaActual;(i.compareTo(fechaAnterior))>=0;i = DateUtils.addHours(i,-12)){
            FechaEntity auxTramo = new FechaEntity();
            FechaPk auxTramoPk = new FechaPk();
            auxTramoPk.setFechaDate(i);
            String fecha = TimeModifier.dateToString("ddMMyyyy", i);
            auxTramo.setFechaC(fecha);
            String hora = TimeModifier.dateToString("HH:mm:ss", i);
            auxTramo.setHoraStr(hora);
            auxTramoPk.setTramoInt(0);
            auxTramo.setId(auxTramoPk);
            
            ManipuladorEntidadDto.listTramo.add(auxTramo);
        }

        Date nuevaActual = DateUtils.addHours(fechaActual,-48);
        Date nuevaAnterior = DateUtils.addHours(fechaAnterior,-48);
        for(Date i = nuevaActual;(i.compareTo(nuevaAnterior))>=0;i = DateUtils.addHours(i,-24)){
            FechaEntity auxTramo = new FechaEntity();
            FechaPk auxTramoPk = new FechaPk();
            auxTramoPk.setFechaDate(i);
            String fecha = TimeModifier.dateToString("ddMMyyyy", i);
            auxTramo.setFechaC(fecha);
            String hora = TimeModifier.dateToString("HH:mm:ss", i);
            auxTramo.setHoraStr(hora);
            auxTramoPk.setTramoInt(1);
            auxTramo.setId(auxTramoPk);
            
            ManipuladorEntidadDto.listNoTramo.add(auxTramo);
        }
    }
}
