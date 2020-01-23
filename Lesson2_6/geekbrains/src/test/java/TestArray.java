import org.junit.Assert;
import org.junit.Test;

public class TestArray {
    @Test
    public void Test1(){
        Assert.assertArrayEquals(new int[]{5,6,7}, ArrayPart.getNewArray(new int[] {1,2,3,4,5,6,7}));
    }

    @Test(expected = RuntimeException.class)
    public void Test2(){
        ArrayPart.getNewArray(new int[] {1,2,3,3,5,6,7});
    }

    @Test
    public void Test3(){
        Assert.assertArrayEquals(new int[]{6,7}, ArrayPart.getNewArray(new int[] {1,2,3,4,4,6,7}));
    }

    @Test
    public void Test4(){
        Assert.assertArrayEquals(new int[]{}, ArrayPart.getNewArray(new int[] {1,2,3,4,4,6,7,4}));
    }

}
