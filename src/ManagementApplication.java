import java.util.*;

public class ManagementApplication {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private final Scanner scanner;

    private final Map<Integer, Object> studentMap;
    private final Map<ScoreKey, Object> scoreMap;
    public ScoreManage scoreManage;

    public ManagementApplication() {
        this.scanner = new Scanner(System.in);
        this.studentMap = new HashMap<>();
        this.scoreMap = new HashMap<>();
        this.scoreManage = new ScoreManage();
    }

    public Map<Integer, Object> getStudentMap() {
        return studentMap;
    }

    public Map<ScoreKey, Object> getScoreMap() {
        return scoreMap;
    }

    public Scanner getScanner() {
        return scanner;
    }

    private ManagementType inputManagementType() {
        for (ManagementType managementType : ManagementType.values()) {
            System.out.println(managementType.getId() + ". " + managementType.getDescription());
        }
        System.out.print("관리하고 싶은 종류를 입력해주세요: ");
        int id = this.scanner.nextInt();
        this.scanner.nextLine(); // 개행문자 삭제
        return ManagementType.getManagementTypeById(id);
    }

    private void manageByActionType(ManagementAction.ActionType actionType) {
        System.out.println();
        ManagementAction[] managementActions = Arrays.stream(ManagementAction.values()).filter(v -> v.getActionType() == actionType).toArray(ManagementAction[]::new);
        for (ManagementAction managementAction : managementActions) {
            System.out.println(managementAction.getId() + ". " + managementAction.getDescription());
        }
        System.out.print("실행할 기능을 입력해주세요: ");
        int id = this.scanner.nextInt();
        this.scanner.nextLine(); // 개행문자 삭제
        ManagementAction managementAction = ManagementAction.getManagementAction(id, actionType);
        managementAction.action(this);
    }

    public void start() {
        while (true) {
            ManagementType managementType;

            try {
                System.out.println();
                managementType = inputManagementType();
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "오류: 숫자를 입력해주세요.\n" + ANSI_RESET);
                this.scanner.nextLine(); // 개행문자 삭제
                continue;
            } catch (IllegalArgumentException e) {
                System.out.printf(ANSI_RED + "오류: %s 중에 입력해주세요.%n%n" + ANSI_RESET, Arrays.toString(Arrays.stream(ManagementType.values()).map(ManagementType::getId).mapToInt(Integer::intValue).toArray()));
                continue;
            }

            switch (managementType) {
                case MANAGEMENT_STUDENT -> manageByActionType(ManagementAction.ActionType.STUDENT);
                case MANAGEMENT_SCORE -> manageByActionType(ManagementAction.ActionType.SCORE);
                case MANAGEMENT_EXIT -> {
                    return;
                }
            }
        }
    }
}
