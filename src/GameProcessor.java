import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class GameProcessor {


    public static List<Game> sortGamesChronologically(List<Game> games) {
        return games.stream()
                .sorted(Comparator.comparing(Game::getDate))
                .collect(Collectors.toList());
    }
}


