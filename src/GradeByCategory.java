public class GradeByCategory {
    public static int gradeByCategory(int subNo) {
        if(subNo <= 5){
            return 1;
        }
        else if(subNo <= 10){
            return 2;
        }
        return 0;
    }

    public static char gradeByScore(int gradeType, int score) {
        switch (gradeType) {
            case 1:
                if(score >= 95) return 'A';
                else if(score >= 90) return 'B';
                else if(score >= 80) return 'C';
                else if(score >= 70) return 'D';
                else if(score >= 60) return 'F';
                else return 'N';
            case 2 :
                if(score >= 90) return 'A';
                else if(score >= 80) return 'B';
                else if(score >= 70) return 'C';
                else if(score >= 60) return 'D';
                else if(score >= 50) return 'F';
                else return 'N';
            case 0 :
                return 'N';
        }
        return 'N';
    }
}
