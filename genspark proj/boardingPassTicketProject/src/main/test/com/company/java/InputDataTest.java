package com.company.java;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class InputDataTest {
    InputData inputData ;

    @BeforeEach
    void setUp() {
        inputData = new InputData();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void idHandler() throws FileNotFoundException {
        assertEquals("104", inputData.idHandler(), "returned the wrong id");
    }



}