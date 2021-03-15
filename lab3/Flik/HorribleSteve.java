public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                System.out.println("Now i is " + i + " and j is " + j + " isSameNumber() gives: " + Flik.isSameNumber(i, j));
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
