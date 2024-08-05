import java.util.*;

public class AddStudent implements ManagementActionFunction{
    // Reset color
    public static final String ANSI_RESET = "\u001B[0m";
    // Red color
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void action(ManagementApplication managementApplication){

        Scanner scanner = managementApplication.getScanner();
        Map<Integer, Object> studentMap = managementApplication.getStudentMap();

        // 고유번호 입력 및 중복 검사
        int stdNo;
        while (true) {
            System.out.print("수강생의 고유번호를 입력해주세요 : ");
            stdNo = scanner.nextInt();
            scanner.nextLine();

            if (studentMap.containsKey(stdNo)) {
                System.out.println(ANSI_RED + stdNo + "라는 수강생 번호는 이미 존재합니다." + ANSI_RESET);
            } else {
                break;
            }
        }
        System.out.print("이름을 입력하세요 : ");
        String stdName = scanner.nextLine();

        int maxRequiredCount = 0;
        int maxElectiveCount = 0;

        // 필수과목과 선택과목 중복 허동 제거
        Set<Subject> subjects = new HashSet<>();

        // 필수 과목 입력받기
        System.out.println("필수과목을 입력해주세요(최소 3개)");
        while (maxRequiredCount < 5) {
            System.out.print("필수 과목번호를 입력해주세요 (종료하려면 -1 입력) : ");
            int subNo = scanner.nextInt();
            scanner.nextLine();

            if (subNo == -1) {
                if (maxRequiredCount < 3) {
                    System.out.println(ANSI_RED + "필수 과목을 3개 이상 입력해야합니다." + ANSI_RESET);
                    continue;
                }
                break;
            }

            Subject subject = Subject.getSubjectById(subNo);
            if (subject.isSubType()) {
                if (subjects.add(subject)) {
                    maxRequiredCount++;
                } else {
                    System.out.println(ANSI_RED + "입력한 과목 번호는 이미 저장된 과목입니다." + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + "입력한 과목은 선택과목입니다. 다시 입력해주세요." + ANSI_RESET);
            }
        }

        // 선택 과목 입력받기
        System.out.println("선택과목을 입력해주세요(최소 2개)");
        while (maxElectiveCount < 4) {
            System.out.print("선택 과목번호를 입력해주세요 (종료하려면 -1 입력) : ");
            int subNo = scanner.nextInt();
            scanner.nextLine();

            if (subNo == -1) {
                if (maxElectiveCount < 2) {
                    System.out.println(ANSI_RED + "선수 과목을 2개 이상 입력해야합니다." + ANSI_RESET);
                    continue;
                }
                break;
            }

            Subject subject = Subject.getSubjectById(subNo);
            if (!subject.isSubType()) {
                if (subjects.add(subject)) {
                    maxElectiveCount++;
                } else {
                    System.out.println(ANSI_RED + "입력한 과목 번호는 이미 저장된 과목입니다." + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + "입력한 과목은 필수과목입니다. 다시 입력해주세요." + ANSI_RESET);
            }
        }

        // 상태 입력
        Status status = null;
        while (status == null) {
            System.out.print("상태를 입력해주세요.(GREEN, RED, YELLOW) : ");
            String statusInput = scanner.nextLine().toUpperCase();

            try {
                status = Status.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "잘못된 상태를 입력하셨습니다. GREEN, RED, YELLOW 중에서 선택해 주세요." + ANSI_RESET);
            }
        }


        Student student = new Student(stdNo, stdName, new ArrayList<>(subjects), status);
        managementApplication.getStudentMap().put(stdNo, student);
        System.out.println("학생이 성공적으로 등록되었습니다.");
    }
}