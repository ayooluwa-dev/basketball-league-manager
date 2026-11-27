package basketball;

import java.util.List;

public final class Season { // Custom immutable type
    private final String name;
    private final List<GameResult> results;

    public Season(String name, List<GameResult> results) {
        this.name = name;
        this.results = List.copyOf(results); // Defensive copying
    }

    public String getName() {
        return name;
    }

    public List<GameResult> getResults() {
        return results; // Unmodifiable copy, so callers can't change it
    }
}