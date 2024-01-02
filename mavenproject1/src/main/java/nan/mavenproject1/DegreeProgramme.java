
package nan.mavenproject1;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.simple.JSONArray;

/**
 *
 * @author aksel
 */
public class DegreeProgramme {
    
    private String id;
    private String name;
    private String minCredit;
    private Map<Integer, ArrayList<String>> data;
    private ArrayList<String> kokeilu;
    private JSONArray obj;
    

    public DegreeProgramme(String id, String name, String minCredit) {
        this.id = id;
        this.name = name;
        this.minCredit = minCredit;
        this.data = new TreeMap<>();
        this.kokeilu = new ArrayList<>();
        this.obj = new JSONArray();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, ArrayList<String>> getData() {
        return data;
    }

    public String getMinCredit() {
        return minCredit;
    }

    public ArrayList<String> getKokeilu() {
        return kokeilu;
    }

    public JSONArray getObj() {
        return obj;
    }
   
}
