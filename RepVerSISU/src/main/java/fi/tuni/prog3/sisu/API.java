
package fi.tuni.prog3.sisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.TreeMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API implements interFaceAPI{

    //Luo mapin kaikista opintokokonaisuuksista

    /**
     *
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public Map<String, DegreeProgramme> main() throws IOException, ParseException  {
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
            data.put(name, new DegreeProgramme(id,name,credits.get("min").toString()));
        }
        return data;
    }
    
    //Hakee opintokokonaisuuden tiedot
    @Override
    public void id(String id, Map data, String name) throws IOException, ParseException{
        URL idi = new URL("https://sis-tuni.funidata.fi/kori/api/modules/" + id);
        URLConnection conid = idi.openConnection();
        InputStream isid = conid.getInputStream();
        
        
        JSONParser parser = new JSONParser();
        String lineid = Try(isid);
        JSONObject json = (JSONObject) parser.parse(lineid);

        JSONObject loopObj = (JSONObject) json.get("rule");
        loopObj(loopObj,(DegreeProgramme) data.get(name),0);
        
    }
    //Hakee moduulin tiedot
    @Override
    public void groupId(String idi, int layer, DegreeProgramme data) throws IOException, ParseException{
        URL id = new URL("https://sis-tuni.funidata.fi/kori/api/modules/by-group-id?groupId=" + idi + "&universityId=tuni-university-root-id");
        layer += 1;
        URLConnection conid = id.openConnection();
        InputStream isid = conid.getInputStream();
        readData(isid, layer, data);
        
    }
    //Hakee kurssin tiedot

    
    @Override
    public void courseUnitId(String id, int layer, DegreeProgramme data) throws IOException, ParseException{
        URL idi = new URL("https://sis-tuni.funidata.fi/kori/api/course-units/by-group-id?groupId=" + id + "&universityId=tuni-university-root-id");
        layer += 1;
        URLConnection conid = idi.openConnection();
        InputStream isid = conid.getInputStream();
        readData(isid, layer, data);
        
    }
    //Testaa onko URLista saatu InputStream kunnollinen
    @Override
    public String Try(InputStream isid) throws IOException{
        try (BufferedReader brid = new BufferedReader(new InputStreamReader(isid))){ 
            return brid.readLine();
        }
        
    }
    //Lukee tiedot joko kurssista tai moduulista
    @Override
    public void readData(InputStream isid, int layer, DegreeProgramme data) throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        String lineid = Try(isid);

        JSONArray json = (JSONArray) parser.parse(lineid);
        JSONObject json2 = (JSONObject) json.get(0);
        JSONObject name = (JSONObject) json2.get("name");
        JSONObject credits = null;
        
        if (json2.get("credits") != null){
            credits = (JSONObject) json2.get("credits");
        }else if (json2.get("targetCredits") != null){
            credits = (JSONObject) json2.get("targetCredits");
        }
        addDataJson(name,credits,layer,data.getObj());
        
        JSONObject loopObj = (JSONObject) json2.get("rule");
        loopObj(loopObj,data,layer);

         
    }
    //Käy läpi kurssin tai moduulin groupId:n ja lähettää sen tiedon luettavaksi
    @Override
    public void loopObj(JSONObject loopObj, DegreeProgramme data, int layer) throws IOException, ParseException{
        if (loopObj != null){
            int a = 0;
            String[] split = loopObj.toString().split("\"");
            while (a < split.length){
                if (split[a].equals("moduleGroupId")){
                    groupId(split[a+2],layer, data);
                }else if (split[a].equals("courseUnitGroupId")){
                    courseUnitId(split[a+2],layer, data);
                }
                a++;
            }
        }
    }
    
    //Lisää löydetyt tiedot ylös myöhempää kayttöä varten.
    @Override
    public void addDataJson(JSONObject name,JSONObject credit, int layer, JSONArray obj){
        JSONObject newObject = new JSONObject();
        if (name != null){
                String nameAndCredit = getNameAndCredits(name, credit);
                if (layer == 1){
                    newObject.put(nameAndCredit, new JSONArray());
                    obj.add(newObject);
                }else{
                    layer--;
                    newObject = (JSONObject) obj.get(obj.size()-1);
                    JSONArray nextJSONObject = new JSONArray();
                    for (var a : newObject.keySet()){
                        if (newObject.get(a) != null){
                            nextJSONObject = (JSONArray) newObject.get(a);
                        }
                    }
                    addDataJson(name,credit,layer, nextJSONObject);
                }
        }                    
    }
    
    @Override
    public String getNameAndCredits(JSONObject name,JSONObject credit){
        String nameAndCredit;
        if (name.get("fi") != null){
                    nameAndCredit = name.get("fi").toString();
                }else{
                    nameAndCredit = name.get("en").toString();
                }
                if (credit != null){
                    nameAndCredit += " " +credit.get("min")  + " op";
                }
        return nameAndCredit;
    }
}