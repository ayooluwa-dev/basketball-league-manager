package basketball;
import java.time.LocalDate;

public class Player extends TeamMember { // Inheritance
    private Position position;
    private int jerseyNumber;
    public Player(String name, LocalDate dateOfBirth, Position position, int jerseyNumber) {
        super(name, dateOfBirth); // super()
            this.position = position;
            this.jerseyNumber = jerseyNumber;
    }

        public Position getPosition() {
        return position;
        }
        public int getjerseyNumber () {
        return jerseyNumber;
        }
    }
}
