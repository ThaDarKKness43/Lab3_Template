package pt.pa.model;

import java.util.*;

public class CourseGrades {
    private final String course;
    private final Map<String, StudentGrade> results;
    private Statistic statistic;
    private GradeSorting gradeSorting;

    /**
     * Instanciates a new course with empty list of grades.
     * @param course
     */
    public CourseGrades(String course) {
        this.course = course;
        this.results = new HashMap<>();
        this.statistic = new StatisticAverage();
    }

    /**
     * Checks whether a student exists in the current results.
     * @param studentId student id to query
     * @return true if exists.
     */
    public boolean exists(String studentId) {
        return results.containsKey(studentId);
    }

    /**
     * Gets the corresponding result for a student.
     * @param studentId student id to query
     * @return student grade; null if does not exist
     */
    public StudentGrade get(String studentId)  {
        StudentGrade studentGrade = results.get(studentId);
        /* If student doesn't exist, null is returned */
        return studentGrade;
    }

    /**
     * Adds a grade to the course results
     * @param g grade to add
     * @throws CourseGradesException if already exists a result for the student contained in <code>g</code>
     * @throws NullPointerException if <code>g</code> is null
     */
    public void add(StudentGrade g) throws CourseGradesException, NullPointerException {
        if(g == null)
            throw new NullPointerException("StudentGrade cannot be null.");

        if(results.containsKey(g.getId()))
            throw new CourseGradesException("Student already exists.");

        results.put(g.getId(), g);
    }

    /**
     * Removes a grade from the course results
     * @param studentId id of student's grade to remove.
     * @return the removed grade; null if does not exist
     */
    public StudentGrade remove(String studentId)  {
        StudentGrade studentGrade = results.remove(studentId);
        /* If student doesn't exist, null is returned */
        return studentGrade;
    }

    /**
     * Updates a grade within the current results.
     * @param studentId student id
     * @param newGrade new grade for the student
     * @return previous grade
     * @throws CourseGradesException if no student with <code>studentId</code> exist in the current results
     */
    public int update(String studentId, int newGrade) throws CourseGradesException {
        if(newGrade < 0 || newGrade > 20) throw new CourseGradesException("Grade must be in [0,20].");
        if(!exists(studentId))
            throw new CourseGradesException("Student does not exist: " + studentId);

        StudentGrade studentGrade = results.get(studentId);
        int oldGrade = studentGrade.updateGrade(newGrade);
        return oldGrade;
    }

    /**
     * Returns a collection of all current grades.
     * @return collection of grades
     */
    public Collection<StudentGrade> list() {
        List<StudentGrade> list = new ArrayList<>( results.values() );
        //list.sort((g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));
        this.gradeSorting.sort(list);
        return list;
    }

    /**
     * Changes the statistic attribute currently used.
     * @param s The new statistic to be used.
     */
    public void changeStatistic(Statistic s){
        this.statistic = s;
    }

    /**
     * Calculates the set statistic operation at 'statistic'.
     * @return the calculated value.
     */
    public double computeStatistic(){
        return statistic.compute((ArrayList)(this.list()));
    }

    /**
     * Change the grade sorting strategy.
     * @param gs The new grade sorting instance.
     */
    public void changeGradeSorting(GradeSorting gs){
        this.gradeSorting = gs;
    }

    /**
     * Clears all current results.
     */
    public void clear() {
        results.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.course + "\n");

        for(StudentGrade g : list()) {
            sb.append( String.format("%10s | %-30s | %2d\n",
                    g.getId(), g.getName(), g.getGrade()));
        }

        return sb.toString();
    }
}
