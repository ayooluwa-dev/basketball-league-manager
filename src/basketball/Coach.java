package basketball;

import java.time.LocalDate;

public class Coach extends TeamMember { // Inheritance
    private int yearsOfExperience;

    public Coach(String name, LocalDate dateOfBirth, int yearsOfExperience) {
        super(name, dateOfBirth); // super()
        this.yearsOfExperience = yearsOfExperience;
    }

    public Coach(String name, LocalDate dateOfBirth) { // Overloading
        this(name, dateOfBirth, 0); // this()
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String describe() { // Overriding
        return super.describe() + ", coach with " + yearsOfExperience + " years' experience"; // super.
    }
}