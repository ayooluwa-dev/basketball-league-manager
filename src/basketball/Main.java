package basketball;

import java.time.LocalDate;
import java.util.List;

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
    }

}