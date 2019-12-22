import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit > {

    private ArrayList<T> fruitBox;

    public Box(T... fruits) {
        this.fruitBox = new ArrayList<>(Arrays.asList(fruits));
    }

    public ArrayList<T> getFruitBox() {
        return fruitBox;
    }

    public void setFruitBox(ArrayList<T> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public void addFruit(T fr){
        fruitBox.add(fr);
    }

    public float getWeight(){

        float totalWeight =0.0f;

        for (int i = 0 ;i<fruitBox.size();i++){
            totalWeight+=fruitBox.get(i).getWeigh();
        }
        return totalWeight;
    }


    public boolean compareTo(Box o) {
        return (o.getWeight()-getWeight())<0.01F;
    }

    public void anotherBoxTo(Box<T> o) {
        o.fruitBox.addAll(fruitBox);
        fruitBox.clear();
    }
}
