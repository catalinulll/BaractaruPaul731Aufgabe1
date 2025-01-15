public class Game {
    private int id;
    private String team1;
    private String team2;
    private String date;
    private String city;
    private int capacity;

    public Game(int id, String team1, String team2, String date, String city, int capacity) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.city = city;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return date + ": " + team1 + " vs " + team2 + " - Spielort: " + city + " (Kapazität: " + capacity + ")";
    }
}

