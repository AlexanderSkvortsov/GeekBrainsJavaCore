package phonebook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook{
    private static HashMap<String, ArrayList<Integer>> pb = new HashMap<>();


    public void add( String name,Integer phoneNumber) {
        ArrayList<Integer> element = pb.get(name);
        if (element == null) element = new ArrayList<>();

        element.add(phoneNumber);
        pb.put(name, element);
    }

    public ArrayList<Integer> get(String phoneName) {

        return pb.get(phoneName);

    }

}
