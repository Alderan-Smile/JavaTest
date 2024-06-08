package io.github.alderan_smile.JavaTest.controller;

import io.github.alderan_smile.JavaTest.service.TestListService;
import io.github.alderan_smile.JavaTest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.0.57                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Slf4j
@RestController
@RequestMapping("/web")
public class WebController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestListService testListService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> testDashboard() {
        return testService.testDashboard();
    }

    @GetMapping(value = "/testList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> testList() {
        return testListService.testListDashboard();
    }
}
