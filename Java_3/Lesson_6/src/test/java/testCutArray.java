import org.junit.*;

public class testCutArray {

    TestClass testClass;

    @Before
    public void init() {
        System.out.println("init");
        testClass = new TestClass();
    }

    @Test
    public void testCutArray1() {
        int[] inputArray = {0, 1, 2, 3, 5, 6};
        int[] outputArray = {};
        try {
            Assert.assertArrayEquals(outputArray, testClass.cutArray(inputArray));
        } catch (MyArrayException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testCutArray2() {
        int[] inputArray = {0, 1, 4, 3, 5, 6};
        int[] outputArray = {3, 5, 6};
        try {
            Assert.assertArrayEquals(outputArray, testClass.cutArray(inputArray));
        } catch (MyArrayException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testCutArray3() {
        int[] inputArray = {4, 1, 4, 4, 5, 6};
        int[] outputArray = {5, 6};
        try {
            Assert.assertArrayEquals(outputArray, testClass.cutArray(inputArray));
        } catch (MyArrayException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @After
    public void shutdown() {
        System.out.println("end");
    }
}

