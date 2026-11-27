// Java 27 preview feature: primitive types in patterns, instanceof and switch (JEP 532)
public class PrimitivePatterns {

    static String rateScore(int points) {
        return switch (points) { // Primitive type patterns in switch
            case 0 -> "no points";
            case int p when p >= 30 -> p + " points: a big game";
            case int p when p >= 10 -> p + " points: double figures";
            case int p -> p + " points";
        };
    }

    public static void main(String[] args) {
        System.out.println("Java 27 preview: primitive types in patterns");
        System.out.println(rateScore(0));
        System.out.println(rateScore(34));
        System.out.println(rateScore(12));
        System.out.println(rateScore(4));

        double average = 23.0;
        if (average instanceof int whole) { // Primitive type in instanceof
            System.out.println("Average " + average + " is a whole number: " + whole);
        }

        double average2 = 23.5;
        if (!(average2 instanceof int)) {
            System.out.println("Average " + average2 + " is not a whole number");
        }
    }
}