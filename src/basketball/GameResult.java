package basketball;

import java.time.LocalDate;

public record GameResult(String homeTeam, String awayTeam, int homeScore, int awayScore, LocalDate date) { // Record
    public String winner() {
        return homeScore > awayScore ? homeTeam : awayTeam;
    }
}
