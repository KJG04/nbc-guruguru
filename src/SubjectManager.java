import java.util.*;

public class SubjectManager {

    private static List<Subject> subjectList = new ArrayList<>();
    private static List<String> requireList = Arrays.asList("Java", "객체지향", "Spring", "JPA", "MySQL");
    private static List<String> electiveList = Arrays.asList("디자인 패턴", "Spring Security", "Redis", "MongoDB");

    // 새로운 과목 저장
    public void addSubject(int subjectId, String subjectName) {
        if (requireList.contains(subjectName)) {
            Subject subject = new Subject(subjectId, subjectName, Subject.REQUIRED);
            subjectList.add(subject);
            System.out.println("필수과목인 " + subjectName + "가 등록되었습니다.");
        } else if (electiveList.contains(subjectName)) {
            Subject subject = new Subject(subjectId, subjectName, Subject.ELECTIVE);
            subjectList.add(subject);
            System.out.println("선택 과목인 " + subjectName + "가 등록되었습니다.");
        } else {
            System.out.println("잘못된 과목을 입력하셨습니다.");
        }
    }

    // 리스트에 있는 과목들 출력
    public static void viewSubject() {
        if (subjectList.isEmpty()) {
            System.out.println("등록된 과목이 없습니다.");
            return;
        }

        for (Subject subject : subjectList) {
            System.out.println("ID: " + subject.getSubId() + ", Name: " + subject.getSubName() + ", Status: " + subject.getSubType());
        }
    }

    // 리스트에 있는 과목에서 삭제
    public static void deleteSubject(int subjectId) {
        // 과목 번호를 검색하여 삭제
        Iterator<Subject> iterator = subjectList.iterator();
        while(iterator.hasNext()) {
            Subject subject = iterator.next();
            if (subject.getSubId() == subjectId) {
                System.out.println("과목 ID가 " + subject.getSubId() + "이며, " + "과목 이름은 " + subject.getSubName() +"인 등록된 과목이 삭제되었습니다.");
                iterator.remove();
                return;
            }
        }
    }

    // 특정 과목 조회
    public static void findSubjectById(int subjectId) {
        for (Subject subject : subjectList) {
            if (subject.getSubId() == subjectId) {
                System.out.println("과목ID : " + subject.getSubId() + ", 과목 이름 : " + subject.getSubName());
            }
        }
    }
}
