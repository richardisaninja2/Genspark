import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertListToColumns {
    public ArrayList<String> oneToSevenToArrayList() throws IOException {
        Imports imports = new Imports();
        List <String> list = imports.imports();
        ArrayList<String> wordsByColumns = new ArrayList<>();

        int i = 0;
        int columns = (int)Math.floor(list.size() / 2);
        while(i < columns){
            //combine the first and third word from the original list (not the last word... it'll throw and exception) and add them to a new ArrayList
            wordsByColumns.add(list.get(i) +" "+list.get(i + 4) + "\n");
            i++;
        }
        //add the last number from the original list into the list
        wordsByColumns.add(list.get(list.size() - 1));
        System.out.println(wordsByColumns);
        //return the arrayList we just created so that it can be processed into a file
        return wordsByColumns;
    }

    public String OneToSevenArrayListToFile() throws IOException {
        //convert the final Arraylist containing the matched strings to a string
        String string = String.join("", oneToSevenToArrayList());
        //write to a file the results
        Files.write(Paths.get("src/com/company/resources/OneToSevenSolution"), Collections.singleton(string), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        return string;
    }


}
