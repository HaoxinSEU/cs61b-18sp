public class TestPlanet{
    public static void main(String[] args) {
        Planet p1 = new Planet(1e12, 2e11, 0, 0, 2e30, "Sun");
        Planet p2 = new Planet(2.3e12, 9.5e11, 0, 0, 6e26, "Saturn");
        System.out.println(p1.calcDistance(p2));
        System.out.println(p1.calcForceExertedBy(p2));
        System.out.println(p2.calcForceExertedByX(p1));
        System.out.println(p2.calcForceExertedByY(p1));

    }
}