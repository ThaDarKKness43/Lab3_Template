package pt.pa.model;

import java.util.List;

public class StatisticAverage implements Statistic {

    @Override
    public double compute(List<StudentGrade> grades) {

        if (grades.isEmpty()) return -1;

        int sum = 0;
        for(StudentGrade sg : grades) {
            int g = sg.getGrade();
            sum += g;
        }
        return ((double)sum) / grades.size();
    }
}
