import java.util.Arrays;

public class MainClass {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    static  int threadsNum = 100;
    static  int newArraySize = size/threadsNum;
    static float[][] newAarrays = new float[threadsNum][newArraySize ];

    private static void methodOne() {
            for (int i = 0 ;i<size;i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    private static void methodTwo(int newArrayIndex ) {

        int indexOffset = newArrayIndex*newArraySize;
        for (int i = 0 ;i<newArraySize;i++) {
            newAarrays[newArrayIndex][i] = (float) (newAarrays[newArrayIndex][i] * Math.sin(0.2f + indexOffset / 5) * Math.cos(0.2f + indexOffset / 5) * Math.cos(0.4f + indexOffset / 2));
            indexOffset++;
        }
    }

    private static void separateArray(){
        for (int i = 0;i< threadsNum ;i++){
            System.arraycopy(arr,i*newArraySize,newAarrays[i],0,newArraySize);
        }
    }

    private static void combineArray(){
        for (int i = 0;i< threadsNum ;i++){
            System.arraycopy(newAarrays[i],0,arr,i*newArraySize,newArraySize);
        }
    }

    public static void main(String[] args) {

        System.out.println("Starting test...");

        Arrays.fill(arr,1.00f);

        long a = System.currentTimeMillis();

        Thread t1 = new Thread(MainClass::methodOne);
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Method 1: Execution time was "+(System.currentTimeMillis()-a)+" milliseconds");

        Arrays.fill(arr,1.00f);
        a = System.currentTimeMillis();

        separateArray();

        Thread [] t2 = new Thread[threadsNum];

        for (int i = 0;i<threadsNum;i++) {
            final int arrayId = i;
            t2[i]= new Thread(()-> methodTwo(arrayId));
            t2[i].start();
        }

        for (int i = 0;i<threadsNum;i++) {
            try {
                t2[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        combineArray();

        System.out.println("Method 2: Execution time was "+(System.currentTimeMillis()-a)+" milliseconds");

    }
}
