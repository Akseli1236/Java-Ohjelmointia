
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MovieAnalytics2 {
    private List<Movie> lista;
    
    public MovieAnalytics2() {
        this.lista = new ArrayList<>();
    }
    
    public void populateWithData(String fileName) throws IOException{
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            //file.lines().map(line -> line.split(";"));
            String a = "";
            file.lines().forEach((String name) ->{
                    String[] splits = name.split(";");
                    Movie temp = new Movie(splits[0],Integer.parseInt(splits[1]),Integer.parseInt(splits[2]),splits[3],Double.parseDouble(splits[4]),splits[5]);
                    lista.add(temp);
            });
            
            
        }catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    
    }
    
    public void printCountByDirector(int n){
        Map<String, List<String>> meh = new TreeMap<>();
        List<Integer> arvot = new ArrayList<>();
        lista.forEach((Movie elokuuva) ->{
            if (meh.isEmpty()){
                List<String> temp = new ArrayList<>();
                temp.add(elokuuva.getTitle());
                meh.put(elokuuva.getDirector(), temp);
            }else{
                try{
                    meh.get(elokuuva.getDirector()).add(elokuuva.getTitle());
                }catch (Exception e){
                    List<String> temp = new ArrayList<>();
                    temp.add(elokuuva.getTitle());
                    meh.put(elokuuva.getDirector(), temp);
                }
                
            }
            
        });
        Map<Integer, List<String>> nimet = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, List<String>> nimet2 = new TreeMap<>(Collections.reverseOrder());
        List<String> arvot2 = new ArrayList<>();
        
        
        
        
        meh.forEach((k, v) -> {
            arvot.add(v.size());
            if (meh.isEmpty()){
                List<String> temp = new ArrayList<>();
                temp.add(k);
                nimet.put(v.size(), temp);
            }else{
                try{
                    nimet.get(v.size()).add(k);
                }catch (Exception e){
                    List<String> temp = new ArrayList<>();
                    temp.add(k);
                    nimet.put(v.size(), temp);
                }
            }
            
        });
        
        Collections.sort(arvot, Collections.reverseOrder());
        
        nimet.forEach((k, v) -> {
           
           v.forEach((String name) ->{
               if (arvot2.size() == n){
                    return;
                }
                if (meh.isEmpty()){
                    List<String> temp = new ArrayList<>();
                    temp.add(name);
                    nimet2.put(k, temp);
                    arvot2.add(name);
                }else{
                    try{
                        nimet2.get(k).add(name);
                        arvot2.add(name);
                    }catch (Exception e){
                        List<String> temp = new ArrayList<>();
                        temp.add(name);
                        nimet2.put(k, temp);
                        arvot2.add(name);
                    }
            }
               
           });
                        
        });
        
        nimet2.forEach((k, v) -> {
            
            Collections.sort(v);
            v.forEach((String name) -> {
                System.out.println(name + ": " + k +" movies");
            });
        });   
    }
    
    public void printAverageDurationByGenre(){
        
        Map<String, List<Integer>> meh = new TreeMap<>();
        List<Integer> arvot = new ArrayList<>();
        lista.forEach((Movie elokuuva) ->{
            if (meh.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                temp.add(elokuuva.getDuration());
                meh.put(elokuuva.getGenre(), temp);
            }else{
                try{
                    meh.get(elokuuva.getGenre()).add(elokuuva.getDuration());
                }catch (Exception e){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(elokuuva.getDuration());
                    meh.put(elokuuva.getGenre(), temp);
                }
                
            }
            
        });
        Map<Double, List<String>> genre = new TreeMap<>();
        meh.forEach((k, v) -> {
            double ka = v.stream().mapToDouble(a -> a).average().orElse(0);
            if (genre.isEmpty()){
                List<String> temp = new ArrayList<>();
                temp.add(k);
                genre.put(ka, temp);
            }else{
                try{
                    genre.get(ka).add(k);
                }catch (Exception e){
                    List<String> temp = new ArrayList<>();
                    temp.add(k);
                    genre.put(ka, temp);
                }
                
            }
            
            
        });
           
        genre.forEach((k, v) -> {
            Collections.sort(v);
            v.forEach((String name) -> {
                System.out.printf("%s: %.2f%n",name, k);
            });
        });
        
    }
    
    public void printAverageScoreByGenre(){
        Map<String, List<Double>> meh = new TreeMap<>();
        lista.forEach((Movie elokuuva) ->{
            if (meh.isEmpty()){
                List<Double> temp = new ArrayList<>();
                temp.add(elokuuva.getScore());
                meh.put(elokuuva.getGenre(), temp);
            }else{
                try{
                    meh.get(elokuuva.getGenre()).add(elokuuva.getScore());
                }catch (Exception e){
                    List<Double> temp = new ArrayList<>();
                    temp.add(elokuuva.getScore());
                    meh.put(elokuuva.getGenre(), temp);
                }
                
            }
            
        });
        Map<Double, List<String>> genre = new TreeMap<>(Collections.reverseOrder());
        meh.forEach((k, v) -> {
            double ka = v.stream().mapToDouble(a -> a).average().orElse(0);
            if (genre.isEmpty()){
                List<String> temp = new ArrayList<>();
                temp.add(k);
                genre.put(ka, temp);
            }else{
                try{
                    genre.get(ka).add(k);
                }catch (Exception e){
                    List<String> temp = new ArrayList<>();
                    temp.add(k);
                    genre.put(ka, temp);
                }
                
            }
            
            
        });
           
        genre.forEach((k, v) -> {
            Collections.sort(v);
            v.forEach((String name) -> {
                System.out.printf("%s: %.2f%n",name, k);
            });
            
            
        });
        
    }
    
}
