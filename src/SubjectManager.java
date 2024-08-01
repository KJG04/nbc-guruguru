import java.util.ArrayList;
import java.util.List;

public class SubjectManager {

    private static List<Subject> subjectList = new ArrayList<>();

    // 새로운 과목 저장
    public void addSubject(int subjectId, String subjectName, String subjectType) {
        Subject subject = new Subject(subjectId, subjectName, subjectType);
        subjectList.add(subject);
    }

    // 리스트에 있는 과목들 출력
    public static void viewSubject() {
        if (subjectList.isEmpty()) {
            System.out.println("등록된 과목이 없습니다.");
            return;
        }

        for (Subject subject : subjectList) {
            System.out.println("ID: " + subject.getSubId() + ", Name: " + subject.getSubName() + ", Status: " + subject.getSubType());
            System.out.println();
        }
    }

    // 리스트에 있는 과목에서 삭제
    public static void deleteSubject(String subjectId) {
        // 과목 번호를 검색하여 삭제
    }

    // 특정 과목 조회
//    public static Subject findSubjectById(String subjectId) {
//    }
}
