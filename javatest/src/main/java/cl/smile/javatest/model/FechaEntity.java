package cl.smile.javatest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cl.smile.javatest.model.pk.FechaPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FECHACONJUNTO", schema = "ALDERAN")
@Entity
@Data
public class FechaEntity {
    
    @Id
    @EmbeddedId
    private FechaPk id;
    @Column(name = "FECHA_CORTA")
    private String fechaC;
    @Column(name = "HORA")
    private String horaStr;
}