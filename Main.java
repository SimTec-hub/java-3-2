package geekbrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	String[] words = {
        "Тверь",
        "Ржев",
        "Торопец",
        "Торжок",
        "Кимры",
        "Конаково",
         "Удомля",
         "Бежецк",
         "Ржев",
         "Осташков",
         "Ржев",
         "Калязин",
         "Торопец",
         "Удомля",
         "Озёрный",
         "Кувшиново",
         "Кимры",
         "Старица",
         "Максатиха",
         "Калязин"};
        ArrayList<String> unique_words = new ArrayList<>();
        HashMap<String, Integer> counter = new HashMap<>();
        int x = 0;
	for (int i = 0; i < words.length; i++) {
	    if (!unique_words.contains(words[i])){
	        unique_words.add(words[i]);
	        counter.put(words[i], 1);
	    }
	    else
        {
            x = counter.get(words[i]);
            x = x +1;
            counter.replace(words[i], x);
        }
    }
    Iterator iterator = unique_words.iterator();
	while (iterator.hasNext()) {
	    System.out.println(iterator.next());
        }
	//System.out.println(counter);
        for (HashMap.Entry<String, Integer> pair : counter.entrySet())
        {
            String key = pair.getKey();
            int value = pair.getValue();
            System.out.println("Количество слов " + key + " = " + value);
        }

        Phone_direct book = new Phone_direct();
        book.add("Петров", "8-555-777-23");
        book.add("Маслов", "8-555-798-56");
        book.add("Петров", "8-555-777-23");
        book.add("Жуков", "8-555-688-20");
        book.add("Петров", "8-555-000-23");

        System.out.println("Номер телефона Петрова: " + book.get("Петров"));
        System.out.println("Номер телефона Жукова: " + book.get("Жуков"));
    }


}
