import java.util.Arrays;

public enum Subject {

    Java(1, "Java", true, 1),
    ObjectOriented(2, "객체지향", true, 1),
    Spring(3, "Spring", true, 1),
    JPA(4, "JPA", true, 1),
    MySQL(5, "MySQL", true, 1),

    DesignPattern(6, "디자인 패턴", false, 2),
    SpringSecurity(7, "Spring Security", false,2),
    Redis(8, "Redis", false,2),
    MongoDB(9, "MongoDB", false,2);

    private final int subId;
    private final String subName;
    private final boolean subType;
    private final int gradeType;

    Subject(int subId, String subName, boolean subType, int GradeType) {
        this.subId = subId;
        this.subName = subName;
        this.subType = subType;
        this.gradeType = GradeByCategory.gradeByCategory(this.subId);
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

    public int getGradeType() {return gradeType;}

    public static Subject getSubjectById(int subId) {
        Subject[] subjects = Subject.values();
        return Arrays.stream(Subject.values())
                .filter(v -> v.subId == subId).findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 ID를 입력하셨습니다."));
    }
}
