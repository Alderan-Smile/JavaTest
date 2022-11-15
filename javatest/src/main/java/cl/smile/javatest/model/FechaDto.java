package cl.smile.javatest.model;

import java.util.Date;

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
@Data
public class FechaDto {
    
    private Date fechaDate;
    private String fechaC;
    private String horaStr;
    private Integer tramoInt;
}