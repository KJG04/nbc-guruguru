import java.util.Objects;

public class ScoreKey {
    private final int subjectId;
    private final int studentId;
    private final int round;

    public ScoreKey(int subjectId, int studentId, int round) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.round = round;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ScoreKey sc)) return false;
        return sc.subjectId == subjectId && sc.studentId == studentId && sc.round == round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, studentId, round);
    }
}
