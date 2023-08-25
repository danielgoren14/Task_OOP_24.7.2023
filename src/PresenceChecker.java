import java.util.ArrayList;
import java.util.List;

public class PresenceChecker {
    private List<Course> courses;

    public PresenceChecker () {
        this.courses = new ArrayList<>();
    }

    public List<Integer> getPendingCoursesIds () {
        return this.courses.stream().map(course -> course.getId()).toList();
    }




}
