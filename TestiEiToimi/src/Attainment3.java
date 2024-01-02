
public class Attainment3
    implements Comparable
{

    public Attainment3(String s, String s1, int i)
    {
        if(s == null || s1 == null || i < 0 || i > 5)
        {
            throw new IllegalArgumentException("Invalid course code, student number or grade!");
        } else
        {
            courseCode = s;
            studentNumber = s1;
            grade = i;
            return;
        }
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public String getStudentNumber()
    {
        return studentNumber;
    }

    public int getGrade()
    {
        return grade;
    }

    public String toString()
    {
        return String.format("%s, %s, %d", new Object[] {
            courseCode, studentNumber, Integer.valueOf(grade)
        });
    }

    public int compareTo(Attainment3 attainment)
    {
        int i = studentNumber.compareTo(attainment.studentNumber);
        if(i == 0)
            i = courseCode.compareTo(attainment.courseCode);
        return i;
    }

    public int compareTo(Object obj)
    {
        return compareTo((Attainment)obj);
    }

    private final String courseCode;
    private final String studentNumber;
    private final int grade;
}
