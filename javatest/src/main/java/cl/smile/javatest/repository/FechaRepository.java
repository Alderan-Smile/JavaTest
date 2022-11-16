package cl.smile.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.smile.javatest.model.FechaEntity;
import cl.smile.javatest.model.pk.FechaPk;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
public interface FechaRepository extends JpaRepository<FechaEntity,FechaPk>{
    
}
