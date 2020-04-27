import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListStudent {
    private static String FILE_LIST_STUDENT = "C:\\Gin\\module 2\\Casestudy 2\\quan li hoc vien\\src\\student.dat";
    public void write(List<Student> studentList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            File file = new File(FILE_LIST_STUDENT);
            if (!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(FILE_LIST_STUDENT);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    fos.close();
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeText(List<Student> studentList){
        try {
            FileWriter fileWriter = new FileWriter("student.txt");
            for (Student student : studentList){
                fileWriter.write(student.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Student> read() {
        List<Student> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(FILE_LIST_STUDENT);
            ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("không tìm thấy " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Thấy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}