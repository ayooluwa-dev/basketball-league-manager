package basketball;

public interface Describable { // Interface
    String describe();

    default void printCard() { // Default interface method
        System.out.println(border());
        System.out.println(describe());
        System.out.println(border());
    }

    static String header(String title) { // Static interface method
        return "=== " + title + " ===";
    }

    private String border() { // Private interface method
        return "-".repeat(40);
    }
}