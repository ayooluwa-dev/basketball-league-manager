package basketball;

import java.time.LocalDate;

public abstract class TeamMember { // Class
    private String name;           // Encapsulation: private fields
    private LocalDate dateOfBirth; // Date API

    public TeamMember(String name, LocalDate dateOfBirth) {
        this.name = name; // this.
        this.dateOfBirth = dateOfBirth;
    }
}