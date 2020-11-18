package pt.pa.model;

import java.util.Comparator;
import java.util.List;

public class GradeSortByName implements GradeSorting{

    @Override
    public void sort(List<StudentGrade> list) {
        list.sort(new SortNames());
    }

    private class SortNames implements Comparator<StudentGrade> {
        @Override
        public int compare(StudentGrade sg1, StudentGrade sg2) {
            return sg1.getName().compareToIgnoreCase(sg2.getName());
        }

    }
}
