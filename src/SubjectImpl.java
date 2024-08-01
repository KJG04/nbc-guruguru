public class SubjectImpl implements Subject {

    private int subId;
    private String subName;
    private String subType;

    // 생성자
    public SubjectImpl(int subId, String subjectName, String subjectType) {
        this.subId = subId;
        this.subName = subjectName;
        this.subType = subjectType;
    }

    @Override
    public int getSubId() {
        return subId;
    }

    @Override
    public String getSubName() {
        return subName;
    }

    @Override
    public String getSubType() {
        return subType;
    }

    @Override
    public void setSubId(int subjectID) {
        this.subId = subjectID;
    }

    @Override
    public void setSubName(String subjectName) {
        this.subName = subjectName;
    }

    @Override
    public void setSubType(String subjectType) {
        this.subType = subjectType;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + subId + '\'' +
                ", name='" + subName + '\'' +
                ", type='" + subType + '\'' +
                '}';
    }
}
