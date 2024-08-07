import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InquiryStudentByStatus implements ManagementActionFunction {
    // Reset color
    public static final String ANSI_RESET = "\u001B[0m";
    // Red color
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner scanner = managementApplication.getScanner();
        Map<Integer, Student> studentMap = managementApplication.getStudentMap();

        Status statusToQuery = null;
        while (statusToQuery == null) {
            System.out.print("\n조회하고자 할 상태를 입력해주세요(GREEN, RED, YELLOW) : ");
            String statusInput = scanner.nextLine().toUpperCase();

            try {
                statusToQuery = Status.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "잘못된 상태를 입력하셨습니다. GREEN, RED, YELLOW 중에서 선택해 주세요." + ANSI_RESET);
            }
        }

        // 특정 상태에 해당하는 수강생을 조회
        boolean found = false;
        System.out.println(statusToQuery + "에 해당하는 수강생들의 정보 : ");
        for (Object object : studentMap.values()) {
            if (object instanceof Student) {
                Student student = (Student) object;
                if (student.getStatus() == statusToQuery) {
                    System.out.println("학생 고유 번호: " + student.getStdNo() + "\n" +
                            "이름: " + student.getName() + "\n" +
                            "상태: " + student.getStatus() + "\n" +
                            "과목: " + student.getSubList().stream().map(Subject::getSubName).collect(Collectors.joining(", ", "[", "]")) + "\n");
                    found = true;
                }
            } else {
                System.out.println(ANSI_RED + "예상하지 못한 타입 입니다." + ANSI_RESET);
            }
        }
        if (!found) {
            System.out.println(ANSI_RED + statusToQuery + " 상태에 해당하는 수강생이 없습니다." + ANSI_RESET);
        }
    }
}