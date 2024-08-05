public class ShowScore implements ManagementActionFunction{
    @Override
    public void action(ManagementApplication managementApplication) {
        for(Score score : managementApplication.scoreMap.values()){
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
