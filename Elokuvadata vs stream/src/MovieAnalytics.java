
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MovieAnalytics implements Consumer<Movie>{
    
    private List<Movie> lista;

    public MovieAnalytics() {
        this.lista = new ArrayList<>();
    }
    
    @Override
    public void accept(Movie t) {
        System.out.printf("%s (By %s, %s)%n",t.getTitle(),t.getDirector(),t.getReleaseYear());
    }
    
    public static Consumer<Movie> showInfo(){
        
        Consumer<Movie> a = new MovieAnalytics();
        return a;
    }
     
    public void populateWithData(String fileName) throws IOException{
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = file.readLine()) != null){
                String[] splits = line.split(";");
                
                Movie temp = new Movie(splits[0],Integer.parseInt(splits[1]),Integer.parseInt(splits[2]),splits[3],Double.parseDouble(splits[4]),splits[5]);
                lista.add(temp);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    public Stream<Movie> moviesAfter(int year){
        Stream<Movie> b = lista.stream();
        var help = b.collect(Collectors.groupingBy(movie -> movie.getReleaseYear()));
        List<Movie> jepa = new ArrayList<>();
        int apu = 0;
        for (var entry: help.entrySet()){
            if (entry.getKey() >= year){
                
                 for (var k : help.get(entry.getKey())){
                    if (jepa.isEmpty()){
                        jepa.add(k);
                    }else{
                        if (jepa.get(jepa.size() - 1).getReleaseYear() != k.getReleaseYear()){
                            jepa.add(k);
                            apu = jepa.size() - 1;
                        }else{
                            for (int i = apu; i < jepa.size(); i++){
                                if (jepa.get(i).getTitle().compareTo(k.getTitle()) > 0){
                                    jepa.add(i,k);
                                break;
                                }else if (i == jepa.size()-1){
                                    jepa.add(k);
                                    break;
                                }
                            }
                            
                        }
                        
                        
                    }
                }
                
                
            }
            
        }
        
        Stream<Movie> a = jepa.stream();
        return a;
    }
    
    public Stream<Movie> moviesBetween(int yearA, int yearB){
        
        Stream<Movie> b = lista.stream();
        var help = b.collect(Collectors.groupingBy(movie -> movie.getReleaseYear()));
        List<Movie> jepa = new ArrayList<>();
        int apu = 0;
        for (var entry: help.entrySet()){
            if (entry.getKey() >= yearA && entry.getKey() <= yearB){
                
                 for (var k : help.get(entry.getKey())){
                    if (jepa.isEmpty()){
                        jepa.add(k);
                    }else{
                        if (jepa.get(jepa.size() - 1).getReleaseYear() != k.getReleaseYear()){
                            jepa.add(k);
                            apu = jepa.size() - 1;
                        }else{
                            for (int i = apu; i < jepa.size(); i++){
                                if (jepa.get(i).getTitle().compareTo(k.getTitle()) > 0){
                                    jepa.add(i,k);
                                break;
                                }else if (i == jepa.size()-1){
                                    //System.out.println(k.getTitle());
                                    jepa.add(k);
                                    break;
                                }
                            }
                            
                        }
                        
                        
                    }
                }
                
                
            }
            
        }
        
        Stream<Movie> a = jepa.stream();
        return a;
    }
    
    public Stream<Movie> moviesByDirector(String director){
        Stream<Movie> b = lista.stream();
        var help = b.collect(Collectors.groupingBy(movie -> movie.getDirector()));
        List<Movie> jepa = new ArrayList<>();
        for (var entry: help.entrySet()){
            if (entry.getKey().equals(director)){
                for (var k : help.get(entry.getKey())){
                    //System.out.println(k.getReleaseYear());
                    if (jepa.isEmpty()){
                        jepa.add(k);
                    }else{
                        for (int i = 0; i < jepa.size(); i++){
                            if (jepa.get(i).getReleaseYear() > k.getReleaseYear()){
                                jepa.add(i,k);
                                break;
                            }else if (i == jepa.size()-1){
                                
                                jepa.add(k);
                                break;
                            }
                        }
                        
                    }
                }
                
                
            }
        }
            
        
        //Stream<Movie> a = jepa.stream();
        return jepa.stream();
    }
    
    public Stream<Movie> moviesBefore(int year){
        Stream<Movie> b = lista.stream();
        var help = b.collect(Collectors.groupingBy(movie -> movie.getReleaseYear()));
        List<Movie> jepa = new ArrayList<>();
        int apu = 0;
        for (var entry: help.entrySet()){
            if (entry.getKey() <= year){
                
                 for (var k : help.get(entry.getKey())){
                    if (jepa.isEmpty()){
                        jepa.add(k);
                    }else{
                        if (jepa.get(jepa.size() - 1).getReleaseYear() != k.getReleaseYear()){
                            jepa.add(k);
                            apu = jepa.size() - 1;
                        }else{
                            for (int i = apu; i < jepa.size(); i++){
                                if (jepa.get(i).getTitle().compareTo(k.getTitle()) > 0){
                                    jepa.add(i,k);
                                break;
                                }else if (i == jepa.size()-1){
                                    jepa.add(k);
                                    break;
                                }
                            }
                            
                        }
                        
                        
                    }
                }
                
                
            }
            
        }
        
        Stream<Movie> a = jepa.stream();
        return a;
    }

    
}
