package io.github.alderan_smile.JavaTest.service.impl;

import function_fun.OtherFun.FunRandomizer;
import io.github.alderan_smile.JavaTest.model.MavenTest;
import io.github.alderan_smile.JavaTest.model.pk.MavenTestPk;
import io.github.alderan_smile.JavaTest.pojo.TestResponse;
import io.github.alderan_smile.JavaTest.repository.MavenRepository;
import io.github.alderan_smile.JavaTest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.58                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MavenRepository mavenRepository;

    private FunRandomizer funRandomizer = new FunRandomizer();

    @Override
    public ResponseEntity<?> testDashboard() {

        MavenTest mavenTest = new MavenTest();
        MavenTestPk mavenTestPk = new MavenTestPk();

        //mavenTestPk.setIdentificador(funRandomizer.randomInt(1,99999).toString());
        mavenTestPk.setIdentificador("16628");
        log.info("ID: {}",mavenTestPk.getIdentificador());
        mavenTest.setMavenTestPk(mavenTestPk);
        mavenTest.setFechaExec(new Date());
        mavenTest.setJavaExec("JavaTest.jar");
        mavenTest.setMessage("Java Test Boot");

        try {
            mavenRepository.save(mavenTest,mavenTest.getMavenTestPk());
            TestResponse testResponse = new TestResponse();
            testResponse.setMessage("Test OK");
            testResponse.setStatus("200");
            return ResponseEntity.ok(testResponse);
        } catch (Exception e) {
            log.error("Error: ", e);
            TestResponse testResponse = new TestResponse();
            testResponse.setMessage("Test Error: "+e.getMessage());
            testResponse.setStatus("500");
            return ResponseEntity.ok(testResponse);
        }
    }
}
