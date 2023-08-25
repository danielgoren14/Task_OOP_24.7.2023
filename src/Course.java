import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Course {
    private int id;
    private List<Student> studentsByCourse;

    public Course (int id) {
        this.id = id;
        this.studentsByCourse = new ArrayList<>();
    }

    public void setStudentsByCourse(List<Student> studentsByCourse) {
        this.studentsByCourse = studentsByCourse;
    }

    public int getId() {
        return this.id;
    }
}
