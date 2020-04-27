import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    Scanner sc = new Scanner(System.in);
    private List<Student> studentList;
    private ListStudent listStudent;
    public StudentManager(){
        listStudent = new ListStudent();
        studentList = listStudent.read();
    }

    public int inputId(){
        System.out.print("Nhập ID: ");
        while (true){
            try {
                int id = Integer.parseInt((sc.nextLine()));
                return id;
            }catch (NumberFormatException e){
                System.out.print("ID không hợp lệ! \n"
                +"Nhập lại ID: ");
            }
        }
    }

    private String inputName(){
        System.out.print("Nhập tên: ");
        return sc.nextLine();
    }

    private byte inputAge(){
        System.out.print("Nhập độ tuổi: ");
        while (true){
            try {
                byte age = Byte.parseByte(sc.nextLine());
                if (age < 0 && age > 100){
                    throw new NumberFormatException();
                }
                return age;
            }catch (NumberFormatException e){
                System.out.print("Độ tuổi không hợp lệ! \n" +
                        "Nhập lại độ tuổi: ");
            }
        }
    }

    private float inputResult(){
        System.out.print("Nhập kết quả: ");
        while (true){
            try {
                float result = Float.parseFloat(sc.nextLine());
                if (result < 0.0 & result > 10.0){
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e){
                System.out.print("Kết quả không hợp lệ! \n" +
                        "Nhập lại kết quả: ");
            }
        }
    }

    public void add(){
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("ID: " + id);
        String name = inputName();
        byte age = inputAge();
        double result = inputResult();
        Student student = new Student(id,name,age,result);
        studentList.add(student);
        listStudent.write(studentList);
    }

    public void delete(int id){
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size;i++){
            if (studentList.get(i).getId() == id){
                student = studentList.get(i);
                break;
            }
        }
        if (student != null){
            studentList.remove(student);
            listStudent.write(studentList);
        } else{
            System.out.println("ID: " + id + " Không có");
        }
    }

    public void edit(int id){
        boolean isExisted = false;
        int size = studentList.size();
        for (int i =0; i < size; i ++){
            if (studentList.get(i).getId() == id){
                isExisted = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setResult(inputResult());
                break;
            }
        }
        if (!isExisted){
            System.out.println("ID: " + id);
        }else {
            listStudent.write(studentList);
        }
    }

    public void writeText(){
        listStudent.writeText(studentList);
    }

    public void sortStudentByName(){
        Collections.sort(studentList, new SortStudentByName());
    }

    public void sortStudentByResult(){
        Collections.sort(studentList, new SortStudentByResult());
    }

    public void show(){
        for (Student student : studentList){
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%10.1f%n", student.getResult());
        }
    }
}
