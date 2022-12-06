package cl.smile.javatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import cl.smile.javatest.config.PropiedadesConfig;
import cl.smile.javatest.funciones.FileEscritor;
import cl.smile.javatest.funciones.GuardadorDeEntidades;
import cl.smile.javatest.funciones.ManipuladorEntidadDto;
import org.springframework.context.ConfigurableApplicationContext;
import cl.smile.javatest.funciones.TimeModifier;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@SpringBootApplication
@PropertySource(value = {"file:../javatest/JavaTest.properties"})
@Slf4j
public class App {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);

        Date cal = new Date();
        Date cale = DateUtils.addHours(cal, -48);

        ManipuladorEntidadDto.setTramos(cal,cale);

        List<Long> terra = new ArrayList<Long>(Arrays.asList(58L,36L,54L));

        log.info("########################################################################################");
        log.info("########################################################################################");

        for(Date i=cal;i.compareTo(cale)>=0;i = DateUtils.addHours(i, -24)){
            log.info("Obteniendo hora de las fechas procesadas {}",TimeModifier.dateToString("HH:mm:ss",i));
            log.info("Numero obtenido por comparacion de fechas {}",i.compareTo(cale));
            log.info("Representacion de fecha por Date {}",i);
            log.info("----------------------------------------------------------------------------------------");
        }
        
        log.info("########################################################################################");
        log.info("########################################################################################");

        log.info("Obteniendo fecha completa procesada desde String {}",TimeModifier.stringToDate("dd/MM/yyyy HH:mm:ss", "31/02/2022 28:86:98"));

        log.info("########################################################################################");
        log.info("########################################################################################");

        log.info("Comienza escritura de archivos");
        FileEscritor.escribirArchivo(ManipuladorEntidadDto.getListTramo(),PropiedadesConfig.getFileName());
        FileEscritor.escribirArchivo(ManipuladorEntidadDto.getListNoTramo(),PropiedadesConfig.getFileNameNo());
        log.info("Termina escritura de archivos");
        
        log.info("########################################################################################");
        log.info("########################################################################################");

        log.info("Guardando fechas en DataBase");
        GuardadorDeEntidades.guardaDataBase(ManipuladorEntidadDto.getListTramo(),ManipuladorEntidadDto.getListNoTramo());
        log.info("Fechas guardadas en DataBase");

        log.info("########################################################################################");
        log.info("########################################################################################");

        log.info("{}", ManipuladorEntidadDto.getListTramo().stream().filter(p->p.getFechaC().equals("15112022")).collect(Collectors.toList()));
        
        log.info("########################################################################################");
        log.info("########################################################################################");

        log.info("Terra {}",terra.stream().filter(i->i.equals(58L)).toString());

        ctx.close();
    }
}