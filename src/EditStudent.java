import java.util.*;

public class EditStudent implements ManagementActionFunction {

    @Override
    public void action(ManagementApplication managementApplication) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> studentMap = managementApplication.getStudentMap();

        // 학생 ID 입력 받기
        System.out.print("수정할 수강생의 ID를 입력해주세요 : ");
        int idToChange = scanner.nextInt();
        scanner.nextLine();

        Student student = (Student) studentMap.get(idToChange);
        if (student != null) {
            System.out.println("새로 바꿀 이름을 입력해주세요 : ");
            String name = scanner.nextLine();

            student.setName(name);
            System.out.println("수강생의 이름이 수정되었습니다 : " + name);
        } else {
            System.out.println("ID가 " + idToChange + "인 수강생의 정보가 없습니다.");
        }



    }
}
