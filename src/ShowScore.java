public class ShowScore implements ManagementActionFunction{
    @Override
    public void action(ManagementApplication managementApplication) {
        managementApplication.scoreManage.showScore();
    }
}
