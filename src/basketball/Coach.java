package basketball;

import java.time.LocalDate;

public class Coach extends TeamMember { // Inheritance
    private int yearsOfExperience;

    public Coach(String name, LocalDate dateOfBirth, int yearsOfExperience) {
        super(name, dateOfBirth); // super()
        this.yearsOfExperience = yearsOfExperience;
    }
}