import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Catalin\\Downloads\\BaractaruPaul731Aufgabe1\\src\\spielorte.tsv";
        String outputFilePath = "C:\\Users\\Catalin\\Downloads\\BaractaruPaul731Aufgabe1\\src\\spielanzahl.txt";

        List<Game> games = TSVReader.readGamesFromTSV(filePath);

        //a
        System.out.println("--- All Games ---");
        games.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        //b
        System.out.print("\nEnter minimum capacity: ");
        int minCapacity = scanner.nextInt();
        List<Game> filteredByCapacity = GameProcessor.filterGamesByCapacity(games, minCapacity);
        System.out.println("--- Games with Capacity >= " + minCapacity + " ---");
        filteredByCapacity.forEach(System.out::println);

        //c
        System.out.print("\nEnter city: ");
        scanner.nextLine();
        String city = scanner.nextLine();
        System.out.print("Enter minimum date (YYYY-MM-DD): ");
        String minDate = scanner.nextLine();
        List<Game> filteredByCityAndDate = GameProcessor.filterGamesByCityAndDate(games, city, minDate);
        System.out.println("--- Games in " + city + " after " + minDate + " ---");
        filteredByCityAndDate.forEach(System.out::println);



        scanner.close();
    }
}

