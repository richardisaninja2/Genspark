package com.company.java;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class InputData {
    public static ArrayList<String> list = new ArrayList<>();
    private String inputDate;

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public InputData(){}

    public void getInputs() {

        Scanner scanner = new Scanner(System.in);

        int boardingPassNumber = 0; //generate id by looking in file


        String name = nameHandler();
        String email = emailHandler();
        String gender = getGender();
        String phoneNumber = phoneNumberHandler();

        String age = ageHandler();
        String origin = originHandler();
        String destination = destinationHandler();
        String departureTime = departureTimeHandler();
        ArrayList<String> newList = getList();

    }
    public String nameHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your Name");
        String name = scanner.nextLine();
        list.add(name);
        return name;
    }

    public String emailHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your email address");
        String email = scanner.nextLine();
        if(email.matches("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
            email = email;
        }else{
            return emailHandler();
        }
        list.add(email);
        return email;

    }
    public String phoneNumberHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your phone number (xxx-xxx-xxxx)");
        String phoneNumber = scanner.nextLine();
        if(phoneNumber.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")){
            phoneNumber = phoneNumber;
        }else{
            return phoneNumberHandler();
        }
        list.add(phoneNumber);
        return phoneNumber;
    }
    public String ageHandler(){
        System.out.println("Please input age");
        Scanner scanner = new Scanner(System.in);
        int age = 0;
        if(scanner.hasNextInt()){
            age = scanner.nextInt();
            list.add(String.valueOf(age));
        }else{
            return ageHandler();
        }

        return String.valueOf(age);
    }
    public String destinationHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where do you want to go to?");
        String destination = scanner.nextLine();
        destination =  destination.isEmpty() ? destinationHandler() : destination; //if the input is empty run the function again else return the destination
        list.add(destination);
        return destination;
    }

    public String originHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Input where you intend to DEPART from");
        String origin = scanner.nextLine();
        origin = origin.isEmpty() ? originHandler() : origin; //if the input is empty run the function again else return the origin
        list.add(origin);
        return origin;
    }
    public String getGender(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Gender (M, or F)");
        String gender = scanner.nextLine();
        gender = gender.equals("M") ? gender: gender.equals("m") ? gender : gender.equals("F") ? gender : gender.equals("f") ? gender : getGender();
        list.add(gender);
        return gender;
    }
    public String departureTimeHandler(){
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
        etaHandler(arr);
        return hour +"-"+ minute;
    }
    public String etaHandler(int[] arr){
        //look into implementing an api to call to google maps to bring in actual eta's
        int max = 200;
        int min = 20;
        int range = max - min + 1;
        int hours = arr[0];
        int mins = arr[1];
        int hourArr = 0;
        int minArr = 0;
        int finalHour = 0;
        int finalMins = 0;
        int randomTimeEta = (int)(Math.random() * range) + min;
        double totalEtaDivided = randomTimeEta;
        int floor = (int)Math.floor(randomTimeEta/60);
        System.out.println(totalEtaDivided);
        double tempMin = 0;

        if(totalEtaDivided < 59){
            hourArr = hours;
           minArr = (int )(mins + totalEtaDivided);
        }else if(totalEtaDivided > 59){
            hourArr = hours+ floor;
            minArr =  mins + (int)((totalEtaDivided/60 - floor) *60);
            //if minArr is over 60 add 1 to hours and move the remainder to the mins
            if(minArr > 59){
                finalHour = hourArr + (int)(Math.floor((double)minArr/60)) - 1;
                tempMin = ((double) minArr/60 - Math.floor((double)minArr/60)) * 60;
                finalMins = (int)tempMin;
            }

        }
//        System.out.println("hours" +finalHour);
//        System.out.println("mins " + finalMins);
        int[] arrayToBeConverted = {hourArr, minArr};
//        convertEtaToDate(arrayToBeConverted);
        list.add(hourArr+"-"+minArr);
        convertEtaToDate(arr);
    return hourArr +"-"+ minArr;
    }

    public String departureDateTimeHandler(int[] arr){
        int h = arr[0];
        int m = arr[1];
        SimpleDateFormat dateInput = new SimpleDateFormat("MM-dd-yyyy hh:mm"); //"yyyy-MM-dd"
        System.out.println("Please input date in format (MM-dd-yyyy)");
        Scanner input = new Scanner(System.in);
        //ternary to add a 0 before the minute if minute is less than 10
        String next = input.nextLine();
        String strDate = arr[1] >= 10 ? next+" "+arr[0]+":"+arr[1] : next+" "+arr[0]+":"+0+arr[1];
        this.setInputDate(next);
//        System.out.println( "input data "+  this.getInputDate());

//        System.out.println(strDate);
        if(strDate.matches("(\\d{2})-(\\d{2})-(\\d{4}) (\\d{2}):(\\d{2})")){
            try{
                Date date = dateInput.parse(strDate);
                //formatted date that needs to go in ArrayList
                //new SimpleDateFormat("yyy-MM-dd").format(date)

//                System.out.printf("Departure Date: %tc", date); //this is to show in a readable context
                //put into hashMap
                list.add(String.valueOf(date));
            } catch (ParseException e) {
                System.out.println("parse exception");
            }
        }else{
            departureDateTimeHandler(arr);
        }
        return strDate;
    }

    public ArrayList<String> getList(){
//        System.out.println("hashmap = "+list);
        return list;
    }

    public String convertEtaToDate(int[] arr){
        int h = arr[0];
        int m = arr[1];
        SimpleDateFormat dateInput = new SimpleDateFormat("MM-dd-yyyy hh:mm"); //"yyyy-MM-dd"


        //ternary to add a 0 before the minute if minute is less than 10
        String strDate = arr[1] >= 10 ? this.getInputDate()+" "+arr[0]+":"+arr[1] : this.getInputDate()+" "+arr[0]+":"+0+arr[1];

//        System.out.println(strDate);
        if(strDate.matches("(\\d{2})-(\\d{2})-(\\d{4}) (\\d{2}):(\\d{2})")){
            try{
                Date date = dateInput.parse(strDate);
                list.add(String.valueOf(date));
                //formatted date that needs to go in ArrayList
                //new SimpleDateFormat("yyy-MM-dd").format(date)
//                System.out.printf("Arrival Date: %tc", date); //this is to show in a readable context
            } catch (ParseException e) {
                System.out.println("parse exception");
            }
        }else{
            departureDateTimeHandler(arr);
        }
        return strDate;
    }

}
