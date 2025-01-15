import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class GameProcessor {

    public static List<Game> filterGamesByCapacity(List<Game> games, int minCapacity) {
        return games.stream()
                .filter(game -> game.getCapacity() >= minCapacity)
                .collect(Collectors.toList());
    }

    public static List<Game> filterGamesByCityAndDate(List<Game> games, String city, String minDate) {
        return games.stream()
                .filter(game -> game.getCity().equalsIgnoreCase(city) && game.getDate().compareTo(minDate) > 0)
                .sorted(Comparator.comparing(Game::getDate))
                .collect(Collectors.toList());
    }


    public static void countGamesPerCity(List<Game> games, String outputFilePath) {
        Map<String, Long> cityCounts = games.stream()
                .collect(Collectors.groupingBy(Game::getCity, Collectors.counting()));

        List<Map.Entry<String, Long>> sortedCities = cityCounts.entrySet().stream()
                .sorted((e1, e2) -> {
                    int countComparison = e2.getValue().compareTo(e1.getValue());
                    if (countComparison == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return countComparison;
                })
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Long> entry : sortedCities) {
                writer.write(entry.getKey() + "&" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Game counts per city saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<Game> sortGamesChronologically(List<Game> games) {
        return games.stream()
                .sorted(Comparator.comparing(Game::getDate))
                .collect(Collectors.toList());
    }
}


