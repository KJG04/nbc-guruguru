public class ShowScoreAverage implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication) {
        ScoreManage.showScoreAverage();
    }
}
