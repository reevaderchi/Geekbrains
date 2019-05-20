public class Main {

    @BeforeSuite
    public static void start() {
        System.out.println("Hello!");
    }

    @Test
    public static  void method1() {
        System.out.println("It'method 1");
    }
    @Test(priority = 10)
    public static  void method2() {
        System.out.println("It's method 2");
    }
    @Test(priority = 1)
    public static  void method3() {
        System.out.println("It's method 3");
    }

    @AfterSuite
    public static void shutdown() {
        System.out.println("Good Bye!");
    }

}
