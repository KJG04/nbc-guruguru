import java.util.Map;

public class StudentList implements ManagementActionFunction{
    // Reset color
    public static final String ANSI_RESET = "\u001B[0m";
    // Red color
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void action(ManagementApplication managementApplication) {
        Map<Integer, Student> studentMap = managementApplication.getStudentMap();

        if (studentMap.isEmpty()) {
            System.out.println(ANSI_RED + "등록된 수강생이 없습니다." + ANSI_RESET);
            return;
        }

        System.out.println("수강생 목록:");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            Integer studentId = entry.getKey();
            Student student = (Student) entry.getValue();
            System.out.println("학생 고유 번호: " + student.getStdNo() + "\n" +
                    "이름: " + student.getName() + "\n" +
                    "상태: " + student.getStatus() + "\n" +
                    "과목: " + student.getSubList() + "\n");
        }
    }
}