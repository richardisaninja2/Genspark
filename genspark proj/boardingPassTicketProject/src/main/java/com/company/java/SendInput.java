package com.company.java;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SendInput {
    InputData inputData = new InputData();
    ReceiveInput receiveInput = new ReceiveInput();

    public void save() throws IOException {

        Charset utf8 = StandardCharsets.UTF_8;
        // List<String> list = Arrays.asList("\n");
//        File file  = new File("C:\\Users\\ososm\\Desktop\\Genspark\\genspark proj\\boardingPassTicketProject\\src\\main\\java\\com\\company\\java\\saveData.txt");
//        PrintWriter writer  = new PrintWriter(file);
        String info =  Arrays.toString(inputData.getList().toArray(new String[0]));
       // String line = "\n";
        Files.write(Paths.get("saveData.txt"), Collections.singleton(info), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }

    public void userSaveInfo() throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        GenerateTicketPrice generateTicketPrice = new GenerateTicketPrice();

        Files.write(Paths.get("UserInfo.txt"), Collections.singleton(receiveInput.getInfo()), StandardOpenOption.CREATE);
    }


}
