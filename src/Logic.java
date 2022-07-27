import java.util.*;

public class Logic {

    static Map<String,Integer> mapOfUrls;


    static {
        mapOfUrls= new TreeMap<>();
    }

    public static Map<String, Integer> findRecurringStrings(List<String> listOfUrls, List<String> listOfDomainsOfFirstLevel,
                                                            Map<String, Integer> mapOfUrls){
        for (int i = 0; i<listOfUrls.size(); i++){
            for(int d = 0; d<listOfDomainsOfFirstLevel.size(); d++)
                if (isFound(listOfUrls.get(i), listOfDomainsOfFirstLevel.get(d))) {
                    String domain = cutAString(listOfUrls.get(i), listOfDomainsOfFirstLevel.get(d));
                    addElementsToMap(domain);
                }
        } return mapOfUrls;
    }

    /*
Method checks if String stringInUrlList contains String check and returns true if it does.
*/
    public static boolean isFound(String stringInUrlList, String stringInDomainList){
        String check = "." + stringInDomainList + "/";
        if (stringInUrlList.contains(check)){
            return true;
        }
        return false;
    }
    /*
Method splits the string including regex.
 */
    public static String cutAString(String stringInUrlList, String stringInDomainList){
        stringInDomainList.toLowerCase();
        String check = "((?<=."+ stringInDomainList + "/))";
        String[] domain = stringInUrlList.split(check);
        return domain[0];
    }

    /*
Method checks if the Map contains a specific key and returns true if it does.
*/
    public static boolean checkKey(String domain, Map<String, Integer> mapOfUrls){
        if (mapOfUrls.containsKey(domain)){
            return true;
        } return false;
    }

    /*
Method increases the value of a variable by 1 if the map has a specific key,
otherwise put a new key to the map and assigns int 1 to its value.
*/
    public static void addElementsToMap(String key){
        if (checkKey(key, mapOfUrls)){
            int counter = mapOfUrls.get(key);
            counter ++;
            mapOfUrls.replace(key,counter);
        }
        else {
            mapOfUrls.put(key,1);
        }
    }

    public static void printAMap(Map<String,Integer> mapOfUrls){
        for (String key : mapOfUrls.keySet()){
            String value = mapOfUrls.get(key).toString();
            System.out.println(value + " : " + key);
        }
    }

    public static <K,V extends Comparable<V> > Map<K,V> sortValue(final Map<String,Integer> mapOfUrls){
        Comparator<K> valueComparator = new Comparator<K>() {
            @Override
            public int compare(K key1, K key2) {
                int comp = mapOfUrls.get(key2).compareTo(
                        mapOfUrls.get(key1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
//Creating a new Treemap
        Map sorted = new TreeMap(valueComparator);
        sorted.putAll(mapOfUrls);
        return sorted;
    }

    public static void printSortedMap(int numberOfElements){
        Map sortedMap = sortValue(mapOfUrls);
        Set set = sortedMap.entrySet();
        int n = 0;
        Iterator i = set.iterator();
        while (n < numberOfElements && i.hasNext()){
            Map.Entry mp = (Map.Entry)i.next();
            System.out.print(mp.getValue() + ": ");
            System.out.println(mp.getKey());
            n++;
        }
    }
}
