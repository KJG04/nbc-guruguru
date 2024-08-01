public class Score {
    private int subNo;
    private int stdNo;
    private int term;
    private int score;
    private char grade;

    public Score(int subNo, int stdNo, int term, int score, char grade) {
        this.subNo = subNo;
        this.stdNo = stdNo;
        this.term = term;
        this.score = score;
        this.grade = grade;
    }

    public int getSubNo() {
        return subNo;
    }
    public void setSubNo(int subNo) {
        this.subNo = subNo;
    }
    public int getStdNo() {
        return stdNo;
    }
    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }
    public int getTerm() {
        return term;
    }
    public void setTerm(int term) {
        this.term = term;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public char getGrade() {
        return grade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }

}
