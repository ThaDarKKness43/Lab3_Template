package pt.pa.model;

import java.util.Collections;
import java.util.List;

public class StatisticHighestGrade implements Statistic {

    @Override
    public double compute(List<StudentGrade> grades) {

        if (grades.isEmpty()) return -1;

        double grade = -1;

        for(StudentGrade sg : grades){
            double currentGrade = sg.getGrade();
            if (currentGrade > grade){
                grade = currentGrade;
            }
        }

        return grade;
    }
}
