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
        setScore(score);
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

    public void setSubNo(int subNo) {
        this.subNo = subNo;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setScore(int score) {
        this.score = score;
        setGrade(score);
    }

    public void setGrade(int score) {
        if(score >= 95 && score <= 100) {
            this.grade = 'A';
        }
        else if(score >= 90 && score <= 94) {
            this.grade = 'B';
        }
        else if(score >= 80 && score <= 89) {
            this.grade = 'C';
        }
        else if(score >= 70 && score <= 79) {
            this.grade = 'D';
        }
        else if(score >= 60 && score <= 69) {
            this.grade = 'F';
        }
        else {
            this.grade = 'N';
        }
    }
}
