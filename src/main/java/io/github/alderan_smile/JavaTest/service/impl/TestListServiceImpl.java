package io.github.alderan_smile.JavaTest.service.impl;

import function_fun.OtherFun.FunRandomizer;
import io.github.alderan_smile.JavaTest.model.MavenTest;
import io.github.alderan_smile.JavaTest.model.pk.MavenTestPk;
import io.github.alderan_smile.JavaTest.pojo.TestResponse;
import io.github.alderan_smile.JavaTest.repository.MavenRepository;
import io.github.alderan_smile.JavaTest.service.TestListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.3.14                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Slf4j
@Service
public class TestListServiceImpl implements TestListService {

    @Autowired
    private MavenRepository mavenRepository;

    private FunRandomizer funRandomizer = new FunRandomizer();

    @Override
    public ResponseEntity<?> testListDashboard() {

        List<MavenTest> mavenTestList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            MavenTest mavenTest = new MavenTest();
            MavenTestPk mavenTestPk = new MavenTestPk();

            mavenTestPk.setIdentificador(funRandomizer.randomInt(1,99999).toString());
            mavenTest.setJavaExec("JavaTest.jar/list");
            mavenTest.setFechaExec(new Date());
            mavenTest.setMessage("Java Test Boot/list");
            mavenTest.setMavenTestPk(mavenTestPk);
            mavenTestList.add(mavenTest);
        }

        try {
            mavenRepository.saveAll(mavenTestList);
            TestResponse testResponse = new TestResponse();
            testResponse.setMessage("Test List OK");
            testResponse.setStatus("200");
            return ResponseEntity.ok(testResponse);
        } catch (Exception e) {
            log.error("Error: ", e);
            TestResponse testResponse = new TestResponse();
            testResponse.setMessage("Test List Error: "+e.getMessage());
            testResponse.setStatus("500");
            return ResponseEntity.ok(testResponse);
        }
    }
}
