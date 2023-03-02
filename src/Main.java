import classes.WordSorter;

public class Main {
    public static void main(String[] args) {
        String path = "src/input.txt";
        WordSorter ws = new WordSorter();
        ws.FileToCsvConverter(path);



    }
}