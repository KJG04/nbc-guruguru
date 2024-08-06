import java.util.InputMismatchException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShowGradeOrderByStatus implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication){
        Scanner sc = managementApplication.getScanner();

        while(true) {
            int cnt = 1;
            System.out.println(" ");
            for (Status status : Status.values()) {
                System.out.println(cnt + ". " + status.name());
                cnt++;
            }

            int n = 0;

            System.out.println("\n수강생의 상태를 입력하세요 : ");
            try {
                n = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("[올바르지 않은 명령어입니다.(선택할 항목의 번호를 입력해주세요.)]");
                sc.nextLine();
                continue;
            }

            if (n < 1 || n > 3) {
                System.out.println("[선택항목에 존재하지 않습니다.]");
                continue;
            }

            Status status = Status.values()[n-1];

            Map<Integer, Score> orderScore = managementApplication.getScoreMap().entrySet().stream()
                    .filter(entry -> managementApplication.getStudentMap().get(entry.getValue().getStdNo()).getStatus() == status)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            cnt=0;
            int sum = 0;
            for(Map.Entry<Integer, Score> entry : orderScore.entrySet()) {
                sum += entry.getValue().getScore();
                cnt++;
            }

            if(cnt == 0) {
                System.out.println("[해당 상태의 수강생에 대한 점수정보가 존재하지 않습니다.]");
                break;
            }

            System.out.println(status + " 수강생의 필수과목 평균 등급 : " + CalculateRequiredSubjectGrade.getGrade(sum/cnt));
            break;
        }
    }
}
