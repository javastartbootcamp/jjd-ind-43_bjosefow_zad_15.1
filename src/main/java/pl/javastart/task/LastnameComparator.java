package pl.javastart.task;

import java.util.Comparator;

public class LastnameComparator implements Comparator<Participant> {

    private int direction;

    public LastnameComparator(int direction) {
        this.direction = direction;
    }

    @Override
    public int compare(Participant part1, Participant part2) {
        int result;
        if (part1 == null && part2 == null) {
            result = 0;
        } else if (part1 != null && part2 == null) {
            result = 1;
        } else if (part1 == null && part2 != null) {
            result = -1;
        } else {
            result = part1.getLastname().compareTo(part2.getLastname());
        }
        return direction * result;
    }
}
