package basketball;

import java.time.LocalDate;
import java.time.Period;

public abstract sealed class TeamMember implements Describable permits Player, Coach { // Sealed class
    private String name; // Encapsulation
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

    @Override
    public String describe() {
        return getName() + ", age " + getAge();
    }
}