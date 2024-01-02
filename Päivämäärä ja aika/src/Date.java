
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) throws DateException{
        
        if (year < 0 || month > 12 || month < 0 || day > 31 || day < 0){
            throw new DateException("Illegal date " + day + "." + month + "." + year);
        }else if (month == 11 && day > 30){
            throw new DateException("Illegal date " + day + "." + month + "." + year);
        }else{
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        if (day < 10 && month < 10){
            return "0"+day + "." + "0"+ month + "." + year;
        }else if (month > 9 && day < 10){
            return "0"+ day + "." + month + "." + year;
        }else if (month < 10 && day > 9){
            return day + "." + "0"+ month + "." + year;
        }
        return day + "." + month + "." + year;
        
    }
    
    
}
