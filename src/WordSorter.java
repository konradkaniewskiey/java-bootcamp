import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class WordSorter {
    public static void main(String[] args){

    }

    public static void FileToCsvConverter(String inputPath){
        List<String> words = new ArrayList<>();
        try{
            File inputFile = new File(inputPath);
            Scanner fileReader = new Scanner(inputFile);
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                words.add(data);
            }

            fileReader.close();
            Collections.sort(words);
            System.out.println(words);
            System.out.println("-----ID, Word-----");
            int id = 1;
            for(Object element : words){
                String lineWithId = id + ". " + element;
                System.out.println(lineWithId);
                id++;
            }
        } catch (FileNotFoundException e){
            System.out.println("Input file is missing!");
            e.printStackTrace();
        }
    }
}
