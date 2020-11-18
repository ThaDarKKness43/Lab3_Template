package pt.pa.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pt.pa.model.CourseGrades;
import pt.pa.model.Statistic;
import pt.pa.model.StatisticAverage;
import pt.pa.model.StudentGrade;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StatisticAverageTest {

    //private CourseGrades grades;

    @Test
    public void compute() {
        Statistic s = new StatisticAverage();

        //grades.changeStatistic(s);

        //double result = grades.computeStatistic();

        //System.out.println(result);

        List<StudentGrade> grades = new ArrayList<>();

        grades.add(new StudentGrade("1", "John", 15));
        grades.add(new StudentGrade("2", "Phil", 13));
        grades.add(new StudentGrade("3", "Kevin", 11));

        assertEquals(13, s.compute(grades), 0.0001);
    }
}