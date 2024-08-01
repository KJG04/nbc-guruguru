import java.util.List;

public interface Subject {
    // 과목 타입 상수 정의
    String REQUIRED = "필수";
    String ELECTIVE = "선택";

    // 필드
    int getSubId();

    String getSubName();

    String getSubType();

    void setSubId(int subtId);
    void setSubName(String subName);
    void setSubType(String subType);

    // 메서드
    void addSubject(int subId, String subjectName, String subjectType);
    void printSubjects();

}
