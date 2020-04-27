import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choose;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;
        showMenu();
        while (true){
            choose = sc.nextLine();
            switch (choose){
                case "1":
                    studentManager.add();
                    break;
                case "2":
                    studentId = studentManager.inputId();
                    studentManager.delete(studentId);
                    break;
                case "3":
                    studentId = studentManager.inputId();
                    studentManager.edit(studentId);
                    break;
                case "4":
                    studentManager.sortStudentByName();
                    break;
                case "5":
                    studentManager.sortStudentByResult();
                    break;
                case "6":
                    studentManager.show();
                    break;
                case "7":
                    studentManager.writeText();
                    break;
                case "0":
                    System.out.println("Thoát");
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ \n" +
                            "Mời chọn lại: ");
                    break;
            }
            if (exit){
                break;
            }
            showMenu();
        }
    }
    public static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Thêm học viên.");
        System.out.println("2. Xóa học viên.");
        System.out.println("3. Sửa học viên.");
        System.out.println("4. Sắp xếp học viên theo tên.");
        System.out.println("5. Sắp xếp học viên theo kết quả.");
        System.out.println("6. Xem danh sách học viên.");
        System.out.println("7. Cập nhật danh sách học viên sang dạng text.");
        System.out.println("0. Thoát.");
        System.out.print("Nhập: ");
    }
}
