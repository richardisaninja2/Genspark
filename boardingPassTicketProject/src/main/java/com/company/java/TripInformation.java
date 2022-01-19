package com.company.java;

import org.jsoup.Jsoup;

import java.io.IOException;

public class TripInformation {
    public String getTripInformation() throws IOException {
        System.out.println(Jsoup.connect("https://www.travelmath.com/flying-time/from/Dallas,+TX/to/Oregon+City,+OR").get());
        

        return "";
    }
}
