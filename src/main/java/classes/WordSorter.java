package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
public class WordSorter {

    private static final Logger LOG = Logger.getLogger(WordSorter.class);
     public void FileToCsvConverter(String inputPath){
         BasicConfigurator.configure();
         LOG.info("Start Application...");
        List<String> words = new ArrayList<>();
        try{
            LOG.info("Fetch words from input file...");
            File inputFile = new File(inputPath);
            Scanner fileReader = new Scanner(inputFile);
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                words.add(data);
            }

            fileReader.close();
            LOG.info("Sort words...");
            Collections.sort(words);
            LOG.info("List sorted words in CSV format...");
            LOG.info("ID,Word");
            int id = 1;
            for(Object element : words){
                final String separator = ",";
                String lineWithId = id++ + separator + element;
                LOG.info(lineWithId);
            }
        } catch (FileNotFoundException e){
            LOG.error("Input file is missing!");
            e.printStackTrace();
        }
         LOG.info("Close Application...");
    }
}
