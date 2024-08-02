import java.util.ArrayList;
import java.util.List;

public class ScoreManage {
    public static List<Score> scoreList = new ArrayList<>();
    public static void addScore(Score score){
        if(!scoreList.contains(score)) scoreList.add(score);
        // 과목번호, 학생번호, 회차가 전부 동일한게 존재하면 패스
        // 아닐 경우 회차와 점수 범위 체크
        // 점수 등록할 경우 등급 구분 정보 조회해서 자동으로 등급 추가 저장
    }

    public static void replaceScore(Score score) {
        //리스트 조회해서 해당 요소 찾아서 수정
        if(scoreList.contains(score)){
            scoreList.set(scoreList.indexOf(score), score);
        }
    }

    public static void showScore() {
        //리스트 조회
        //과목별 조회도 어떻게 할지 설계하기.
        //과목별 평균 등급 조회
        //특정 상태 수강생 필수 과목 평균 등급 조회
        for(Score score : scoreList){
            System.out.println("===================\n"
                    + "학생 고유 번호 : " + score.getStdNo()
                    + "\n과목 고유 번호 : " + score.getSubNo()
                    + "\n회차 : " + score.getTerm()
                    + "\n점수 : " + score.getScore()
                    + "\n등급 : " + score.getGrade()
                    + "\n==================="
            );
        }
    }

}
