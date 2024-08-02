import java.util.*;

public class AddStudent implements ManagementActionFunction{
    @Override
    public void action(ManagementApplication managementApplication){

        Scanner scanner = managementApplication.getScanner();

        System.out.print("수강생의 고유번호를 입력해주세요 : ");
        int stdNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("이름을 입력하세요 : ");
        String stdName = scanner.nextLine();
        System.out.println("과목번호를 입력해주세요 : ");
        int subNo = scanner.nextInt();
        scanner.nextLine();
        Subject subject = Subject.getSubjectById(subNo);

        List<Subject> subjects = new ArrayList<>(Collections.singleton(subject));

        Student student = new Student(stdNo, stdName, subjects);

        managementApplication.getStudentMap().put(stdNo, student);
    }


}