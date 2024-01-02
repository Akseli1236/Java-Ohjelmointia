/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.sisu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author akseli
 */
//Rajapinta tiedon hakemiseen ja tallentamiseen
public interface interFaceAPI {
    public void id(String id, Map data, String name) throws IOException, ParseException;
    public void groupId(String idi, int layer, DegreeProgramme data) throws IOException, ParseException;
    public void courseUnitId(String id, int layer, DegreeProgramme data) throws IOException, ParseException;
    public String Try(InputStream isid) throws IOException;
    public void readData(InputStream isid, int layer, DegreeProgramme data) throws IOException, ParseException;
    public void loopObj(JSONObject loopObj, DegreeProgramme data, int layer) throws IOException, ParseException;
    public void addDataJson(JSONObject name,JSONObject credit, int layer, JSONArray obj);
    public String getNameAndCredits(JSONObject name,JSONObject credit);
}
