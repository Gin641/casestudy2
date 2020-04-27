import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private byte age;
    private double result;
    public Student(){
    }
    public Student(int id, String name, byte age, double result){
        this.id=id;
        this.name=name;
        this.age=age;
        this.result=result;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getResult() {
        return result;
    }
    public byte getAge() {
        return age;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(byte age) {
        this.age = age;
    }
    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "id=" + id + " | " +
                "name= " + name + " | " +
                "age= " + age + " | " +
                "result= " + result;
    }
}
