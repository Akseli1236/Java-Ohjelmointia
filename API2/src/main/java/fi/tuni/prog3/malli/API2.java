package fi.tuni.prog3.malli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API2 {

    public static void main(String[] args) throws IOException, ParseException {
        URL url = new URL("https://sis-tuni.funidata.fi/kori/api/module-search?curriculumPeriodId=uta-lvv-2021&universityId=tuni-university-root-id&moduleType=DegreeProgramme&limit=1000");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        JSONParser parser = new JSONParser();
        Map<String, DegreeProgramme> data = new TreeMap<>();
        
        String line = Try(is);
        JSONObject json = (JSONObject) parser.parse(line);
        JSONArray json2 = (JSONArray) json.get("searchResults");
        for (var a :json2){
            JSONObject json4 = (JSONObject) a;
            String name = json4.get("name").toString();
            String id = json4.get("id").toString();
            JSONObject credits = (JSONObject) json4.get("credits");
            System.out.println(name + " " +credits.get("min") + "op");
            data.put(name, new DegreeProgramme(id,name,credits.get("min").toString()));
        }
        while (true){
            
            Scanner sc = new Scanner(System.in,"Cp850");
            //Scanner sc = new Scanner(System.in,"ISO-8859-1");
            String name = sc.nextLine();
            if (name.equals("break")){
                break;
            }
            System.out.println("\n"+name);
            if (data.get(name).getKokeilu().isEmpty()){
                id2(data.get(name).getId(), data ,name);
            }
            print(data.get(name));
        }
    }
    public static void print(DegreeProgramme Data){
        for (var entry : Data.getKokeilu()){
            String nuoli = "-".repeat(Integer.parseInt(String.valueOf(entry.charAt(0)))) +">";
            System.out.println(nuoli + entry.substring(1));
        }
        
    }
    public static void id2(String id, Map data, String name_) throws IOException, ParseException{
        URL idi = new URL("https://sis-tuni.funidata.fi/kori/api/modules/" + id);
        URLConnection conid = idi.openConnection();
        InputStream isid = conid.getInputStream();
        
        JSONParser parser = new JSONParser();
        //System.out.println(data);
        String lineid = Try(isid);
        JSONObject json = (JSONObject) parser.parse(lineid);

        JSONObject loopObj = (JSONObject) json.get("rule");
        loopObj(loopObj,(DegreeProgramme) data.get(name_),0);
        
    }
    public static void groupId2(String idi, int layer, DegreeProgramme data) throws IOException, ParseException{
        URL id = new URL("https://sis-tuni.funidata.fi/kori/api/modules/by-group-id?groupId=" + idi + "&universityId=tuni-university-root-id");
        layer += 1;
        URLConnection conid = id.openConnection();
        InputStream isid = conid.getInputStream();
        
        readData(isid, layer, data);
        
    }
    public static void courseUnitId2(String id, int layer, DegreeProgramme data) throws IOException, ParseException{
        URL idi = new URL("https://sis-tuni.funidata.fi/kori/api/course-units/by-group-id?groupId=" + id + "&universityId=tuni-university-root-id");
        
        layer += 1;
        URLConnection conid = idi.openConnection();
        InputStream isid = conid.getInputStream();
        
        readData(isid, layer, data);
        
    }
    public static String Try(InputStream isid) throws IOException{
        try (BufferedReader brid = new BufferedReader(new InputStreamReader(isid))){ 
            return brid.readLine();
        }
        
    }
    public static void readData(InputStream isid, int layer, DegreeProgramme data) throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        String lineid = Try(isid);
        //String nuoli = "-".repeat(layer) +">";

        JSONArray json = (JSONArray) parser.parse(lineid);
        JSONObject json2 = (JSONObject) json.get(0);
        JSONObject name = (JSONObject) json2.get("name");
        //System.out.println((JSONObject) json2.get("credits"));
        JSONObject credits = null;
        if (json2.get("credits") != null){
            credits = (JSONObject) json2.get("credits");
        }else if (json2.get("targetCredits") != null){
            credits = (JSONObject) json2.get("targetCredits");
        }
        addData(data, name, credits, layer);
        
        JSONObject loopObj = (JSONObject) json2.get("rule");
        
        loopObj(loopObj,data,layer);

         
    }
    public static void loopObj(JSONObject loopObj, DegreeProgramme data, int layer) throws IOException, ParseException{
        if (loopObj != null){
            int a = 0;
            String[] split = loopObj.toString().split("\"");
            while (a < split.length){
                if (split[a].equals("moduleGroupId")){
                    groupId2(split[a+2],layer, data);
                }else if (split[a].equals("courseUnitGroupId")){
                    courseUnitId2(split[a+2],layer, data);
                }
                a++;
            }
        }
    }
    
    public static void addData(DegreeProgramme data, JSONObject name,JSONObject credit, int layer){
        
        if (name != null){
                    //String nuoli = "-".repeat(layer) +">";
                    String arvo;
                    if (name.get("fi") != null){
                        arvo = name.get("fi").toString();
                    }else{
                        arvo = name.get("en").toString();
                    }
                    if (credit != null){
                        arvo += " " +credit.get("min")  + " op";
                    }
                    //System.out.println(nuoli + arvo);
                    data.getKokeilu().add(String.valueOf(layer) +arvo);

                }
        
    }
}