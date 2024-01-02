
public class Course {

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getCredits() {
        return credits;
    }
    private String code;
    private String name;
    private Integer credits;

    public Course(String code, String name, Integer credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }
    
    
}
