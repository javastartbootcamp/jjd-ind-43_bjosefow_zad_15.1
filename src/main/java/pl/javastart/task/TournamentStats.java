package pl.javastart.task;

import java.io.*;
import java.util.*;

public class TournamentStats {
    private static final int SORT_BY_FIRSTNAME = 1;
    private static final int SORT_BY_LASTNAME = 2;
    private static final int SORT_BY_RESULT = 3;
    private static final int SORT_ASC = 1;
    private static final int SORT_DESC = 2;

    private static List<Participant> list = new ArrayList<>();

    void run(Scanner scanner) {
        boolean stop = false;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub STOP)");
            String userInput = scanner.nextLine();
            if (userInput.toUpperCase().equals("STOP")) {
                stop = true;
            } else {
                addParticipantToList(userInput);
            }
        } while (!stop);

        Comparator<Participant> comparator = getParticipantComparator(scanner);
        Collections.sort(list, comparator);
        saveStatisticToFile();
    }

    private Comparator<Participant> getParticipantComparator(Scanner scanner) {
        System.out.println("Po jakim parametrze posortować?");
        System.out.print("(" + SORT_BY_FIRSTNAME + " - imię, ");
        System.out.print("(" + SORT_BY_LASTNAME + " - nazwisko, ");
        System.out.print("(" + SORT_BY_RESULT + " - wynik)");
        int choice = scanner.nextInt();
        System.out.println("Sortować rosnąco czy malejąco?");
        System.out.print("(" + SORT_ASC + " - rosnąco, ");
        System.out.print("(" + SORT_DESC + " - malejąco)");
        int direction = scanner.nextInt();
        if (direction == SORT_DESC) {
            direction = -1;
        }

        Comparator<Participant> comparator = null;
        switch (choice) {
            case SORT_BY_FIRSTNAME -> comparator = new FirstnameComparator(direction);
            case SORT_BY_LASTNAME -> comparator = new LastnameComparator(direction);
            case SORT_BY_RESULT -> comparator = new ResultComparator(direction);
            default -> System.out.println("Brak takiej opcji");
        }
        return comparator;
    }

    private void addParticipantToList(String userInput) {
        String[] dataTab = userInput.split(" ");
        list.add(new Participant(dataTab[0], dataTab[1], Integer.parseInt(dataTab[2])));
    }

    public void saveStatisticToFile() {
        try (
                var writer = new BufferedWriter(new FileWriter("stats.csv"));
                ) {
            for (Participant participant : list) {
                writer.write(participant.getFirstname() + " " + participant.getLastname() + ";" + participant.getResult());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Blad zapisu do pliku");
        }
    }
}
