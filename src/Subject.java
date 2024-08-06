import java.util.Arrays;

public enum Subject {
    Java(1, "Java", true, CalculateRequiredSubjectGrade::getGrade),
    ObjectOriented(2, "객체지향", true, CalculateRequiredSubjectGrade::getGrade),
    Spring(3, "Spring", true, CalculateRequiredSubjectGrade::getGrade),
    JPA(4, "JPA", true, CalculateRequiredSubjectGrade::getGrade),
    MySQL(5, "MySQL", true, CalculateRequiredSubjectGrade::getGrade),

    DesignPattern(6, "디자인 패턴", false, CalculateRequiredSubjectGrade::getGrade),
    SpringSecurity(7, "Spring Security", false, CalculateRequiredSubjectGrade::getGrade),
    Redis(8, "Redis", false, CalculateRequiredSubjectGrade::getGrade),
    MongoDB(9, "MongoDB", false, CalculateRequiredSubjectGrade::getGrade);

    private final int subId;
    private final String subName;
    private final boolean subType;
    private final CalculateGrade calculateGrade;

    Subject(int subId, String subName, boolean subType, CalculateGrade calculateGrade) {
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

    public boolean isSubType() {
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
