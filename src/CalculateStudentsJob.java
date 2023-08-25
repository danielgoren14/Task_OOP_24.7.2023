import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculateStudentsJob {
    private Map<Integer, List<Student>> courseStudentsMap;
    private PresenceChecker presenceChecker;

    public CalculateStudentsJob (PresenceChecker presenceChecker) {
        this.presenceChecker = presenceChecker;
    }

    public void calculate () {
        new Thread(() -> {
            while (true) {
                List<Integer> coursesIds = this.presenceChecker.getPendingCoursesIds();
                coursesIds.forEach(coursesId -> {
                    List<Student> students = this.courseStudentsMap.get(coursesId);
                    if (students == null) {
                        students = new ArrayList<>();
                        System.out.println("Course " + coursesId + " average: " +
                                students.stream().mapToInt(Student::getGrade).average().orElse(0.0));
                    }
                });
            }
        }).start();
    }



}
