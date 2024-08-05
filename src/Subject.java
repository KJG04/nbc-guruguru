import java.util.Arrays;

public enum Subject {

    Java(1, "Java", true),
    ObjectOriented(2, "객체지향", true),
    Spring(3, "Spring", true),
    JPA(4, "JPA", true),
    MySQL(5, "MySQL", true),

    DesignPattern(6, "디자인 패턴", false),
    SpringSecurity(7, "Spring Security", false),
    Redis(8, "Redis", false),
    MongoDB(9, "MongoDB", false);

    private final int subId;
    private final String subName;
    private final boolean subType;

    Subject(int subId, String subName, boolean subType) {
        this.subId = subId;
        this.subName = subName;
        this.subType = subType;
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

    public static Subject getSubjectById(int subId) {
        Subject[] subjects = Subject.values();
        return Arrays.stream(Subject.values())
                .filter(v -> v.subId == subId).findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 ID를 입력하셨습니다."));
    }
}
