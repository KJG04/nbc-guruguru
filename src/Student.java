import java.util.List;

public class Student {
    private int stdNo;
    private String name;
    private List<String> subList;

    public Student(int stdNo, String name, List<String> subList) {
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

    public List<String> getSubList() {
        return subList;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubList(List<String> subList) {
        this.subList = subList;
    }
}
