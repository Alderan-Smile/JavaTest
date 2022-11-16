package cl.smile.javatest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.smile.javatest.funciones.GuardadorDeEntidades;
import cl.smile.javatest.repository.FechaRepository;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@Configuration
@ComponentScan("cl.smile.javatest")
public class SpringConfigurador {

    @Autowired
    FechaRepository fechaRepository;    
}
