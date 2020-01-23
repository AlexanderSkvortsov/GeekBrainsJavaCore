import org.junit.Assert;
import org.junit.Test;

public class TestArray2 {
    @Test
    public void Test1(){
        Assert.assertTrue(ArrayPart2.checkNewArray(new int[] {1,2,3,4,5,6,7}));
    }

    @Test
    public void Test2(){
        Assert.assertFalse(ArrayPart2.checkNewArray(new int[] {0,2,3,4,5,6,7}));
    }

    @Test
    public void Test3(){
        Assert.assertTrue(ArrayPart2.checkNewArray(new int[] {1,1,1,1,1,1,4}));
    }

    @Test
    public void Test4(){
        Assert.assertFalse(ArrayPart2.checkNewArray(new int[] {1}));
    }

}
