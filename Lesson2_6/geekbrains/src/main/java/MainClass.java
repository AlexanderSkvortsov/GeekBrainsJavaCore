public class MainClass {

    public static void main(String[] args) {
        int[] newArray = ArrayPart.getNewArray(new int[] {1,2,3,4,5,6,7});
        for (int i=0;i<newArray.length;i++) {
            System.out.print(newArray[i]+" ");
        }


        System.out.println(ArrayPart2.checkNewArray(new int[] {1,2,3,4,5,6,7}));

    }

}
