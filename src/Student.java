import java.util.List;

public class Student {
    private int stdNo;
    private String name;
    private String state;
    private List<Subject> subList;

    public Student(int stdNo, String name, List<Subject> subList) {
        this.stdNo = stdNo;
        this.name = name;
        this.subList = subList;
    }

    public int getStdNo() {
        return stdNo;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public List<Subject> getSubList() {
        return subList;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) { this.state = state;}

    public void setSubList(List<Subject> subList) {
        this.subList = subList;
    }
}
