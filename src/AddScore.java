import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class AddScore implements ManagementActionFunction {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner sc = managementApplication.getScanner();

        while (true) {
            int stdNo;
            while (true) {
                try {
                    System.out.print("\n학생 고유 번호: ");
                    stdNo = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("번호를 입력해주세요.");
                    sc.nextLine();
                }
            }

            //학생 고유번호로 학생 객체 하나 받아오기.
            Student student = managementApplication.getStudentMap().get(stdNo);
            if (!Objects.nonNull(student)) {
                System.out.println(ANSI_RED + ANSI_RED + "존재하지 않는 학생입니다." + ANSI_RESET + ANSI_RESET);
                return;
            }

            int subNo;
            while (true) {
                try {
                    System.out.print("과목 고유 번호: ");
                    subNo = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + ANSI_RED + "번호를 입력해주세요." + ANSI_RESET + ANSI_RESET);
                    sc.nextLine();
                }
            }

            if (!Arrays.stream(Subject.values()).map(Subject::getSubId).toList().contains(subNo)) {
                System.out.println(ANSI_RED + ANSI_RED + "해당 번호의 과목이 존재하지 않습니다." + ANSI_RESET + ANSI_RESET);
                continue;
            }

            if (!student.getSubList().contains(Subject.getSubjectById(subNo))) {
                System.out.println(ANSI_RED + ANSI_RED + "해당 수강생이 수강하고 있지 않은 과목입니다." + ANSI_RESET + ANSI_RESET);
                continue;
            }

            int term;
            while (true) {
                try {
                    System.out.print("회차: ");
                    term = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "숫자를 입력해주세요." + ANSI_RESET);
                    sc.nextLine();
                }
            }

            if (term > 10) {
                System.out.println(ANSI_RED + "시험회차는 10회까지 존재합니다." + ANSI_RESET);
                continue;
            }

            ScoreKey scoreKey = new ScoreKey(stdNo, subNo, term);
            if (managementApplication.getScoreMap().containsKey(scoreKey)) {
                System.out.println(ANSI_RED + "이미 등록된 점수입니다." + ANSI_RESET);
                continue;
            }

            int score;
            while (true) {
                System.out.print("점수: ");
                try {
                    score = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "숫자를 입력해주세요." + ANSI_RESET);
                    sc.nextLine();
                }
            }

            if (score > 100 || score < 0) {
                System.out.println(ANSI_RED + "점수는 0~100점 범위 내에서 입력해주세요." + ANSI_RESET);
                continue;
            }

            Score subScore = new Score(stdNo, subNo, term, score);
            managementApplication.getScoreMap().put(scoreKey, subScore);
            System.out.println(ANSI_CYAN + "점수 등록이 완료되었습니다." + ANSI_RESET);
            break;
        }
    }
}
