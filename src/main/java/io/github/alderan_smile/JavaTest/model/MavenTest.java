package io.github.alderan_smile.JavaTest.model;

import function_fun.SuitJdbcSpring.AnnotationsJdbcSpring.ColumnName;
import function_fun.SuitJdbcSpring.AnnotationsJdbcSpring.PrimaryKey;
import function_fun.SuitJdbcSpring.AnnotationsJdbcSpring.TableName;
import io.github.alderan_smile.JavaTest.model.pk.MavenTestPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.31                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("maven_test")
public class MavenTest {

    @PrimaryKey
    private MavenTestPk mavenTestPk;

    @ColumnName("FECHA_EXEC")
    private Date fechaExec;
    @ColumnName("JAVA_EXEC")
    private String javaExec;
    @ColumnName("MESSAGE")
    private String message;
}
