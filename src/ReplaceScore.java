import java.util.Objects;
import java.util.Scanner;

public class ReplaceScore implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication){
        Scanner sc = new Scanner(System.in);
        System.out.println("[점수를 수정할 수강생 번호를 입력해주세요.]");
        System.out.print("학생 고유 번호 : ");
        int stdNo = sc.nextInt();
        sc.nextLine();

        Student student = (Student) managementApplication.getStudentMap().get(stdNo);

        if(!Objects.nonNull(student)) {
            System.out.println("[존재하지 않는 학생입니다.]");
            return;
        }

        while(true) {
            System.out.println("[점수를 수정할 과목 번호를 입력해주세요.]");
            System.out.print("과목 고유 번호 : ");
            int subNo = sc.nextInt();
            sc.nextLine();

            if(!student.getSubList().contains(Subject.getSubjectById(subNo))){
                System.out.println("[해당 수강생이 수강하고 있지 않은 과목입니다!]");
                continue;
            }

            System.out.println("[점수를 수정할 회차를 입력해주세요.]");
            System.out.print("회차 : ");
            int term = sc.nextInt();
            sc.nextLine();

            if(!managementApplication.getScoreMap().containsKey(new Score(stdNo, subNo, term, 0))) {
                System.out.println("[해당 회차로 등록된 점수가 존재하지 않습니다.]");
                continue;
            }

            System.out.println("[새롭게 등록할 점수를 입력해주세요.]");
            System.out.print("점수 : ");
            int score = sc.nextInt();
            sc.nextLine();

            if(score > 100 || score < 0){
                System.out.println("[점수는 0~100점 범위 내에서 입력해주세요.]");
                continue;
            }

            Score scoreSub = new Score(stdNo, subNo, term, score);

            if(managementApplication.getScoreMap().containsKey(scoreSub.hashCode())){
                managementApplication.getScoreMap().put(scoreSub.hashCode(), scoreSub);
                System.out.println("[수정이 완료되었습니다.]");
            }

            break;
        }
    }
}
