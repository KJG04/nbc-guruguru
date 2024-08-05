import java.util.*;

public class EditStudent implements ManagementActionFunction {

    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> studentMap = managementApplication.getStudentMap();

        // 학생 ID 입력 받기
        System.out.print("수정할 수강생의 ID를 입력해주세요 : ");
        int idToChange = scanner.nextInt();
        scanner.nextLine();

        Student student = (Student) studentMap.get(idToChange);
        if (student != null) {
            System.out.println("수정할 항목을 입력해주세요.");
            System.out.println("1. 이름");
            System.out.println("2. 상태");
            int choice = scanner.nextInt();
            scanner.nextLine();     // 개행 문자 처리

            switch (choice) {
                case 1:
                    // 이름 수정
                    System.out.println("새로 바꿀 이름을 입력해주세요 : ");
                    String name = scanner.nextLine();
                    student.setName(name);
                    System.out.println("수강생의 이름이 수정되었습니다 : " + name);
                    break;
                case 2:
                    // 상태 수정
                    Status newstatus = null;
                    while (newstatus == null) {
                        System.out.print("새로 바꿀 상태를 입력해주세요.(GREEN, RED, YELLOW) : ");
                        String statusInput = scanner.nextLine().toUpperCase();

                        try {
                            newstatus = Status.valueOf(statusInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("잘못되 상태 입력하셨습니다. GREEN, RED, YELLOW 중에서 선택해 주세요.");
                        }
                    }
                    student.setStatus(newstatus);
                    System.out.println("수강생인 "+ student.getName() + "의 상태가 수정되었습니다 : " + newstatus);
                    break;
                default:
                    System.out.println("잘못된 선택하셨습니다. 1 또는 2를 입력해주세요.");

            }
        } else {
            System.out.println("ID가 " + idToChange + "인 수강생의 정보가 없습니다.");
        }
    }
}
