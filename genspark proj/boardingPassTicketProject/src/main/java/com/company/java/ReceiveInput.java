package com.company.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReceiveInput {

    public String getInfo() throws IOException {
    String data = "";
    File getInfoFile = new File("saveData.txt");
    Scanner scan =  new Scanner(getInfoFile);

    while(scan.hasNext()) {
        data = scan.nextLine();
    }

    String[] info = data.split(",");


       String answer = "Ticket Price: "+info[10].substring(0, info[10].length() - 1) + "\n\nName: " + info[1].substring(1).toUpperCase() + "\n" + "Email:" + info[2] + "\n" + "Sex:" + info[3].toUpperCase() + "\nPhone Number:" + info[4] + "\nAge:  " + info[5]
               + "\nDepart From:" + info[6].toUpperCase() + "\nGoing To:" + info[7].toUpperCase() + "\nDate : " + info[8] + "\nETA:  " + info[9] + "\nTicket ID#: " +info[0].substring(1);



        return answer;

    }


}
