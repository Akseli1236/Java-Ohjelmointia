/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fi.tuni.prog3.sisu.aaa;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aksel
 */
public class Aaa {

    public static void main(String[] args) {
        List<Course> courses = readDirectoryToType("json\\courseunits\\", new Course());
        List<Module> modules = readDirectoryToType("json\\modules", new Module());
        /*
        if (courses == null || courses.isEmpty()){
            System.out.println("Tyhjät kurssit");
        }else {
            for (Course course : courses) {
                System.out.println(course.getCode() + "," + course.getName() + ", " + course.getId());
            }
        }
        System.out.println("\n \n");
        if (modules == null || modules.isEmpty()){
            System.out.println("Tyhjät moduulit");
        }else {
            for (Module module : modules) {
                System.out.println(module.getCode() + "," + module.getName() + ", " + module.getId());
            }
        }
        */
        System.out.println(courses.size());
        
    }
    public static <T> List<T> readDirectoryToType(String path, T type){
        List<T> items = new ArrayList<>();
        Gson gson = new Gson();
        File dir = new File(path);
        File[] directoryListing = dir.listFiles();
        System.out.println(Arrays.toString(directoryListing));
        if (directoryListing != null) {
            for (File child : directoryListing) {
                try {
                    JsonReader reader = new JsonReader(new FileReader(child));
                    T course = gson.fromJson(reader, type.getClass());
                    items.add(course);
                }catch (FileNotFoundException ignored){

                }
            }
        } else {
            return null;
        }
        return items;
    }

}
