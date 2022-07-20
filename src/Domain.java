import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Domain {
    static List<String> listOfDomainsOfFirstLevel = new ArrayList<>();
    static FileReader fileReader1;

    static {
        listOfDomainsOfFirstLevel = new ArrayList<>();
        try {
            fileReader1 = new FileReader("/Users/lucie/IdeaProjects/Lesson7_Homework_Hillel/domains.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner domainsScanner = new Scanner(fileReader1);

    public static void addDomainsToList() {
        while (Domain.domainsScanner.hasNextLine()) {
            String domain = Domain.domainsScanner.nextLine();
            Domain.listOfDomainsOfFirstLevel.add(domain.toLowerCase());
        }
    }

    public static void printListOfDomains() {
        for (String domain : listOfDomainsOfFirstLevel) {
            System.out.println(domain);
        }
    }
}
