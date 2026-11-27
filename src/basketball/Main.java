package basketball;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Basketball League Manager");

        Team bucks = new Team("Milwaukee Bucks");
        Player p1 = new Player("Ayooluwa Olaoluwa Owolabi", LocalDate.of(2002, 11, 13), Position.POINT_GUARD, 13);
        Player p2 = new Player("Samuel Otowo", LocalDate.of(2000, 3, 9), Position.SHOOTING_GUARD, 3);
        Player p3 = new Player("Samuel Olutekunbi", LocalDate.of(1999, 7, 21), Position.SMALL_FORWARD, 4);
        Player p4 = new Player("Gregory Osubor", LocalDate.of(2001, 1, 30), Position.CENTER, 5);

        try {
            bucks.addPlayers(p1, p2, p3, p4); // Varargs: four players in one call
            System.out.println("4 players joined " + bucks.getName());
        } catch (RosterFullException e) {
            System.out.println("Could not add player: " + e.getMessage());
        }

        // Test a duplicate jersey number
        try {
            Player dup = new Player("Duplicate Test", LocalDate.of(2001, 6, 1), Position.POINT_GUARD, 13);
            bucks.addPlayer(dup);
        } catch (DuplicateJerseyException e) {
            System.out.println("Could not add player: " + e.getMessage());
        } catch (RosterFullException e) {
            System.out.println("Could not add player: " + e.getMessage());
        }

        // Fill the roster past 15 to test the exception
        try {
            for (int i = 5; i <= 16; i++) {
                var player = new Player("Player " + i, LocalDate.of(2000, 1, 1),
                        Position.values()[i % Position.values().length], i + 50); // LVTI
                bucks.addPlayer(player);
                System.out.println(player.getName() + " joined " + bucks.getName());
            }
        } catch (RosterFullException e) {
            System.out.println("Could not add player: " + e.getMessage());
        }

        System.out.println();
        System.out.println(bucks.getRosterText());

        // Polymorphism: one list, two kinds of TeamMember
        Coach coach = new Coach("Tunde Adeyemi", LocalDate.of(1975, 4, 2), 18);
        List<TeamMember> people = List.of(p1, coach);
        System.out.println(Describable.header("Team cards")); // Static interface method
        for (TeamMember m : people) {
            m.printCard(); // Polymorphism
        }

        // Record
        GameResult game = new GameResult("Milwaukee Bucks", "Chicago Bulls", 112, 104, LocalDate.of(2026, 11, 27));
        System.out.println();
        System.out.println(game); // Record: toString() written by Java
        System.out.println("Winner: " + game.winner());

        // Custom immutable type and defensive copying
        List<GameResult> games = new ArrayList<>();
        games.add(game);
        Season season = new Season("2026-27", games);
        games.add(new GameResult("Boston Celtics", "Milwaukee Bucks", 99, 101, LocalDate.of(2026, 11, 22)));
        System.out.println("Games in original list: " + games.size());
        System.out.println("Games in season " + season.getName() + ": " + season.getResults().size()); // Defensive copying

        // Lambdas, effectively final and method references
        int minJersey = 20; // Effectively final: never changed after this line
        List<Player> guards = bucks.filterPlayers(p -> p.getPosition() == Position.POINT_GUARD
                || p.getPosition() == Position.SHOOTING_GUARD); // Lambda (Predicate)
        List<Player> highNumbers = bucks.filterPlayers(p -> p.getJerseyNumber() > minJersey); // Effectively final
        System.out.println();
        System.out.println("Guards:");
        guards.stream().map(Player::getName).forEach(System.out::println); // Method references
        System.out.println("Players with a jersey above " + minJersey + ": " + highNumbers.size());

        // Switch and pattern matching
        System.out.println();
        for (TeamMember m : people) {
            System.out.println(role(m));
        }
    }

    static String role(TeamMember m) { // Pattern matching
        return switch (m) {
            case Player p -> p.getName() + " is a " + positionGroup(p.getPosition());
            case Coach c -> c.getName() + " is the coach";
        };
    }

    static String positionGroup(Position pos) { // Switch expression
        return switch (pos) {
            case POINT_GUARD, SHOOTING_GUARD -> "guard";
            case SMALL_FORWARD, POWER_FORWARD -> "forward";
            case CENTER -> "centre";
        };
    }
}