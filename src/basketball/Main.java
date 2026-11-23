package basketball;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Basketball League Manager");

        Team bucks = new Team("Bucks");
        Player p1 = new Player("Ayo Owolabi", LocalDate.of(2002, 11, 13), Position.POINT_GUARD, 13);

        bucks.addPlayer(p1);
        System.out.println(p1.getName() + " joined " + bucks.getName());
    }
}