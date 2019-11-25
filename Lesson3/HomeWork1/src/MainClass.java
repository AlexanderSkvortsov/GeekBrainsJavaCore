import java.util.*;

public class MainClass {
    
    static void printSingle(List<String>  dictionary ){
        Map<String, Integer> res = new HashMap<>();

        Integer element;
        for (String s : dictionary)
        {
            element = res.get(s);
            res.put(s,(element == null)?1:element + 1);
        }


        for (Map.Entry<String, Integer> pair: res.entrySet()) {

            if (pair.getValue() < 2)
                System.out.println(pair.getKey());
        }

    }

    static void printDouble(List<String>  dictionary ){

        Map<String, Integer> res = new HashMap<>();

        Integer element;
        for (String s : dictionary)
        {
                element = res.get(s);
                res.put(s,(element == null)?1:element + 1);
        }

        for (Map.Entry<String, Integer> pair: res.entrySet()) {

            if (pair.getValue()> 1)
            System.out.println(pair.getKey());
        }
    }

    public static void main(String[] args) {

        List <String> dictionary = new ArrayList<>(Arrays.asList(
            "Java",
            "Delphi",
            "Kotlin",
            "C",
            "FoxPro",
            "Fortan",
            "Kotlin",
            "C",
            "Perl",
            "Cobol"
        ));

        System.out.println("Print double...");
        printDouble(dictionary );
        System.out.println("Print single...");
        printSingle(dictionary );

    }
}
