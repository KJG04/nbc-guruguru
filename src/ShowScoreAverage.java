import java.util.HashMap;
import java.util.Map;

public class ShowScoreAverage implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication) {
        Map<Integer, Integer[]> avgScoreMap = new HashMap<>();

        if(managementApplication.getScoreMap().isEmpty()){
            System.out.println("등록된 점수가 존재하지 않습니다.");
        }

        for(Score score : managementApplication.getScoreMap().values()){
            Integer[] defaultValue = {0, 0};
            Integer[] tmp = avgScoreMap.getOrDefault(score.getSubNo(), defaultValue);
            tmp[1]++;
            tmp[0] += score.getScore();
            avgScoreMap.put(score.getSubNo(), tmp);
        }

        for (Map.Entry<Integer, Integer[]> entry : avgScoreMap.entrySet()) {
            Integer key = entry.getKey();
            Integer[] value = entry.getValue();
            int avg = value[0] / value[1];

            System.out.println("===================");
            System.out.println("과목 번호 : " + key + "\n평균 등급 : " + GradeByScore.gradeByScore(key, avg));
            System.out.println("===================");
        }
    }
}
