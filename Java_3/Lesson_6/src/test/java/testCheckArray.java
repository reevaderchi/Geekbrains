import org.junit.*;

public class testCheckArray {

    TestClass testClass;

    @Before
    public void init() {
        System.out.println("init");
        testClass = new TestClass();
    }

    @Test
    public void testCheckArray1() {
        int[] inputArray = {0, 1, 2, 3, 5, 6};
        Assert.assertTrue(testClass.checkArray(inputArray));
    }

    @Test
    public void testCheckArray2() {
        int[] inputArray = {0, 0, 2, 3, 5, 6};
        Assert.assertFalse(testClass.checkArray(inputArray));
    }


    @Test
    public void testCheckArray3() {
        int[] inputArray = {1};
        Assert.assertTrue(testClass.checkArray(inputArray));
    }


    @After
    public void shutdown() {
        System.out.println("end");
    }
}