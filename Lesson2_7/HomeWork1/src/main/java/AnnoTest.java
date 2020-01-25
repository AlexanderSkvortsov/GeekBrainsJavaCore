import java.util.concurrent.Semaphore;

public class AnnoTest {

    private Semaphore sync = new Semaphore(1);

    @BeforeSuite(description = "BeforeSuite")
    public  void testBefore(){
        try {
            sync.acquire();
            System.out.println("TestBefore");
            sync.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite(description = "AfterSuite")
    public  void testAfter(){
        try {
            sync.acquire();
            System.out.println("TestAfter");
            sync.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Test 1", priorityLevel = 5)
    public  void test1(){
        try {
            sync.acquire();
            System.out.println("test1");
            sync.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Test 2", priorityLevel = 5)
    public  void test2(){
        try {
            sync.acquire();
            System.out.println("test2");
            sync.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Test 3", priorityLevel = 7)
    public  void test3(){
        try {
            sync.acquire();
            System.out.println("test3");
            sync.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Test 4", priorityLevel = 1)
    public  void test4(){
        try {
            sync.acquire();
            System.out.println("test4");
            sync.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
