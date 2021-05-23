package geekbrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Box<B extends Fruit> {

    private ArrayList<B> fruitlist;

    public Box() {
        this.fruitlist = new ArrayList<>();
    }

    public Box(B... fruits) {
        this.fruitlist = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float weight = 0.0f;

        for (B f : fruitlist) {
            weight += f.getWeight();
        }

        return weight;
    }

    public void layout(Box<B> another) {
        another.fruitlist.addAll(fruitlist);
        fruitlist.clear();
    }

    public void add(B fruit) {
        fruitlist.add(fruit);
    }

    public void add(Collection<B> fruit) {
        fruitlist.addAll(fruit);
    }
    public boolean compare(Box<?> f) {

        return Math.abs(this.getWeight() - f.getWeight()) < 0;
    }
}


