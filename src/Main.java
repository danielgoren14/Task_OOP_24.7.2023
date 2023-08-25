import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println(doTask(3));

        //        SharedResourceExercise1 sharedResourceExercise1_1 = new SharedResourceExercise1();
//        Thread thread1 = new Thread(() -> {
//            int counter = 0;
//            while (counter < 100) {
//                sharedResourceExercise1_1.increment();
//                counter ++;
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread thread2 = new Thread(() -> {
//            int counter = 0;
//            while (counter < 100) {
//                sharedResourceExercise1_1.decrement();
//                counter ++;
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread thread3 = new Thread(() -> {
//            IntStream.range(0,10).forEach(i -> {
//                System.out.println(i + ": " + sharedResourceExercise1_1);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        });
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread1.join();
//        thread2.join();
//        thread3.join();
//        System.out.println(sharedResourceExercise1_1);



//        SharedResourceExercise1 sharedResourceExercise1 = new SharedResourceExercise1();
//        Thread thread1 = new Thread(() -> {
//           IntStream.range(0,1000000).forEach(i -> {
//               sharedResourceExercise1.increment();
//           });
//        });
//        Thread thread2 = new Thread(() -> {
//            IntStream.range(0,1000000).forEach(i -> {
//                sharedResourceExercise1.decrement();
//            });
//        });
//        Thread thread3 = new Thread(() -> {
//            IntStream.range(0,10).forEach(i -> {
//                System.out.println(i + ": " + sharedResourceExercise1);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        });
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread1.join();
//        thread2.join();
//        thread3.join();
//        System.out.println(sharedResourceExercise1);



//        Map<String ,List<Integer>> mapOfInteger = new HashMap<>();
//
//        List<String> keys = Arrays.asList("firstKey", "secondKey");
//        initializeKeys(mapOfInteger,keys);



//        Map<String,List<Integer>> mapOfLists = new HashMap<>();
//
//        List<String> keys = Arrays.asList("firstKey", "secondKey");
//        initializeKeys(mapOfLists,keys);
//
//        mapOfLists.get("firstKey").add(1);
//        mapOfLists.get("secondKey").add(2);
//
//
//        System.out.println("1: " + mapOfLists.get("firstKey"));
//        System.out.println("2: " + mapOfLists.get("secondKey"));
//
//        Scanner scanner = new Scanner(System.in);
//        String keyToClear = scanner.nextLine();
//        mapOfLists.put(keyToClear,new ArrayList<>());
//        mapOfLists.get(keyToClear).add(3);
//
//        System.out.println("3: " + mapOfLists.get("firstKey"));
//        System.out.println("4: " + mapOfLists.get("secondKey"));
    }
    public static void initializeKeys (Map<String, List<Integer>> map, List<String> keys) {
        List<Integer> emptyList = new ArrayList<>();
        for (String key : keys) {
            map.put(key,emptyList);
        }

    }
    //    public static void initializeKeys1 (Map<String ,Integer> map, List<String> keys) {
//        Integer number = null;
//        for (String key : keys) {
//           map.put(key,number);
//        }
//    }
    public static int doTask(int threadsCount) throws Exception {
        int count = 2000;
        SharedResource sharedResource = new SharedResource();
        List<IncrementValueThread<List<String>>> threads = new ArrayList<>();
        IntStream.range(0,threadsCount).forEach(number -> {
            List<String> list = new ArrayList<>();
            IntStream.range(0,count).forEach(i -> {
                String toAdd = String.valueOf(i);
                list.add(toAdd);
            });
            IncrementValueThread<List<String>> incrementValueThread = new IncrementValueThread<>(list,sharedResource);
//            System.out.println(sharedResource);
            threads.add(incrementValueThread);
        });
//        int counter = 0;
        for (IncrementValueThread<List<String>> thread : threads) {
//            System.out.println(counter);
            thread.start();

//            counter ++;
        }

        for (IncrementValueThread<List<String>> thread : threads) {
            thread.join();
        }

        System.out.println(sharedResource.toString());

        Set<Integer> values = new HashSet<>();
        IntStream.range(0,count).forEach(i -> {
            values.add(sharedResource.getValue(String.valueOf(i)));
//            System.out.println(sharedResource.getValue(String.valueOf(i)));
        });
        return values.size();
    }
}
//        //Question 4 - CalculateStudentsJob
//        PresenceChecker presenceChecker = new PresenceChecker();
//        CalculateStudentsJob calculateStudentsJob = new CalculateStudentsJob(presenceChecker);
//        List<Course> courses = new ArrayList<>();
//
//        Course course1 = new Course(1);
//        List<Student> studentsCourse1 = new ArrayList<>();
//        Student student1_1 = new Student("daniel", 90);
//        Student student1_2 = new Student("amit", 100);
//        Student student1_3 = new Student("adi", 95);
//        Student student1_4 = new Student("tal", 93);
//        studentsCourse1.add(student1_1);
//        studentsCourse1.add(student1_2);
//        studentsCourse1.add(student1_3);
//        studentsCourse1.add(student1_4);
//        course1.setStudentsByCourse(studentsCourse1);
//        courses.add(course1);
//
//
//        Course course2 = new Course(2);
//        //
//        List<Student> studentsCourse2 = new ArrayList<>();
//        //
//        Student student2_1 = new Student("noam", 80);
//        Student student2_2 = new Student("shahar", 79);
//        Student student2_3 = new Student("shir", 70);
//        Student student2_4 = new Student("aviv", 71);
//        //
//        studentsCourse2.add(student2_1);
//        studentsCourse2.add(student2_2);
//        studentsCourse2.add(student2_3);
//        studentsCourse2.add(student2_4);
//        //
//        course2.setStudentsByCourse(studentsCourse2);
//        courses.add(course2);
//
//
//
//        Course course3 = new Course(3);
//
//        List<Student> studentsCourse3 = new ArrayList<>();
//        //
//        Student student3_1 = new Student("yarden", 60);
//        Student student3_2 = new Student("lihi", 89);
//        Student student3_3 = new Student("meitav", 19);
//        Student student3_4 = new Student("shilo", 59);
//        //
//        studentsCourse3.add(student3_1);
//        studentsCourse3.add(student3_2);
//        studentsCourse3.add(student3_3);
//        studentsCourse3.add(student3_4);
//        //
//        course3.setStudentsByCourse(studentsCourse3);
//        courses.add(course3);
//
//
//        Course course4 = new Course(4);
//
//        List<Student> studentsCourse4 = new ArrayList<>();
//        //
//        Student student4_1 = new Student("moshe", 100);
//        Student student4_2 = new Student("yosef", 60);
//        Student student4_3 = new Student("ya'akov", 30);
//        Student student4_4 = new Student("rut", 100);
//        //
//        studentsCourse4.add(student4_1);
//        studentsCourse4.add(student4_2);
//        studentsCourse4.add(student4_3);
//        studentsCourse4.add(student4_4);
//        //
//        course4.setStudentsByCourse(studentsCourse4);
//        courses.add(course4);
//
//
//
//        Course course5 = new Course(5);
//
//        List<Student> studentsCourse5 = new ArrayList<>();
//        //
//        Student student5_1 = new Student("tzila", 0);
//        Student student5_2 = new Student("einav", 5);
//        Student student5_3 = new Student("shlomo", 5);
//        Student student5_4 = new Student("shalom", 10);
//        //
//        studentsCourse5.add(student5_1);
//        studentsCourse5.add(student5_2);
//        studentsCourse5.add(student5_3);
//        studentsCourse5.add(student5_4);
//        //
//        course5.setStudentsByCourse(studentsCourse5);
//        courses.add(course5);
//
//
//        Course course6 = new Course(6);
//
//        List<Student> studentsCourse6 = new ArrayList<>();
//        //
//        Student student6_1 = new Student("haim", 30);
//        Student student6_2 = new Student("yitzhak", 30);
//        Student student6_3 = new Student("yoav", 30);
//        Student student6_4 = new Student("avi", 40);
//        //
//        studentsCourse6.add(student6_1);
//        studentsCourse6.add(student6_2);
//        studentsCourse6.add(student6_3);
//        studentsCourse6.add(student6_4);
//        //
//        course6.setStudentsByCourse(studentsCourse6);
//        courses.add(course6);
//
//
//        Course course7 = new Course(7);
//
//        List<Student> studentsCourse7 = new ArrayList<>();
//        //
//        Student student7_1 = new Student("shalev", 70);
//        Student student7_2 = new Student("yarom", 39);
//        Student student7_3 = new Student("idan", 75);
//        Student student7_4 = new Student("yogev", 85);
//        //
//        studentsCourse6.add(student7_1);
//        studentsCourse6.add(student7_2);
//        studentsCourse6.add(student7_3);
//        studentsCourse6.add(student7_4);
//        //
//        course7.setStudentsByCourse(studentsCourse7);
//        courses.add(course7);
//        List<Integer> coursesIds = courses.stream()
//                .map(Course::getId)
//                .toList();
//
//        while (true) {
//            coursesIds.forEach(courseId -> {
//                List<Student> students = null;
//                do {
//                    students = presenceChecker.getStudentsThatArePresent(courseId);
//                } while (!students.isEmpty());
//            });
//        }
