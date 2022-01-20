package com.company.java;

import org.jsoup.Jsoup;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputData inputData = new InputData();
        SendInput sendInput = new SendInput();
        ReceiveInput receiveInput = new ReceiveInput();
//        String mario = "mario";
//        inputData.getInputs();
//        sendInput.save();
        receiveInput.getSpecificUser("rosa");
        //receiveInput.getInfo();
//        System.out.println(Jsoup.connect("https://www.travelmath.com/flying-time/from/Dallas,+TX/to/Oregon+City,+OR").get());
    }
}
