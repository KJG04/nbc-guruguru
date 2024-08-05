import java.util.HashMap;
import java.util.Map;

public class ShowScoreAverage implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication) {
        Map<Integer, Integer[]> avgScoreMap = new HashMap<>();

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
            char grade;

            if(avg >= 95 && avg <= 100) {
                grade = 'A';
            }
            else if(avg >= 90 && avg <= 94) {
                grade = 'B';
            }
            else if(avg >= 80 && avg <= 89) {
                grade = 'C';
            }
            else if(avg >= 70 && avg <= 79) {
                grade = 'D';
            }
            else if(avg >= 60 && avg <= 69) {
                grade = 'F';
            }
            else {
                grade = 'N';
            }
            System.out.println("===================");
            System.out.println("과목 번호 : " + key + "\n평균 등급 : " + grade);
            System.out.println("===================");
        }
    }
}
