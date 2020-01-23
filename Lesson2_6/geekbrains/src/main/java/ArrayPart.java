import java.util.Arrays;

public class  ArrayPart {

    public static int[] getNewArray(int[] arrayOfInt) {
        int pos = -1;
        for (int i=0;i<arrayOfInt.length;i++){
            if (arrayOfInt[i] == 4)
            {
                pos = i;
            }
        }

        if (pos < 0) throw new RuntimeException("Bad array");

        return Arrays.copyOfRange(arrayOfInt, pos+1, arrayOfInt.length);
    }

}
