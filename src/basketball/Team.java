package basketball;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players = new ArrayList<>(); // ArrayList
    private static final int MAX_PLAYERS = 15;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) throws RosterFullException { // Checked exception
        if (players.size() >= MAX_PLAYERS) {
            throw new RosterFullException(name + " already has " + MAX_PLAYERS + " players");
        }
        players.add(player);
    }
}
