package io.github.alderan_smile.JavaTest.repository;

import function_fun.SuitJdbcSpring.FunJdbcSpringSave;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.38                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/

public interface MavenRepository extends FunJdbcSpringSave {

    public Integer testConnection();
}
