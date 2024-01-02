
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArrayNode extends Node implements Iterable<Node> {
    
    private List<Node> lista;

    public ArrayNode() {
        this.lista = new ArrayList<>();
    }
    
    void add(Node node){
        lista.add(node);
        //System.out.println(lista.get(0));
    }
    
    public int size(){
        return lista.size();
    }

    @Override
    public Iterator<Node> iterator() {
        return new TWIterator();
    }
    private class TWIterator implements Iterator<Node> {
        int i = -1;
        @Override
        public boolean hasNext() {
            i+= 1;
            return i < size();
        }

        @Override
        public Node next() {
            return lista.get(i);
        }
    }
    
}
