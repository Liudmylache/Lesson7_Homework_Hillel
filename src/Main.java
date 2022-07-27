public class Main {
    public static void main(String[] args) {
        Url.addUrlsToList();

        Domain.addDomainsToList();

        Logic.findRecurringStrings(Url.listOfUrls,Domain.listOfDomainsOfFirstLevel,Logic.mapOfUrls);
        Logic.printSortedMap(10);
        }
    }
