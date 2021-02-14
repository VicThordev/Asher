public class StaticTest {
    private static int x;
    private int y;

    public StaticTest(int val) {
         x = val;
         y = val;
    }

    public void printOut() {
        System.out.println(x +" and "+y);
    }

    public static int getX(){
        return x;
    }
     public static void main(String[] args) {
        StaticTest load = new StaticTest(2);
        load.printOut();
        StaticTest load2 = new StaticTest(4);
        load2.printOut();
        load.printOut();
    }
}
