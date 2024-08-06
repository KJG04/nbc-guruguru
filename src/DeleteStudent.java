import java.util.Map;
import java.util.Scanner;

public class DeleteStudent implements ManagementActionFunction {
    // Reset color
    public static final String ANSI_RESET = "\u001B[0m";
    // Red color
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void action(ManagementApplication managementApplication) {
        Map<Integer, Student> studentMap = managementApplication.getStudentMap();

        Scanner scanner = managementApplication.getScanner();

        // 학생 ID 입력 받기
        System.out.print("삭제할 수강생의 ID를 입력해주세요 : ");
        int idToDelete = scanner.nextInt();

        // 학생 삭제
        Student removedStudent = (Student) studentMap.remove(idToDelete);

        if (removedStudent != null) {
            System.out.println("수강생의 ID가 " + idToDelete + "인 정보가 삭제되었습니다..");
        } else {
            System.out.println(ANSI_RED + "ID가 " + idToDelete + "인 수강생의 정보가 없습니다." + ANSI_RESET);
        }
    }

}
