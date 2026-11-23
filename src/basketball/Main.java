package basketball;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Basketball League Manager");

        Team bucks = new Team("Milwaukee Bucks");
        Player p1 = new Player("Ayooluwa Olaoluwa Owolabi", LocalDate.of(2002, 11, 13), Position.POINT_GUARD, 13);

        try {
            bucks.addPlayer(p1);
            System.out.println(p1.getName() + " joined " + bucks.getName());
        } catch (RosterFullException e) {
            System.out.println("Could not add player: " + e.getMessage());
        }
        // Fill the roster past 15 to test the exception
        try {
            for (int i = 2; i <= 16; i++) {
                var player = new Player("Player " + i, LocalDate.of(2000, 1, 1), Position.CENTER, i); // LVTI
                bucks.addPlayers(player); // Varargs
                System.out.println(player.getName() + " joined " + bucks.getName());
            }
        } catch (RosterFullException e) {
            System.out.println("Could not add player: " + e.getMessage());
        }
    }
}