package pl.javastart.task;

import java.util.Comparator;

public class ResultComparator implements Comparator<Participant> {
    private int direction;

    public ResultComparator(int direction) {
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
        } else if (part1.getResult() > part2.getResult()) {
            result =  1;
        } else if (part1.getResult() < part2.getResult()) {
            result = -1;
        } else {
            result = 0;
        }
        return result * direction;
    }
}
