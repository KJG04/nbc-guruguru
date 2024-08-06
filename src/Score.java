import java.util.Objects;

public class Score {
    private int subNo;
    private int stdNo;
    private int term;
    private int score;
    private char grade;

    public Score(int stdNo, int subNo, int term, int score) {
        this.subNo = subNo;
        this.stdNo = stdNo;
        this.term = term;
        this.score = score;
        this.grade = GradeByCategory.gradeByScore(Subject.getSubjectById(subNo).getGradeType(), score);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Score sc)) return false;
        return sc.getSubNo() == this.subNo && sc.getStdNo() == this.stdNo && sc.getTerm() == this.term;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subNo, stdNo, term);
    }


    public int getSubNo() {
        return subNo;
    }
    public int getStdNo() {
        return stdNo;
    }
    public int getTerm() {
        return term;
    }
    public int getScore() {
        return score;
    }
    public char getGrade() {
        return grade;
    }
}
