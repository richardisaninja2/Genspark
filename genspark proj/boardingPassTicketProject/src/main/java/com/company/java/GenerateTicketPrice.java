package com.company.java;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class GenerateTicketPrice {
    private static String ticketPrice;

    public static String getTicketPrice() {
        return ticketPrice;
    }

    public static void setTicketPrice(String ticketPrice) {
        GenerateTicketPrice.ticketPrice = ticketPrice;
    }

    public String generateTicketPrice(int[] arr) throws IOException {
        TripInformation tripInformation = new TripInformation();
        InputData inputData = new InputData();

        int travelHours = Math.max(arr[0], 1);
        int ticketPrice = 100*travelHours;
        double ageDiscount = 0;
        double genderDiscount = 0;
        int discountedPrice = 0;

        int age = Integer.parseInt(InputData.getAge());
        String gender = InputData.getGender();

        if(age <= 12){
            ageDiscount = .5;
        }if(age >= 60){
            ageDiscount = .6;
        }
        if(gender.equals("f") || gender.equals("F")){
            genderDiscount = .25;
        }

        double finalDiscount = Math.max(ageDiscount, genderDiscount);
        if(finalDiscount > 0){
            discountedPrice = (int)(ticketPrice - (ticketPrice*finalDiscount));
        }else{
            discountedPrice = ticketPrice;
        }

        String finalTicketPrice = "$"+discountedPrice;

        GenerateTicketPrice.setTicketPrice(finalTicketPrice);

        return ("$"+discountedPrice);
    }


}
