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



    public static List<Game> sortGamesChronologically(List<Game> games) {
        return games.stream()
                .sorted(Comparator.comparing(Game::getDate))
                .collect(Collectors.toList());
    }
}


