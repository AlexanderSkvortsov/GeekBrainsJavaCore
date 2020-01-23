public class ArrayPart2 {

    public static boolean checkNewArray(int[] arrayOfInt) {

        int foundAll = 0;
        for (int i=0;i<arrayOfInt.length && foundAll<3 ;i++){
            foundAll |= (arrayOfInt[i] == 4)?1:0;
            foundAll |= (arrayOfInt[i] == 1)?2:0;
        }

        return (foundAll > 2);
    }

}

