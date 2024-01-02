
public class Attainment {
    private String courseCode;
    private String studenNumber;
    private Integer grade;

    public Attainment(String courseCode, String studenNumber, Integer grade) {
        this.courseCode = courseCode;
        this.studenNumber = studenNumber;
        this.grade = grade;
    }
    

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudenNumber() {
        return studenNumber;
    }

    public Integer getGrade() {
        return grade;
    }
    
    
}
