package pt.pa.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticMedium implements Statistic {

    @Override
    public double compute(List<StudentGrade> grades) {

        new GradeSortByGradeValue().sort(grades);
        grades.sort(Comparator.comparing(StudentGrade::getGrade));

        double middle = Math.floor(grades.size() / 2);

        double result = ((middle) + (middle - 1)/ 2);

        return result;
    }
}
