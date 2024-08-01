import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private String status; // 상태 (Green, Red, Yellow)
    private Map<String, List<Integer>> subjects; // 과목과 그에 대한 시험 점수 목록

    private static List<Student> studentStore = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    // studentStore 리스트 반환 메서드
    public static List<Student> getStudentStore() {
        return studentStore;
    }

    // 과목 목록
    private static final List<String> REQUIRED_SUBJECTS = List.of("Java", "객체지향", "Spring", "JPA", "MySQL");
    private static final List<String> OPTIONAL_SUBJECTS = List.of("디자인 패턴", "Spring Security", "Redis", "MongoDB");

    // 생성자
    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.status = "Green"; // 기본 상태는 Green
        this.subjects = new HashMap<>();

        // 필수 과목을 subject에 추가
        for (String subject : REQUIRED_SUBJECTS) {
            this.subjects.put(subject, new ArrayList<>());
        }
    }

    // 수강생 등록
    public static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        String studentId = generateStudentId();

        Student student = new Student(studentId, studentName);
        studentStore.add(student);

        System.out.println("수강생 등록 성공!\n");
    }

    // 학생 ID 생성
    private static String generateStudentId() {
        return "S" + (studentStore.size() + 1);
    }

    // 수강생 목록 조회
    public static void viewStudents() {
        for (Student student : studentStore) {
            System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getStudentName() + ", Status: " + student.getStatus());
            System.out.println();
        }
    }

    // ID로 수강생 찾기
    public static Student findStudentById(String studentId) {
        for (Student student : Student.getStudentStore()) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // 수강생 세부 조회
    public static void viewOneStudent(Student student) {
        if (student == null) {
            System.out.println("수강생을 찾을 수 없습니다.");
            return;
        }

        System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getStudentName() + ", Status: " + student.getStatus());
        for (Map.Entry<String, List<Integer>> entry : student.getSubjects().entrySet()) {
            System.out.println("Subject: " + entry.getKey() + ", Scores: " + entry.getValue());
        }
        System.out.println();
    }


    // 과목 추가
    public void addSubject(String subject) {
        if (OPTIONAL_SUBJECTS.contains(subject)) {
            if (subjects.containsKey(subject)) {
                System.out.println("이미 추가된 과목입니다.");
            } else {
                subjects.put(subject, new ArrayList<>());
                System.out.println("과목이 추가되었습니다.");
            }
        } else {
            System.out.println("Invalid subject!");
        }
    }

    // 상태 변경
    public void changeStatus(String newStatus) {
        if (List.of("Green", "Red", "Yellow").contains(newStatus)) {
            this.status = newStatus;
            System.out.println("상태가 변경되었습니다.");
        } else {
            System.out.println("Invalid status!");
        }
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getStatus() {
        return status;
    }
    public Map<String, List<Integer>> getSubjects() {
        return subjects;
    }

}
