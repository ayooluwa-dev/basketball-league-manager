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
    }
}