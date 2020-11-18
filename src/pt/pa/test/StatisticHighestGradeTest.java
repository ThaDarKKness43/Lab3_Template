package pt.pa.test;

import org.junit.Test;
import pt.pa.model.Statistic;
import pt.pa.model.StatisticHighestGrade;
import pt.pa.model.StatisticLowestGrade;
import pt.pa.model.StudentGrade;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatisticHighestGradeTest {

    @Test
    public void compute() {
        Statistic s = new StatisticHighestGrade();

        List<StudentGrade> grades = new ArrayList<>();

        grades.add(new StudentGrade("1", "John", 15));
        grades.add(new StudentGrade("2", "Phil", 13));
        grades.add(new StudentGrade("3", "Kevin", 11));

        assertEquals(15, s.compute(grades), 0.0001);
    }
}
