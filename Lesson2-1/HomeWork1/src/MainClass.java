import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {



    //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    private static void xchange(Object[] arr, int position_1, int position_2) throws IndexOutOfBoundsException{
        if ((position_1<arr.length) && (position_2<arr.length)){

            Object temp = arr[position_1];
            arr[position_1] = arr[position_2];
            arr[position_2] = temp;

        } else  throw new IndexOutOfBoundsException("Неверный индекс!");
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    private static <T> ArrayList<T> arrayToList(T[] array){
        return new ArrayList<> (Arrays.asList(array));
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        System.out.println(Arrays.toString(intArray));
        xchange(intArray, 2,3);
        System.out.println(Arrays.toString(intArray));

        intArray[6]=10;

        Object Obj = new Integer(10);
        String S = (String) Obj;

        System.out.println(S);


        Float[] floatArray = {1f,2f,3f,4f,5f};
        ArrayList fArray = arrayToList(floatArray);
        System.out.println(Arrays.toString(fArray.toArray()));

        Apple appl = new Apple();
        Orange org = new Orange();

        Box<Orange> orangeBox1 = new Box<>(org,org);
        Box<Orange> orangeBox2 = new Box<>(org,org,org,org);
        Box<Apple> appleBox3 = new Box<>(appl,appl,appl);
        Box<Apple> appleBox4 = new Box<>(appl,appl,appl);

        System.out.println("Вес коробок 1 и 3 равен " + appleBox3.compareTo(orangeBox1));

        System.out.println("Вес коробок 2 и 3 равен " + appleBox3.compareTo(orangeBox2));

        appleBox4.anotherBoxTo(appleBox3);
        System.out.println("Вес коробок 2 и 3 равен " + appleBox3.compareTo(orangeBox2));

    }
}
