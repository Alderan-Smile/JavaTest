package io.github.alderan_smile.JavaTest.model.pk;

import function_fun.SuitJdbcSpring.AnnotationsJdbcSpring.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.33                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MavenTestPk {

    @ColumnName("ID_EXEC")
    private String identificador;
}
