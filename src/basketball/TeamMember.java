package basketball;

import java.time.LocalDate;
import java.time.Period;

public abstract class TeamMember { // Class
    private String name;           // Encapsulation
    private LocalDate dateOfBirth; // Date API

    public TeamMember(String name, LocalDate dateOfBirth) {
        this.name = name; // this.
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() { // Date API
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}