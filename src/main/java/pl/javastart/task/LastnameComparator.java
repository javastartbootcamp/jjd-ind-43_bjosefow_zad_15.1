package pl.javastart.task;

import java.util.Comparator;

public class LastnameComparator implements Comparator<Participant> {

    @Override
    public int compare(Participant part1, Participant part2) {
        if (part1 == null && part2 == null) {
            return 0;
        } else if (part1 != null && part2 == null) {
            return 1;
        } else if (part1 == null && part2 != null) {
            return -1;
        }
        return part1.getLastname().compareTo(part2.getLastname());
    }
}
