package com.company.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;

public class TripInformation {
    public String getTripInformation(String from, String to) throws IOException {
//        System.out.println(Jsoup.connect("https://www.travelmath.com/flying-time/from/Dallas,+TX/to/Oregon+City,+OR").get());
        String url = "https://www.travelmath.com/flying-time/from/"+from+"/to/"+to;
        Document document = Jsoup.connect(url).get();
        Element time = document.getElementById("flyingtime");
        String timeText = "0 0";
        if(time != null){
            timeText = time.text();
            //check to make sure there is an hour or else the program breaks
//
//        System.out.println(timeText);
            convertTimeStringToInts(timeText);
        }
        return timeText;
    }
    public int[] convertTimeStringToInts(String time) throws IOException {
        GenerateTicketPrice generateTicketPrice = new GenerateTicketPrice();
    String[] wordSplit = time.split(" ");
//        System.out.println("wordSplit "+ Arrays.toString(wordSplit));
        int hour = 0;
        int min = 0;
        if(wordSplit.length == 1){
            hour = 0;
            min = 0;
        }
        if(wordSplit.length == 2){
            hour = 0;
            min = Integer.parseInt(wordSplit[0]);
        }else{
            hour = Integer.parseInt(wordSplit[0]);
            min = Integer.parseInt(wordSplit[2]);
        }
//        System.out.println("hour" + hour + "min"+ min);

       int[] arr = {hour, min};
        generateTicketPrice.generateTicketPrice(arr);
    return arr;
    }
}
