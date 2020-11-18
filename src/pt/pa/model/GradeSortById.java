package pt.pa.model;

import java.util.Comparator;
import java.util.List;

public class GradeSortById implements GradeSorting{

    @Override
    public void sort(List<StudentGrade> list) {
        list.sort(new SortIds());
    }

    private class SortIds implements Comparator<StudentGrade> {
        @Override
        public int compare(StudentGrade sg1, StudentGrade sg2) {
            return Integer.parseInt(sg1.getId()) - Integer.parseInt(sg2.getId());
        }

    }
}
