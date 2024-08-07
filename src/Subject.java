import java.util.Arrays;

public enum Subject {
    Java(1, "Java", SubjectType.REQUIRED, CalculateRequiredSubjectGrade::getGrade),
    ObjectOriented(2, "객체지향", SubjectType.REQUIRED, CalculateRequiredSubjectGrade::getGrade),
    Spring(3, "Spring", SubjectType.REQUIRED, CalculateRequiredSubjectGrade::getGrade),
    JPA(4, "JPA", SubjectType.REQUIRED, CalculateRequiredSubjectGrade::getGrade),
    MySQL(5, "MySQL", SubjectType.REQUIRED, CalculateRequiredSubjectGrade::getGrade),

    DesignPattern(6, "디자인 패턴", SubjectType.OPTIONAL, CalculateSelectedSubjectGrade::getGrade),
    SpringSecurity(7, "Spring Security", SubjectType.OPTIONAL, CalculateSelectedSubjectGrade::getGrade),
    Redis(8, "Redis", SubjectType.OPTIONAL, CalculateSelectedSubjectGrade::getGrade),
    MongoDB(9, "MongoDB", SubjectType.OPTIONAL, CalculateSelectedSubjectGrade::getGrade);

    public enum SubjectType {
        REQUIRED,
        OPTIONAL;
    }

    private final int subId;
    private final String subName;
    private final SubjectType subType;
    private final CalculateGrade calculateGrade;

    Subject(int subId, String subName, SubjectType subType, CalculateGrade calculateGrade) {
        this.subId = subId;
        this.subName = subName;
        this.subType = subType;
        this.calculateGrade = calculateGrade;
    }

    public int getSubId() {
        return subId;
    }

    public String getSubName() {
        return subName;
    }

    public SubjectType getSubType() {
        return subType;
    }

    public char calculateGrade(int score) {
        return this.calculateGrade.getGrade(score);
    }

    public static Subject getSubjectById(int subId) {
        Subject[] subjects = Subject.values();
        return Arrays.stream(Subject.values())
                .filter(v -> v.subId == subId).findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 ID를 입력하셨습니다."));
    }
}
