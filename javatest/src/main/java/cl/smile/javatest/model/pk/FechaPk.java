package cl.smile.javatest.model.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FechaPk implements Serializable{
    
    @Column(name = "FECHA_DATA")
    private Date fechaDate;
    @Column(name = "TRAMO")
    private Integer tramoInt;
}
