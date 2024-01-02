
public class DateTime extends Date{
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public DateTime(int year, int month, int day, int hour, int minute, int second) throws DateException {
        super(year,month,day);
        if (hour < 0 || hour > 23 || minute > 59 || minute < 0 || second > 59 || second < 0){
            throw new DateException("Illegal time " + hour + ":" + minute + ":" + second);
        }else{
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        
        
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        String str = " ";
        
        if (hour < 10){
            str += 0 + Integer.toString(hour) + ":";
        }else{
            str += Integer.toString(hour) + ":";
        }
        
        if (minute < 10){
            str += 0 + Integer.toString(minute) + ":"; 
        }else{
            str +=Integer.toString(minute) + ":"; 
        }
        
        if (second < 10){
            str += 0 + Integer.toString(second); 
        }else{
            str +=Integer.toString(second);
        }
        return super.toString() + str;

    }
    
    
}
