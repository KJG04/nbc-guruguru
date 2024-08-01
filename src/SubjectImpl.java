import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {

    private static List<Subject> subjects = new ArrayList<>();

    private int subId;
    private String subName;
    private String subType;

    // 생성자
    public SubjectImpl() {

    }

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

    // 새로운 과목 저장
    public void addSubject(int subId, String subjectName, String subjectType) {
        subjects.add(new SubjectImpl(subId, subjectName, subjectType));
    }

    // 리스트에 있는 과목들 출력
    public void printSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("과목이 없습니다.");
            return;
        }
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + subId + '\'' +
                ", name='" + subName + '\'' +
                ", type='" + subType + '\'' +
                '}';
    }
}
