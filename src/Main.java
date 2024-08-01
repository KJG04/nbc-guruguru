import java.util.InputMismatchException;
import java.util.Scanner;


// Student 클래스 작동 확인을 위한 임시 Main

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, choice2;
        boolean flag;
        String studentId;
        Student student;

        while (true) {
            System.out.println("학생 관리 시스템");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 수강생 세부 조회");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                scanner.nextLine(); // 버퍼 비우기
                continue;
            }

            switch (choice) {
                case 1:
                    Student.createStudent();
                    break;

                case 2:
                    Student.viewStudents();
                    break;

                case 3:
                    System.out.print("세부 조회할 수강생 ID 입력: ");
                    studentId = scanner.next();
                    student = Student.findStudentById(studentId);

                    flag = true;

                    while(flag){
                        Student.viewOneStudent(student);
                        System.out.println("1. 과목추가");
                        System.out.println("2. 상태변경");
                        System.out.println("3. 메인화면");
                        System.out.print("선택: ");

                        try {
                            choice2 = scanner.nextInt();
                            scanner.nextLine(); // 버퍼 비우기
                        } catch (InputMismatchException e) {
                            System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                            scanner.nextLine(); // 버퍼 비우기
                            continue;
                        }

                        switch(choice2) {
                            case 1:
                                System.out.println("선택과목: 디자인 패턴, Spring Security, Redis, MongoDB");
                                System.out.print("추가할 과목 입력: ");
                                String subject = scanner.nextLine();
                                student.addSubject(subject);
                                System.out.println();
                                break;

                            case 2:
                                System.out.print("새 상태 입력 (Green, Red, Yellow): ");
                                String newStatus = scanner.next();
                                student.changeStatus(newStatus);
                                System.out.println();
                                break;

                            case 3:
                                flag = false;
                                System.out.println();
                                break;

                            default:
                                System.out.println("잘못된 입력입니다.");
                                break;
                        }
                    }
                    break;


                case 4:
                    System.out.println("시스템을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }


}
