package pl.javastart.task;

import java.util.Comparator;

public class ResultComparator implements Comparator<Participant> {

    @Override
    public int compare(Participant part1, Participant part2) {

        if (part1 == null && part2 == null) {
            return 0;
        } else if (part1 != null && part2 == null) {
            return 1;
        } else if (part1 == null && part2 != null) {
            return -1;
        } else if (part1.getResult() > part2.getResult()) {
            return 1;
        } else if (part1.getResult() < part2.getResult()) {
            return -1;
        }
        return 0;
    }
}
