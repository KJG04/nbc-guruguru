public class ShowScoreAverage implements ManagementActionFunction {
    @Override
    public void action(ManagementApplication managementApplication) {
        managementApplication.scoreManage.showScoreAverage();
    }
}
