import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class EditStudent implements ManagementActionFunction {
    // Reset color
    public static final String ANSI_RESET = "\u001B[0m";
    // Red color
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner scanner = managementApplication.getScanner();
        Map<Integer, Student> studentMap = managementApplication.getStudentMap();

        // 학생 ID 입력 받기
        System.out.print("\n수정할 수강생의 ID를 입력해주세요 : ");
        int idToChange;
        while(true) {
            try {
                idToChange = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("[숫자를 입력해주세요.]");
                scanner.nextLine();
            }
        }

        Student student = (Student) studentMap.get(idToChange);
        if (student == null) {
            System.out.println(ANSI_RED + "ID가 " + idToChange + "인 수강생의 정보가 없습니다." + ANSI_RESET);
            return;
        } else {
            System.out.println("수정할 항목을 입력해주세요.");
            System.out.println("1. 이름");
            System.out.println("2. 상태");
            int choice;    // 개행 문자 처리

            while(true) {
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("[숫자를 입력해주세요.]");
                    scanner.nextLine();
                }
            }

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
                            System.out.println(ANSI_RED + "잘못된 상태를 입력하셨습니다. GREEN, RED, YELLOW 중에서 선택해 주세요." + ANSI_RESET);
                        }
                    }
                    student.setStatus(newstatus);
                    System.out.println("수강생인 " + student.getName() + "의 상태가 수정되었습니다 : " + newstatus);
                    break;
                default:
                    System.out.println(ANSI_RED + "잘못된 선택하셨습니다. 1 또는 2를 입력해주세요." + ANSI_RESET);

            }
        }
    }
}
