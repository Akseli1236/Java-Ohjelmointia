
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;


public class Dates {

    public static class DateDiff {
        private String start;
        private String end;
        private int diff;


        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }

        public int getDiff() {
            return diff;
        }
        
        private DateDiff(String start, String end, int diff) {
            this.start = start;
            this.end = end;
            this.diff = diff;
        }

        @Override
        public String toString() {
            String[] s = this.start.split("-");
            String[] e = this.end.split("-");
            String startT = s[2] + "." + s[1] + "." + s[0];
            String endD = e[2] + "." + e[1] + "." + e[0];
            LocalDate localdateS = LocalDate.of(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            LocalDate localdateE = LocalDate.of(Integer.parseInt(e[0]),Integer.parseInt(e[1]),Integer.parseInt(e[2]));
            
            
            return localdateS.getDayOfWeek().toString().substring(0,1) + localdateS.getDayOfWeek().toString().substring(1, localdateS.getDayOfWeek().toString().length()).toLowerCase() + " " + startT + " --> "+ localdateE.getDayOfWeek().toString().substring(0,1) + localdateE.getDayOfWeek().toString().substring(1, localdateE.getDayOfWeek().toString().length()).toLowerCase() + " " + endD + ": " + diff + " days";
        }  
    }
    
    public static DateDiff[] dateDiffs(String ...dateStrs){
        ArrayList<LocalDate> date = new ArrayList<>();
        //System.out.println(date1[1]);
        for (String dateStr : dateStrs) {
            try {
                if (dateStr.contains(".")){
                    String[] k = dateStr.split("\\.");
                    
                    LocalDate localdate = LocalDate.of(Integer.parseInt(k[2]),Integer.parseInt(k[1]),Integer.parseInt(k[0]));
                    if (k[2].length() == 4){
                        date.add(localdate);
                    }else{
                        System.out.format ("The date %s is illegal!%n",'"' + dateStr + '"');
                    }
                }else{
                    if (dateStr.length() == 10){
                        String[] k = dateStr.split("-");
                        LocalDate localdate = LocalDate.of(Integer.parseInt(k[0]),Integer.parseInt(k[1]),Integer.parseInt(k[2]));
                        date.add(localdate);
                    }else{
                        System.out.format ("The date %s is illegal!%n",'"' + dateStr + '"');
                    }
                } 
            }
            catch(Exception e){
                System.out.format ("The date %s is illegal!%n",'"' + dateStr + '"');
            }
        }
        Collections.sort(date);
        DateDiff[] name = new DateDiff[date.size()-1];
        for (int ka = 0; ka < date.size()-1; ka++){
            long diff = date.get(ka).until(date.get(ka+1),ChronoUnit.DAYS);
            name[ka] = new DateDiff(date.get(ka).toString(),date.get(ka+1).toString(), (int)diff);
        }
        return name;
    }
}
