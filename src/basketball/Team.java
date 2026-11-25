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
        for (Player p : players) {
            if (p.getJerseyNumber() == player.getJerseyNumber()) {
                throw new DuplicateJerseyException( // Unchecked exception
                        "Jersey #" + player.getJerseyNumber() + " is already worn by " + p.getName());
            }
        }
        players.add(player);
    }

    public void addPlayers(Player... newPlayers) throws RosterFullException { // Varargs
        for (Player player : newPlayers) {
            addPlayer(player);
        }
    }

    public String getRosterText() { // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" roster:\n");
        for (Player p : players) {
            sb.append(" #").append(p.getJerseyNumber())
                    .append(" ").append(p.getName())
                    .append(" (").append(p.getPosition()).append(")\n");
        }
        return sb.toString();
    }
}
