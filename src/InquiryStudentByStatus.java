import java.util.*;

public class InquiryStudentByStatus implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner scanner = managementApplication.getScanner();
        Map<Integer, Object> studentMap = managementApplication.getStudentMap();

        Status statusToQuery  = null;
        while (statusToQuery  == null) {
            System.out.print("조회하고자 할 상태를 입력해주세요(GREEN, RED, YELLOW) : ");
            String statusInput = scanner.nextLine().toUpperCase();

            try {
                statusToQuery = Status.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못되 상태 입력하셨습니다. GREEN, RED, YELLOW 중에서 선택해 주세요.");
            }
        }

        // 특정 상태에 해당하는 수강생을 조회
        boolean found = false;
        System.out.println(statusToQuery + "에 해당하는 수강생들의 정보 : ");
        for (Object object : studentMap.values()) {
            if (object instanceof Student) {
                Student student = (Student) object;
                if (student.getStatus() == statusToQuery) {
                    System.out.println("ID: " + student.getStdNo() +
                            ", 이름: " + student.getName() +
                            ", 상태 : " + student.getStatus() +
                            ", 과목 : " + student.getSubList());
                    found = true;
                }
            } else {
                System.out.println("예상하지 못한 타입 입니다.");
            }
        }
        if (!found) {
            System.out.println(statusToQuery + " 상태에 해당하는 수강생이 없습니다.");
        }
    }
}
