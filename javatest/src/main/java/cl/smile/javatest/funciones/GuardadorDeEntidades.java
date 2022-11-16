package cl.smile.javatest.funciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.smile.javatest.model.FechaEntity;
import cl.smile.javatest.repository.FechaRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@Slf4j
@Component
public class GuardadorDeEntidades {

    @Autowired
    public static FechaRepository fechaRepository;

    public GuardadorDeEntidades(FechaRepository fechaRepository){
        this.fechaRepository = fechaRepository;
    }

    public static void guardaDataBase(List<FechaEntity> lista1,List<FechaEntity> lista2){
        log.info("{}",lista1);
        fechaRepository.saveAll(lista1);
        log.info("{}",lista2);
        fechaRepository.saveAll(lista2);
    }
}
