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
        System.out.print("점수 : ");
        int score = sc.nextInt();
        sc.nextLine();
        System.out.print("회차 : ");
        int term = sc.nextInt();
        sc.nextLine();

        Score subScore = new Score(subNo, stdNo, term, score);
        ScoreManage.addScore(subScore);
    }
}
