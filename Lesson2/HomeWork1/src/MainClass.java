import myException.MyArrayDataException;
import myException.MyArraySizeException;

public class MainClass {

    private static  final int MAX_ARRAY_SIZE =4;

    private  static int checkArray (char [][] myArray) throws MyArraySizeException, MyArrayDataException {


        if (myArray.length > MAX_ARRAY_SIZE) {
            throw new MyArraySizeException("Недопустимый размер массива.");
        }

        for(int i=0;i<myArray.length;i++){

            if (myArray[i].length>MAX_ARRAY_SIZE){
                throw new MyArraySizeException("Недопустимый размер массива.");
            }
        }

        int totalAmount =0;

        for(int i = 0;i<myArray.length; i++){
            for(int j = 0;j<myArray[i].length; j++){

                try{
                    totalAmount+= Integer.parseInt(String.valueOf(myArray[i][j]));
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException("Недопустимые данные в строке ",(i+1),(j+1));
                }
            }
        }

        return totalAmount;
    }

    private static void printTotal(char [][] myArray) {

        int total =0;

        try {
            total = checkArray(myArray);

        } catch (MyArrayDataException e)
        {
            System.out.println("Исключение: " + e.getMessage()+ " строка "+e.getRow()+" столбец "+e.getCol());
        }
         catch (MyArraySizeException e) {
            System.out.println("Исключение: " + e.getMessage()+ " Максиманый размер "+ MAX_ARRAY_SIZE+"x"+MAX_ARRAY_SIZE);
        }
        finally {
            System.out.println("Сумма равна: " +total);
        }

    }


    public static void main(String[] args) {

        char [][] array1 = {
                {'1','2','3','4'},
                {'1','2','3','4'},
                {'1','2','3','4'},
                {'1','2','3','4'},
        };

        char [][] array2 = {
                {'1','2','3','4'},
                {'1','2','3','4'},
                {'1','C','3','4'},
                {'1','2','3','4'},
        };

        char [][] array3 = {
                {'1','2','3','4'},
                {'1','2','3','4'},
                {'1','2','3','4'},
                {'1','2','3','4'},
                {'1','2','3','4'},
        };

        char [][] array4 = {
                {'1','2','3','4','5'},
                {'1','2','3','4','6'},
                {'1','2','3','4','7'},
                {'1','2','3','4','8'},
        };

        printTotal(array1);
        printTotal(array2);
        printTotal(array3);
        printTotal(array4);


    }
}
