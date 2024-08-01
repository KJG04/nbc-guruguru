public class Subject {
    // 과목 타입 상수 정의
    public static final String REQUIRED = "필수";
    public static final String ELECTIVE = "선택";

    private String subjectId;
    private String subjectName;
    private String subjectType;

    public Subject(String seq, String subjectName, String subjectType) {
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    public String getSubId() {
        return subjectId;
    }

    public String getSubName() {
        return subjectName;
    }

    public String getSubType() {
        return subjectType;
    }

    public void setSubId(String subjectID) {
        this.subjectId = subjectID;
    }

    public void setSubName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubType(String subjectType) {
        this.subjectType = subjectType;
    }

}
