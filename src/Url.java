import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Url {
    static List<String> listOfUrls;
    static FileReader fileReader;


    static {
        listOfUrls = new ArrayList<>();
        try {
            fileReader = new FileReader("/Users/lucie/IdeaProjects/Lesson7_Homework_Hillel/urls.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner urlsScanner = new Scanner(fileReader);

    public static void addUrlsToList() {
        while (Url.urlsScanner.hasNextLine()) {
            String urls = Url.urlsScanner.nextLine();
            Url.listOfUrls.add(urls.toLowerCase());
        }
    }
}
