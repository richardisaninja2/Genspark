package com.company.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InputData {
    public static ArrayList<String> list = new ArrayList<>();
    private static String inputDate;
    private static String origin;
    private static String destination;
    private static String age;
    private static String gender;

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        InputData.age = age;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        InputData.gender = gender;
    }

    public String getInputDate() {
        return inputDate;
    }
    public void setInputDate(String inputDate) {
        InputData.inputDate = inputDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        InputData.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        InputData.destination = destination;
    }

    public InputData(){}

    public void getInputs() throws IOException {

        Scanner scanner = new Scanner(System.in);

        int boardingPassNumber = 0; //generate id by looking in file

        String id = idHandler();
        String name = nameHandler();
        String email = emailHandler();
        String gender = genderHandler();
        String phoneNumber = phoneNumberHandler();

        String age = ageHandler();
        String origin = originHandler();
        String destination = destinationHandler();
        String departureTime = departureTimeHandler();
        String ticketPrice = ticketPriceHandler();
        ArrayList<String> newList = getList();

    }

    public String ticketPriceHandler(){
        String ticketPrice = GenerateTicketPrice.getTicketPrice();
        list.add(ticketPrice);
        return ticketPrice;
    }
    public String idHandler() throws FileNotFoundException {
        File file = new File("saveData.txt");
        Scanner scanner = new Scanner(file);
        int actualIdInt = 0;
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            if(!data.isEmpty()){
                String[] dataArr = data.split(",");
                String stringId = dataArr[0].substring(1);
                actualIdInt = Integer.parseInt(stringId);
            }
        }
        String uniqueId = String.valueOf(actualIdInt + 1);
        list.add(uniqueId);
        return uniqueId;
    }
    public String nameHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your Name");
        String name = scanner.nextLine();
        if(!name.isEmpty()){
            list.add(name);
        }else{
            return nameHandler();
        }

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
            list.add(phoneNumber);
        }else{
            return phoneNumberHandler();
        }

        return phoneNumber;
    }
    public String ageHandler(){
        System.out.println("Please input age");
        Scanner scanner = new Scanner(System.in);
        int age = 0;
        if(scanner.hasNextInt()){
            age = scanner.nextInt();
            list.add(String.valueOf(age));
            InputData.setAge(String.valueOf(age));
        }else{
            return ageHandler();
        }

        return String.valueOf(age);
    }
    public String destinationHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where do you want to go to?");
        String destination = scanner.nextLine();
        if(destination.isEmpty()){
            return destinationHandler();
        }else{
            destination = destination;
            this.destination = destination;
            this.setDestination(destination);
            if(list.size() <= 7){
                list.add("destination");

            }else{
                list.set(7, destination);
            }
        }
        return destination;
    }

    public String originHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Input where you intend to DEPART from");
        String origin = scanner.nextLine();
        if(origin.isEmpty()){
            return originHandler();
        }else{
            origin = origin;
            if(list.size() <= 6){
                list.add("origin");
            }

            this.origin = origin;
            this.setOrigin(origin);
        }
        list.set(6, origin); //incase it needs to be updates hold the position with 0 and update it every time the function is called
        return origin;
    }
    public String genderHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Gender (M, or F)");
        String gender = scanner.nextLine();
        if(gender.equals("M") || gender.equals("m") || gender.equals("f") || gender.equals("F")){
            gender = gender;
            list.add(gender);
            InputData.setGender(gender);
        }else{
            return getGender();
        }

        return gender;
    }
    public String departureTimeHandler() throws IOException {
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
    public void etaHandler(int[] arr) throws IOException {
        //look into implementing an api to call to google maps to bring in actual eta's
        TripInformation tripInformation = new TripInformation();
        String tripInformationValues = tripInformation.getTripInformation(InputData.origin, InputData.destination);
        int[] newArr = tripInformation.convertTimeStringToInts(tripInformationValues);
        while(newArr[0] == 0 && newArr[1] == 0){
            System.out.println("Please enter a valid Origin and Destination");
            originHandler();
            destinationHandler();
             tripInformationValues = tripInformation.getTripInformation(InputData.origin, InputData.destination);
             newArr = tripInformation.convertTimeStringToInts(tripInformationValues);
        }{
        int hours = arr[0];
        int mins = arr[1];
        int tripHours = newArr[0];
        int tripMins = newArr[1];


        int finalHour = 0;
        int finalMins = 0;

        int totalHours = tripHours + hours;
        int actualEtaMins = tripMins + mins;

        double etaDouble = actualEtaMins;
//        System.out.println(etaDouble);
        double tempMin = 0;

       if(actualEtaMins < 59){
           finalHour = hours + tripHours;
           finalMins = actualEtaMins;
       }else if(actualEtaMins > 59){
           finalHour = totalHours + (int)Math.floor(etaDouble/60);
           tempMin = (((double)actualEtaMins/60) - Math.floor(actualEtaMins/60)) * 60;
           finalMins = (int) tempMin;
       }

        int[] arrayToBeConverted = {finalHour, finalMins};
        convertEtaToDate(arrayToBeConverted);
    }

    return;
    }

    public String departureDateTimeHandler(int[] arr){
        int h = arr[0];
        int m = arr[1];
//        System.out.println(h);
//        System.out.println(m);
        SimpleDateFormat dateInput = new SimpleDateFormat("MM-dd-yyyy HH:mm"); //"yyyy-MM-dd"
        System.out.println("Please input date in format (MM-dd-yyyy)");
        Scanner input = new Scanner(System.in);
        //ternary to add a 0 before the minute if minute is less than 10
        String next = input.nextLine();

        String strDate = arr[1] >= 10 ? next+" "+arr[0]+":"+arr[1] : next+" "+arr[0]+":"+0+arr[1];


        this.setInputDate(next);
//        System.out.println( "input data "+  this.getInputDate());

        //System.out.println(strDate);
        if(strDate.matches("(\\d{2})-(\\d{2})-(\\d{4}) ([01]?[0-9]|2[0-3]):([0-5]?[0-9]|60)")){
            try{
                Date date = dateInput.parse(strDate);
                //formatted date that needs to go in ArrayList
                //new SimpleDateFormat("yyy-MM-dd").format(date)

//                System.out.printf("Departure Date: %tc", date); //this is to show in a readable context
                //put into hashMap
                if(list.size() <= 8){
                    list.add("x");

                }list.set(8, String.valueOf(date));
//                list.add(String.valueOf(date));

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
        double tempH = 0;

        if(h > 24){
            tempH = ((((double)h / 24) - (int)Math.floor(h/24)) * 24);
            h = (int)tempH;
            System.out.println(h);

            //added code below this for if houyr is above 24
            System.out.println("eta h" + h);
//        System.out.println("eta m" +m);
            SimpleDateFormat dateInput = new SimpleDateFormat("MM-dd-yyyy HH:mm"); //"yyyy-MM-dd"


            //ternary to add a 0 before the minute if minute is less than 10
            String strDate = arr[1] >= 10 ? this.getInputDate()+" "+arr[0]+":"+arr[1] : this.getInputDate()+" "+arr[0]+":"+0+arr[1];
            strDate = arr[0] >= 10 ? this.getInputDate()+" "+h+":"+m : this.getInputDate()+" "+0+h+":"+m;

//        System.out.println(strDate);
            if(strDate.matches("(\\d{2})-(\\d{2})-(\\d{4}) ([01]?[0-9]|2[0-3]):([0-5]?[0-9]|60)")){
                try{
                    Calendar c = Calendar.getInstance();
                    c.setTime(dateInput.parse(strDate));
                    c.add(Calendar.DATE, 1);
                    String arrTime = dateInput.format(c.getTime());
//                    Date date = dateInput.parse(strDate);

//                list.add(String.valueOf(date));
                    int size = list.size();
                    if(list.size() <= 9){
                        list.add("g");

                    }
                    list.set(9,arrTime);

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
        }else {
//        System.out.println("eta h" + h);
//        System.out.println("eta m" +m);
            SimpleDateFormat dateInput = new SimpleDateFormat("MM-dd-yyyy HH:mm"); //"yyyy-MM-dd"


            //ternary to add a 0 before the minute if minute is less than 10
            String strDate = arr[1] >= 10 ? this.getInputDate() + " " + arr[0] + ":" + arr[1] : this.getInputDate() + " " + arr[0] + ":" + 0 + arr[1];
            strDate = arr[0] >= 10 ? this.getInputDate() + " " + h + ":" + m : this.getInputDate() + " " + 0 + h + ":" + m;

//        System.out.println(strDate);
            if (strDate.matches("(\\d{2})-(\\d{2})-(\\d{4}) ([01]?[0-9]|2[0-3]):([0-5]?[0-9]|60)")) {
                try {
                    Date date = dateInput.parse(strDate);
//                list.add(String.valueOf(date));
                    int size = list.size();
                    if (list.size() <= 9) {
                        list.add("g");

                    }
                    list.set(9, String.valueOf(date));

                    //formatted date that needs to go in ArrayList
                    //new SimpleDateFormat("yyy-MM-dd").format(date)
//                System.out.printf("Arrival Date: %tc", date); //this is to show in a readable context
                } catch (ParseException e) {
                    System.out.println("parse exception");
                }
            } else {
                departureDateTimeHandler(arr);
            }
            return strDate;
        }

    }

}
