import java.util.Scanner;

public class AddScore implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 고유 번호 : ");
        int stdNo = sc.nextInt();
        sc.nextLine();
        System.out.print("과목 고유 번호 : ");
        int subNo = sc.nextInt();
        sc.nextLine();
        System.out.print("회차 : ");
        int term = sc.nextInt();
        sc.nextLine();
        System.out.print("점수 : ");
        int score = sc.nextInt();
        sc.nextLine();

        Score subScore = new Score(stdNo, subNo, term, score);

        if(!managementApplication.scoreMap.containsKey(subNo)){
            managementApplication.scoreMap.put(subScore.hashCode(), subScore);
            System.out.println("점수 등록 성공");
        }
    }
}
