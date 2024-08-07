import java.util.Objects;

public class ScoreKey {
    private int stdNo;
    private int subNo;
    private int term;

    public ScoreKey(int stdNo, int subNo, int term) {
        this.stdNo = stdNo;
        this.subNo = subNo;
        this.term = term;
    }

    public int getStdNo() {
        return stdNo;
    }

    public int getSubNo() {
        return subNo;
    }

    public int getTerm() {
        return term;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ScoreKey scoreKey)) return false;
        return scoreKey.getStdNo() == this.stdNo && scoreKey.getSubNo() == this.getSubNo() && scoreKey.getTerm() == this.getTerm();
    }

    @Override
    public int hashCode() {
        return Objects.hash(subNo, stdNo, term);
    }
}
