public class ShowScore implements ManagementActionFunction{
    @Override
    public void action(ManagementApplication managementApplication) {
        if(managementApplication.getScoreMap().isEmpty()){
            System.out.println("등록된 점수가 존재하지 않습니다.");
        }
        for(Score score : managementApplication.getScoreMap().values()){
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
