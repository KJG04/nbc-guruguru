import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReplaceScore implements ManagementActionFunction {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner sc = managementApplication.getScanner();
        System.out.println("\n[수정하기 위해 수강생 고유번호, 과목 고유번호, 회차를 공백으로 구분지어 입력해주세요.]");

        int stdNo;
        int subNo;
        int term;

        while (true) {
            String input;
            System.out.print("수강생_고유번호 과목_고유번호 회차: ");
            try {
                input = sc.nextLine().trim().replaceAll("\\s+", " ");
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "숫자를 입력해주세요." + ANSI_RESET);
                continue;
            }

            Integer[] inputNums = Arrays.stream(input.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            if (inputNums.length != 3) {
                System.out.println(ANSI_RED + "숫자 3개를 입력해주세요." + ANSI_RESET);
                continue;
            }
            stdNo = inputNums[0];
            subNo = inputNums[1];
            term = inputNums[2];

            if (!managementApplication.getScoreMap().containsKey(new ScoreKey(stdNo, subNo, term))) {
                System.out.println(ANSI_RED + "해당하는 점수 기록이 존재하지 않습니다." + ANSI_RESET);
                continue;
            }

            break;
        }

        int score;
        System.out.println("[새롭게 등록할 점수를 입력해주세요.]");
        while (true) {
            try {
                System.out.print("점수: ");
                score = sc.nextInt();
                sc.nextLine();

                if (score > 100 || score < 0) {
                    System.out.println(ANSI_RED + "점수는 0~100점 범위 내에서 입력해주세요." + ANSI_RESET);
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("[숫자를 입력해주세요.]");
                sc.nextLine();
            }
        }


        Score scoreSub = new Score(stdNo, subNo, term, score);
        ScoreKey scoreKey = new ScoreKey(stdNo, subNo, term);

        if (managementApplication.getScoreMap().containsKey(scoreKey)) {
            managementApplication.getScoreMap().put(scoreKey, scoreSub);
            System.out.println("[수정이 완료되었습니다.]");
        }
    }
}
