package com.company.java;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GenerateTicketPriceTest {

    TripInformation tim = new TripInformation();
    GenerateTicketPrice lim = new GenerateTicketPrice();

    @BeforeEach
    void setUp() {


    }

    @Test
    void generateTicketPriceTest() throws IOException {
        int[] arr = {2, 5};

        InputData.setAge("25");
        InputData.setGender("F");
        assertEquals("$150", lim.generateTicketPrice(arr), "Test pass");
    }


    @Test
    void convertTimeStringToIntsTest() throws IOException {
        InputData.setAge("25");
        InputData.setGender("F");
        String time = "1 hour, 40 minutes";
        int[] arr = {1, 40};

        assertArrayEquals(arr, tim.convertTimeStringToInts(time), "Test pass");
    }


    @AfterEach
    void tearDown() {
    }


}