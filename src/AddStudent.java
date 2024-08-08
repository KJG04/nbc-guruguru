import java.util.*;
import java.util.stream.Collectors;

public class AddStudent implements ManagementActionFunction {
    // Reset color
    public static final String ANSI_RESET = "\u001B[0m";
    // Red color
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void action(ManagementApplication managementApplication) {

        Scanner sc = managementApplication.getScanner();
        Map<Integer, Student> studentMap = managementApplication.getStudentMap();

        // 고유번호 입력 및 중복 검사
        int stdNo;
        while (true) {
            System.out.print("\n수강생의 고유번호를 입력해주세요: ");

            while (true) {
                try {
                    stdNo = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("[번호를 입력해주세요.]");
                    sc.nextLine();
                }
            }
            if (studentMap.containsKey(stdNo)) {
                System.out.println(ANSI_RED + stdNo + "라는 수강생 번호는 이미 존재합니다." + ANSI_RESET);
            } else {
                break;
            }
        }
        System.out.print("이름을 입력하세요: ");
        String stdName = sc.nextLine();

        int maxRequiredCount = 0;
        int maxElectiveCount = 0;

        // 필수과목과 선택과목 중복 허동 제거
        Set<Subject> subjects = new HashSet<>();

        // 필수 과목 입력받기
        System.out.println("필수과목을 입력해주세요(최소 3개)");
        System.out.println("==================");
        System.out.println(Arrays.stream(Subject.values()).filter(v -> v.getSubType() == Subject.SubjectType.REQUIRED).map(v -> String.format("%d. %s", v.getSubId(), v.getSubName())).collect(Collectors.joining("\n")));
        System.out.println("==================");

        while (true) {
            System.out.print("필수 과목번호를 공백으로 구분지어 입력해주세요: ");
            String input = sc.nextLine().trim().replaceAll("\\s", " ");

            Set<Integer> nums;
            try {
                nums = new HashSet<>(Arrays.stream(input.split(" ")).map(Integer::parseInt).toList());
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "숫자를 입력해주세요." + ANSI_RESET);
                continue;
            }

            if (nums.isEmpty()) {
                System.out.println(ANSI_RED + "숫자를 입력해주세요." + ANSI_RESET);
                continue;
            }

            if (nums.size() < 3) {
                System.out.println(ANSI_RED + "3개 이상 입력해주세요." + ANSI_RESET);
                continue;
            }

            List<Integer> requiredSubjectIds = Arrays.stream(Subject.values()).filter(v -> v.getSubType() == Subject.SubjectType.REQUIRED).map(Subject::getSubId).toList();
            if (!requiredSubjectIds.containsAll(nums)) {
                System.out.println(ANSI_RED + "필수 과목 고유 번호를 입력해주세요." + ANSI_RESET);
                continue;
            }

            subjects.addAll(nums.stream().map(Subject::getSubjectById).toList());
            break;
        }

        // 선택 과목 입력받기
        System.out.println("선택과목을 입력해주세요(최소 2개)");
        System.out.println("==================");
        System.out.println(Arrays.stream(Subject.values()).filter(v -> v.getSubType() == Subject.SubjectType.OPTIONAL).map(v -> String.format("%d. %s", v.getSubId(), v.getSubName())).collect(Collectors.joining("\n")));
        System.out.println("==================");
        while (true) {
            System.out.print("선택 과목번호를 공백으로 구분지어 입력해주세요: ");
            String input = sc.nextLine().trim().replaceAll("\\s", " ");

            Set<Integer> nums;
            try {
                nums = new HashSet<>(Arrays.stream(input.split(" ")).map(Integer::parseInt).toList());
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "숫자를 입력해주세요." + ANSI_RESET);
                continue;
            }

            if (nums.isEmpty()) {
                System.out.println(ANSI_RED + "숫자를 입력해주세요." + ANSI_RESET);
                continue;
            }

            if (nums.size() < 2) {
                System.out.println(ANSI_RED + "2개 이상 입력해주세요." + ANSI_RESET);
                continue;
            }

            List<Integer> optionalSubjectIds = Arrays.stream(Subject.values()).filter(v -> v.getSubType() == Subject.SubjectType.OPTIONAL).map(Subject::getSubId).toList();
            if (!optionalSubjectIds.containsAll(nums)) {
                System.out.println(ANSI_RED + "선택 과목 고유 번호를 입력해주세요." + ANSI_RESET);
                continue;
            }

            subjects.addAll(nums.stream().map(Subject::getSubjectById).toList());
            break;
        }

        // 상태 입력
        Status status = null;
        while (status == null) {
            System.out.print("상태를 입력해주세요.(GREEN, RED, YELLOW): ");
            String statusInput = sc.nextLine().toUpperCase();

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