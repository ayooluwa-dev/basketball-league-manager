package basketball;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players = new ArrayList<>(); // ArrayList

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}