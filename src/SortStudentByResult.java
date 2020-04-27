import java.util.Comparator;
public class SortStudentByResult implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2){
        if (student1.getResult() > student2.getResult()){
            return 1;
        }
        return -1;
    }
}
