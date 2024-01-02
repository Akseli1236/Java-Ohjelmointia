
package api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import org.json.simple.parser.JSONParser;



public class API {

    public static void main(String[] args) throws IOException{
        // TODO code application logic here
                  
        URL url = new URL("https://sis-tuni.funidata.fi/kori/api/module-search?curriculumPeriodId=uta-lvv-2021&universityId=tuni-university-root-id&moduleType=DegreeProgramme&limit=1000");
        
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        JSONParser parser = new JSONParser();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String line = "";
            line = br.readLine();
            String[] split = line.split("},");
            String[] word = Arrays.toString(split).split("\"");
            int i = 0;
            while(word.length > i){
                
                if (word[i].equals("id")){
                    //System.out.println(word[i+2]);
                    id(word, i);
                    
                    
                }
                if (word[i].equals("groupId")){
                    //System.out.println(word[i+2]);
                    //groupId(word,i);
                   
                    
                }
                i++;
            }   
        }
    }
    public static void id(String[] a, int i) throws IOException{
        URL id = new URL("https://sis-tuni.funidata.fi/kori/api/modules/" + a[i+2]);
        
            URLConnection conid = id.openConnection();
            InputStream isid = conid.getInputStream();
            try (BufferedReader brid = new BufferedReader(new InputStreamReader(isid))){
                String lineid = "";
                lineid = brid.readLine();
                //System.out.println(lineid);
                String[] split = lineid.split("},");
                String[] word = Arrays.toString(split).split("\"");
                int b = 0;
                String name = "";
                while(word.length > b){

                    if (word[b].equals("ModuleRule")){
                        
                        groupId(word, b+6,0);
                    }
                    if (word[b].equals("name")){
                        System.out.println(word[b+4]);
                        
                        //System.out.println(word[b+8]);
                    }
                    b++;
                    
                }
                
                
            }
            
                    
    }
    public static void groupId(String[] b,int i,int layer) throws IOException{
        URL id = new URL("https://sis-tuni.funidata.fi/kori/api/modules/by-group-id?groupId=" +b[i+2]+ "&universityId=tuni-university-root-id");
        layer += 1;
            URLConnection conid = id.openConnection();
            InputStream isid = conid.getInputStream();
            try (BufferedReader brid = new BufferedReader(new InputStreamReader(isid))){
                String lineid = "";
                lineid = brid.readLine();
                String[] split = lineid.split("},");
                String[] word = Arrays.toString(split).split("\"");
                int c = 0;
                
                String lisa = "-";
                String nuoli = lisa.repeat(layer)+">";
                while(word.length > c){
                    if (word[c].equals("ModuleRule")){
                        
                        
                        groupId(word, c+6,layer);
                    }
                    if (word[c].equals("courseUnitGroupId")){
                        
                        
                        courseUnitId(word, c,layer);
                    }
                    if (word[c].equals("name")){
                        System.out.println(nuoli +word[c+4]);
                        //System.out.println(word[c+8]);
                    }
                    c++;
                }
                
            }

    }
    public static void courseUnitId(String[] b, int i, int layer) throws IOException{
        URL id = new URL("https://sis-tuni.funidata.fi/kori/api/course-units/by-group-id?groupId=" + b[i+2] + "&universityId=tuni-university-root-id");
        layer += 1;
        URLConnection conid = id.openConnection();
        InputStream isid = conid.getInputStream();
        try (BufferedReader brid = new BufferedReader(new InputStreamReader(isid))){
            /*
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new InputStreamReader(isid));
            
            for (Object o:a){
                JSONObject person = (JSONObject) o;
                String name = (String) person.get("name");
                System.out.println(name);
            }
*/
            String name = "";
            String lineid;
            lineid = brid.readLine();
            String[] split = lineid.split("},");
            String[] word = Arrays.toString(split).split("\"");
            int c = 0;
            String lisa = "-";
            String nuoli = lisa.repeat(layer)+">";
            while(word.length > c){

                if (word[c].equals("courseUnitGroupId")){
                    
                    //System.out.println();
                    if (!name.equals("")){
                        courseUnitId(word,c,layer);
                    }
                    
                }
                if (word[c].equals("name")){
                    name = word[c+4];
                    System.out.println(nuoli+ ">" +word[c+4]);
                    //System.out.println(word[c+8]);
                }
                c++;
            }

        }
        
        

    }
    
}
