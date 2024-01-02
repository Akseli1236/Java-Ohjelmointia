
import java.util.Comparator;


public class Attainment implements Comparable<Attainment> {
    
    private String courseCode;
    private String studentNumber;
    private int grade;
    
    public static final Comparator<Attainment> CODE_STUDENT_CMP = (Attainment o1, Attainment o2) -> {
        int cmp = o1.getCourseCode().compareTo(o2.getCourseCode());
        
        if (cmp == 0){
            cmp = o1.getStudentNumber().compareTo(o2.getStudentNumber());
        }
        return cmp;
    };
    public static final Comparator<Attainment> CODE_GRADE_CMP = (Attainment o1, Attainment o2) -> {
        int cmp = o1.getCourseCode().compareTo(o2.getCourseCode());
        
        if (cmp == 0){
            cmp = String.valueOf(o1.getGrade()).compareTo(String.valueOf(o2.getGrade())) * -1;
        }
        return cmp;
    };

    @Override
    public int compareTo(Attainment o) {
        int cmp = this.getStudentNumber().compareTo(o.getStudentNumber());
        if (cmp == 0){
            cmp = this.getCourseCode().compareTo(o.getCourseCode());
        }
        return cmp;
            
        
    }
    
    public Attainment(String courseCode, String studentNumber, int grade) {
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
        
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return courseCode + " " + studentNumber + " " + grade + "\n";
    }
    
    
    
    
}
