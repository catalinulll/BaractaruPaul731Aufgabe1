import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TSVReader {
    public static List<Game> readGamesFromTSV(String filePath) {
        List<Game> games = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                int id = Integer.parseInt(fields[0]);
                String team1 = fields[1];
                String team2 = fields[2];
                String date = fields[3];
                String city = fields[4];
                int capacity = Integer.parseInt(fields[5]);

                Game game = new Game(id, team1, team2, date, city, capacity);
                games.add(game);
            }
        } catch (IOException e) {
            System.err.println("Error reading TSV file: " + e.getMessage());
        }

        return games;
    }
}
