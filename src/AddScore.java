import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class AddScore implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner sc = managementApplication.getScanner();
        System.out.print("\n학생 고유 번호 : ");
        int stdNo;

        while(true) {
            try {
                stdNo = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("[번호를 입력해주세요.]");
                sc.nextLine();
            }
        }

        //학생 고유번호로 학생 객체 하나 받아오기.

        Student student = managementApplication.getStudentMap().get(stdNo);

        if(!Objects.nonNull(student)){
            System.out.println("[존재하지 않는 학생입니다.]");
            return;
        }

        while(true){
            System.out.print("과목 고유 번호 : ");
            int subNo;

            while(true) {
                try {
                    subNo = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("[번호를 입력해주세요.]");
                    sc.nextLine();
                }
            }

            if(!student.getSubList().contains(Subject.getSubjectById(subNo))){
                System.out.println("[해당 수강생이 수강하고 있지 않은 과목입니다!]");
                continue;
            }
            System.out.print("회차 : ");
            int term;

            while(true) {
                try {
                    term = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("[숫자를 입력해주세요.]");
                    sc.nextLine();
                }
            }

            if(term > 10){
                System.out.println("[시험회차는 10회까지 존재합니다.]");
                continue;
            }

            System.out.print("점수 : ");
            int score;

            while(true) {
                try {
                    score = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("[숫자를 입력해주세요.]");
                    sc.nextLine();
                }
            }

            if(score > 100 || score < 0){
                System.out.println("[점수는 0~100점 범위 내에서 입력해주세요.]");
                continue;
            }

            Score subScore = new Score(stdNo, subNo, term, score);

            if(!managementApplication.getScoreMap().containsKey(subScore.hashCode())){
                managementApplication.getScoreMap().put(subScore.hashCode(), subScore);
                System.out.println("[점수 등록이 완료되었습니다.]");
            }
            else {
                System.out.println("[이미 등록된 점수입니다!]");
            }
            break;
        }
    }
}
