package geekbrain;

import java.util.ArrayList;
import java.util.HashMap;

public class Phone_direct{
    private HashMap<String, ArrayList<String>> phone_direct = new HashMap<>();


     public void add(String surname, String number) {
        ArrayList<String> numbers;
        if (phone_direct.containsKey(surname)) {
            numbers = phone_direct.get(surname);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(number);
        phone_direct.put(surname, numbers);
    }

    ArrayList<String> get(String surname) {
        return phone_direct.get(surname);
    }

    }