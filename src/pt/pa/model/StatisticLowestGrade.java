package pt.pa.model;

import java.util.Collections;
import java.util.List;

public class StatisticLowestGrade implements Statistic {

    @Override
    public double compute(List<StudentGrade> grades) {

        if (grades.isEmpty()) return -1;

        double grade = 21;

        for(StudentGrade sg : grades){
            double currentGrade = sg.getGrade();
            if (currentGrade < grade){
                grade = currentGrade;
            }
        }

        return grade;
    }
}
