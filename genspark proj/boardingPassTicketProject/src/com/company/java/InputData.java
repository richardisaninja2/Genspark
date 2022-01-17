package com.company.java;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputData {
    public InputData(){}
    public static void getInputs() {
        Scanner scanner = new Scanner(System.in);

        int boardingPassNumber = 0; //generate id by looking in file

        System.out.println("input Name");
        String name = scanner.nextLine();
        System.out.println("input Email");
        String email = emailHandler();
        String gender = getGender();
        String phoneNumber = phoneNumberHandler();

        int age = ageHandler();
        String origin = originHandler();
        String destination = destinationHandler();
        int[] eta = etaHandler();
        int[] departureTime = departureTimeHandler(); //handles departure time and departure dateTime

    }


    public static String emailHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your email address");
        String email = scanner.nextLine();
        if(email.matches("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
            email = email;
        }else{
            return emailHandler();
        }
        return email;
    }
    public static String phoneNumberHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your phone number");
        String phoneNumber = scanner.nextLine();
        if(phoneNumber.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")){
            phoneNumber = phoneNumber;
        }else{
            return phoneNumberHandler();
        }
        return phoneNumber;
    }
    public static int ageHandler(){
        System.out.println("Please input age");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        return age;
    }
    public static String destinationHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where do you want to go to?");
        String destination = scanner.nextLine();
        return destination.isEmpty() ? destinationHandler() : destination; //if the input is empty run the function again else return the destination

    }
    public static int[] etaHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the Hour you intend to ARRIVE (formatted 01 for 1:00am)");
        int hour = 0;
        int minute = 0;
        if(scanner.hasNextInt()){
            hour = scanner.nextInt();
            if(hour <= 24 && hour >= 0){ //handles if hour is greater than 24
                hour = hour;
            }else{
                System.out.println("Please enter an hour less than 24");
                return etaHandler();
            }
        }else{
            return etaHandler();
        }
        System.out.println("Please input the minute you intend to ARRIVE (formatted 05 for the 5th minute)");
        if(scanner.hasNextInt()){
            minute = scanner.nextInt();
            if(minute <= 60 && minute >= 0){ //handles if hour is greater than 24
                minute = minute;
            }else{
                System.out.println("Please enter minutes less than 60");
                return etaHandler();
            }
        }else{
            return etaHandler();
        }
        int[] arr = {hour, minute};
        return arr;
    }
    public static String originHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Input where you intend to DEPART from");
        String origin = scanner.nextLine();
        return origin = origin.isEmpty() ? originHandler() : origin; //if the input is empty run the function again else return the origin
    }
    public static String getGender(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Gender (M, or F)");
        String gender = scanner.nextLine();
        gender = gender.equals("M") ? gender: gender.equals("m") ? gender : gender.equals("F") ? gender : gender.equals("f") ? gender : getGender();
        return gender;
    }
    public static int[] departureTimeHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the hour you intend to DEPART (formatted 01 for 1:00am)");
        int hour = 0;
        int minute = 0;
        if(scanner.hasNextInt()){
            hour = scanner.nextInt();
            if(hour <= 24 && hour >= 0){ //handles if hour is greater than 24
                hour = hour;
            }else{
                System.out.println("Please enter an hour less than 24");
                return departureTimeHandler();
            }
        }else{
            return departureTimeHandler();
        }
        System.out.println("Please input the minute you intend to depart (formatted 05 for the 5th minute)");
        if(scanner.hasNextInt()){
            minute = scanner.nextInt();
            if(minute <= 60 && minute >= 0){ //handles if hour is greater than 24
                minute = minute;
            }else{
                System.out.println("Please enter minutes less than 60");
                return departureTimeHandler();
            }
        }else{
            return departureTimeHandler();
        }
        int[] arr = {hour, minute};
        departureDateTimeHandler(arr);
        return arr;
    }

    public static String departureDateTimeHandler(int[] arr){
        int h = arr[0];
        int m = arr[1];
        SimpleDateFormat dateInput = new SimpleDateFormat("MM-dd-yyyy hh:mm"); //"yyyy-MM-dd"
        System.out.println("Please input date in format (MM-dd-yyyy hh:mm)");
        Scanner input = new Scanner(System.in);
        //ternary to add a 0 before the minute if minute is less than 10
        String strDate = arr[1] >= 10 ? input.nextLine()+" "+arr[0]+":"+arr[1] : input.nextLine()+" "+arr[0]+":"+0+arr[1];

        System.out.println(strDate);
        if(strDate.matches("(\\d{2})-(\\d{2})-(\\d{4}) (\\d{2}):(\\d{2})")){
            try{
                Date date = dateInput.parse(strDate);
                //formatted date that needs to go in ArrayList
                //new SimpleDateFormat("yyy-MM-dd").format(date)
                System.out.printf("Departure Date: %tc", date); //this is to show in a readable context
            } catch (ParseException e) {
                System.out.println("parse exception");
            }
        }else{
            departureDateTimeHandler(arr);
        }
        return strDate;
    }


}
