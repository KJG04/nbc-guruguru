import java.util.Scanner;

public class ReplaceScore implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication){
        Scanner sc = new Scanner(System.in);
        System.out.println("[점수를 수정할 수강생 번호를 입력해주세요.]");
        System.out.print("학생 고유 번호 : ");
        int stdNo = sc.nextInt();
        sc.nextLine();
        System.out.println("[점수를 수정할 과목 번호를 입력해주세요.]");
        System.out.print("과목 고유 번호 : ");
        int subNo = sc.nextInt();
        sc.nextLine();
        System.out.println("[점수를 수정할 회차를 입력해주세요.]");
        System.out.print("회차 : ");
        int term = sc.nextInt();
        sc.nextLine();
        System.out.println("[새롭게 등록할 점수를 입력해주세요.]");
        System.out.print("점수 : ");
        int score = sc.nextInt();
        sc.nextLine();
        Score scoreSub = new Score(stdNo, subNo, term, score);


        if(managementApplication.scoreMap.containsKey(scoreSub.hashCode())){
            managementApplication.scoreMap.put(scoreSub.hashCode(), scoreSub);
        }
    }
}
