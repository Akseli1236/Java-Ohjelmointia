package fi.tuni.prog3.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * A class for representing a JSON array.
 */
public final class ArrayNode extends Node implements Iterable<Node> {
    
    private List<Node> lista;

    /**
     *
     * Constructs an initially empty JSON array node.
     */
    public ArrayNode() {
        this.lista = new ArrayList<>();
    }
    /**
     * Returns the number of JSON nodes stored in this JSON array.
     * @return the number of JSON nodes in this JSON array.
     */
    public int size(){
        return lista.size();
    }
    /**
     * Adds a new JSON node to the end of this JSON array.
     * 
     * @param node - the new JSON node to be added.
     */
    public void add(Node node){
        lista.add(node);
        //System.out.println(lista.get(0));
    }

    

    /**
     * Returns a Node iterator that iterates the JSON nodes stored in this JSON array.
     * @return a Node iterator that iterates the JSON nodes stored in this JSON array.
     */
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
