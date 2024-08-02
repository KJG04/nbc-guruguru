import java.util.Arrays;

public enum ManagementAction {
    ADD_STUDENT(1, "수강생 정보 등록", ActionType.STUDENT, managementApplication -> {
        System.out.println("ADD_STUDENT");
    }),
    INQUIRY_STUDENT(2, "수강생 조회", ActionType.STUDENT, managementApplication -> {
        System.out.println("INQUIRY_STUDENT");
    }),
    INQUIRY_STUDENT_BY_STATUS(3, "특정 상태의 수강생을 조회", ActionType.STUDENT, managementApplication -> {
        System.out.println("INQUIRY_STUDENT_BY_STATUS");
    }),
    DELETE_STUDENT(4, "수강생 삭제", ActionType.STUDENT, managementApplication -> {
        System.out.println("DELETE_STUDENT");
    }),
    EDIT_STUDENT(5, "수강생 정보 변경", ActionType.STUDENT, managementApplication -> {
        System.out.println("EDIT_STUDENT");
    }),

    ADD_SCORE(1, "점수 등록", ActionType.SCORE, new AddScore()),
    INQUIRY_SCORE(2, "점수 조회", ActionType.SCORE, new ShowScore()),
    EDIT_SCORE(3, "점수 수정", ActionType.SCORE, new ReplaceScore()),
    INQUIRY_AVG_SCORE_BY_SUBJECT(4, "과목별 평균 점수 조회", ActionType.SCORE, managementApplication -> {
        System.out.println("INQUIRY_AVG_SCORE_BY_SUBJECT");
    }),
    INQUIRY_REQUIRED_SUBJECT_AVG_SCORE_BY_STATUS(5, "특정 상태 수강생들의 필수 과목 평균 등급을 조회", ActionType.SCORE, managementApplication -> {
        System.out.println("INQUIRY_REQUIRED_SUBJECT_AVG_SCORE_BY_STATUS");
    });

    public enum ActionType {
        STUDENT, SCORE;
    }

    private final int id;
    private final String description;
    private final ActionType actionType;
    private final ManagementActionFunction managementActionFunction;

    ManagementAction(int id, String description, ActionType actionType, ManagementActionFunction managementActionFunction) {
        this.id = id;
        this.description = description;
        this.actionType = actionType;
        this.managementActionFunction = managementActionFunction;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void action(ManagementApplication managementApplication) {
        this.managementActionFunction.action(managementApplication);
    }

    public static ManagementAction getManagementAction(int id, ActionType actionType) {
        return Arrays.stream(ManagementAction.values()).filter(v -> v.id == id && v.actionType == actionType).findFirst().orElseThrow(() -> new IllegalArgumentException("[getManagementAction] 잘못된 id와 actionType 값입니다."));
    }
}

