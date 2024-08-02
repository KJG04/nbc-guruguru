import java.util.Map;

public class StudentList implements ManagementActionFunction{
    @Override
    public void action(ManagementApplication managementApplication) {
        Map<Integer, Object> studentMap = managementApplication.getStudentMap();

        if (studentMap.isEmpty()) {
            System.out.println("등록된 수강생이 없습니다.");
            return;
        }

        System.out.println("수강생 목록:");
        for (Map.Entry<Integer, Object> entry : studentMap.entrySet()) {
            Integer studentId = entry.getKey();
            Student student = (Student) entry.getValue();
            System.out.println("ID: " + student.getStdNo() + ", Name: " + student.getName());
        }
    }
}
