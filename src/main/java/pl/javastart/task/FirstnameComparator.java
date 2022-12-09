package pl.javastart.task;

import java.util.Comparator;

public class FirstnameComparator implements Comparator<Participant> {

    private int direction;

    public FirstnameComparator(int direction) {
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
            result = part1.getFirstname().compareTo(part2.getFirstname());
        }
        return direction * result;
    }
}
