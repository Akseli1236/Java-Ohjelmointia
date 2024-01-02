import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class StudentRegister {
    
    private ArrayList<Course> Courses = new ArrayList<>();
    private ArrayList<Student> Students = new ArrayList<>();
    private ArrayList<Attainment> Attainments = new ArrayList<>();

    public StudentRegister() {
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public ArrayList<Student> getStudents() {
        return Students;
    }
    
    public void addStudent(Student student){
        
        int i = 0;
        while (true){
            if (Students.isEmpty()){
                Students.add(student);
                break;
            }else if (Students.get(i).getName().compareTo(student.getName()) > 0){
                Students.add(i,student);
                break;
            }else{
                i++;
                if (i == Students.size()){
                    Students.add(student);
                    break;
                }
            }
        }
        
    }
    public void addCourse(Course course){
        
        int i = 0;
        while (true){
            if (Courses.isEmpty()){
                Courses.add(course);
                break;
            }else if (Courses.get(i).getName().compareTo(course.getName()) > 0){
                Courses.add(i,course);
                break;
            }else{
                i++;
                if (i == Courses.size()){
                    Courses.add(course);
                    break;
                }
            }
        }
    }
    
    public void addAttainment(Attainment att){
        Attainments.add(att);
    }
    
    public void printStudentAttainments(String studentNumber, String order){
        ArrayList<String> inta = new ArrayList<>();
        ArrayList<String> into = new ArrayList<>();
        ArrayList<Integer> agrade = new ArrayList<>();
        
        ArrayList<String> inte = new ArrayList<>();
        for (var p : Students){
            if (p.getStudentNumber().equals(studentNumber)){
                System.out.println(p.getName() + " (" + p.getStudentNumber() + "):" );
            }
        }
        int i = 0;
        int as = 0;
        if (order.equals("by name")){
            for (var a : Attainments){
                if (a.getStudenNumber().equals(studentNumber)){
                    for (var b : Courses){
                        if (b.getCode().equals(a.getCourseCode())){
                            inta.add(b.getName()+ "&" + b.getCode() + "&" + a.getGrade());
                            //System.out.println(b.getName() + ": " + a.getGrade());
                        }
                    }
                }
            }
            Collections.sort(inta);
            
            for (int a = 0; a < inta.size(); a++){
                String[] alpha = inta.get(a).split("&");
                System.out.println("  " + alpha[1] + " " + alpha[0] + ": " + alpha[2]);
            }
            
        }else{
            
            for (var a : Attainments){
                if (a.getStudenNumber().equals(studentNumber)){
                    for (var b : Courses){
                        if (b.getCode().equals(a.getCourseCode())){
                            into.add(a.getCourseCode()+ "&" + b.getName() + "&" + a.getGrade());
                        }
                    }
                }
            }
            Collections.sort(into);
            
            for (int a = 0; a < into.size(); a++){
                String[] alpha2 = into.get(a).split("&");
                System.out.println("  " + alpha2[0] + " " + alpha2[1] + ": " + alpha2[2]);
            }
        } 
    }
    
    public void printStudentAttainments(String studentNumber){
        int i = 0;
        for (var p : Students){
            if (p.getStudentNumber().equals(studentNumber)){
                System.out.println(p.getName() + " (" + p.getStudentNumber() + "):" );
                i++;
            }
        }
        if (i == 0){
            System.out.println("Unknown student number: " + studentNumber);
            
        }else{
            for (var a : Attainments){
                if (a.getStudenNumber().equals(studentNumber)){
                    System.out.print("  "+a.getCourseCode() + " ");
                    for (var b : Courses){
                        if (b.getCode().equals(a.getCourseCode())){
                            System.out.println(b.getName() + ": " + a.getGrade());
                        
                        }
                    
                    }
                }
            }
        }
        
    }
}
