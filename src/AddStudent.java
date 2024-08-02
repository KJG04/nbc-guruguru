import java.util.*;

public class AddStudent implements ManagementActionFunction{
    @Override
    public void action(ManagementApplication managementApplication){

        Scanner scanner = managementApplication.getScanner();

        System.out.print("수강생의 고유번호를 입력해주세요 : ");
        int stdNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("이름을 입력하세요 : ");
        String stdName = scanner.nextLine();

        int maxRequiredCount = 0;
        int maxElectiveCount = 0;

        List<Subject> subjects = new ArrayList<>();

        System.out.println("필수과목을 입력해주세요(최소 3개)");
        while (maxRequiredCount < 3) {
            System.out.print("과목번호를 입력해주세요 (종료하려면 -1 입력) : ");
            int subNo = scanner.nextInt();
            scanner.nextLine();
            if (subNo == -1) {
                if (maxRequiredCount < 3) {
                    System.out.println("필수 과목을 3개 이상 입력해야합니다.");
                    return;
                }
                break;
            }

            Subject subject = Subject.getSubjectById(subNo);
            if (subject.isSubType()) {
                subjects.add(subject);
                maxRequiredCount++;
            }
        }

        System.out.println("선택과목을 입력해주세요(최소 3개)");
        while (maxElectiveCount < 2) {
            System.out.print("과목번호를 입력해주세요 (종료하려면 -1 입력) : ");
            int subNo = scanner.nextInt();
            scanner.nextLine();

            if (subNo == -1) {
                if (maxElectiveCount < 2) {
                    System.out.println("선수 과목을 2개 이상 입력해야합니다.");
                    return;
                }
                break;
            }

            Subject subject = Subject.getSubjectById(subNo);
            if (!subject.isSubType()) {
                subjects.add(subject);
                maxElectiveCount++;
            }
        }

        // 필수 과목 3개, 선택 과목 2개를 최소 가지고 있는 확인
        if (maxRequiredCount < 3 || maxElectiveCount < 2) {
            System.out.println("등록 실패: 필수 과목 3개와 선택 과목 2개 이상의 조건을 만족해야 합니다.");
            return;
        }

        Student student = new Student(stdNo, stdName, subjects);
        managementApplication.getStudentMap().put(stdNo, student);
        System.out.println("학생이 성공적으로 등록되었습니다.");
    }


}