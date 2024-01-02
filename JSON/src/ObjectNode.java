
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class ObjectNode extends Node implements Iterable<String>{
    private Map<String, Node> objekti;

    public ObjectNode() {
        this.objekti = new TreeMap<>();
    }
    Node get(String key){
        if (this.objekti.isEmpty()){
            return null;
        }
        return this.objekti.get(key);
    }
    
    void set(String key, Node node){
        this.objekti.put(key, node);
    }
    
    public int size(){
        return this.objekti.size();
    }
    @Override
    public Iterator<String> iterator() {
        return new TWIterator();
    }

    private class TWIterator implements Iterator<String> {
        int i = -1;
        ArrayList<String> heh = new ArrayList<>();
        

        @Override
        public boolean hasNext() {
            i += 1;
            
            
            for (var a : objekti.keySet()){
                heh.add(a);
            }
            return i < size();
        }

        @Override
        public String next() {
            
            return heh.get(i);
        }
    }
    
}
