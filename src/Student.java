import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private boolean isPresent;
    private String name;
    private int grade;

    public Student (String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public int getGrade () {
        return this.grade;
    }
}
