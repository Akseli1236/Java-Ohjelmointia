
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;


public final class NdArray<E> extends AbstractCollection<E> implements Iterable<E>{
    
    private int firstDimlen;
    private Integer[] furtherDimLens;
    private TreeMap map;
    private List<E> lista;
    private Object set;

    NdArray(Integer firstDimlen, Integer ...furtherDimLens){
        if (firstDimlen < 0){
            throw new NegativeArraySizeException("Illegal dimension size " + firstDimlen + ".");
        }
        this.firstDimlen = firstDimlen;
        for (var a : furtherDimLens){
            if (a < 0){
                throw new NegativeArraySizeException("Illegal dimension size " + a + ".");
            }
              
        }
        this.furtherDimLens = furtherDimLens;
        map = new TreeMap<String,Object>();
        lista = new ArrayList<E>();
        
        
    }

    @Override
    public Iterator<E> iterator() {
        return new TWIterator();
    }
    
    private class TWIterator implements Iterator<E>{
        int i = -1;
        @Override
        public boolean hasNext() {
            i += 1;
            return i < size();
            
        }

        @Override
        public E next() { 
            
            return (E) lista.get(i);
        }
        
    }

    @Override
    public int size() {
        int size = this.firstDimlen;
        
        for (var a : this.furtherDimLens){
            size = size * a;
        }
        return size;
    }
    
    public E get(int... indices){
        
        int real = this.furtherDimLens.length + 1;
        if (indices.length != this.furtherDimLens.length +1){
            throw new IllegalArgumentException("The array has " + real + " dimensions but " + indices.length + " indices were given.");
        }
        for (int i = 0; i < indices.length; i++){
            
            if (i == 0){
               if (indices[i]< 0 || indices[i] >= this.firstDimlen){
                    real -= 1;
                    throw new IndexOutOfBoundsException("Illegal index " + indices[i] + " for dimension " + real + " of length " + indices[i] + ".");
                    
               }
            }else{
                if (indices[i]< 0 || indices[i] >= this.furtherDimLens[i-1]){
                    real -= 1;
                    throw new IndexOutOfBoundsException("Illegal index " + indices[i] + " for dimension " + real + " of length " + indices[i] + ".");
                }
            }
            
        }
        String help = "";
        Object word = null;
        for (var p : indices){
            help += p;
        }
        for (var m : map.keySet()){
            //System.out.println(m);
            if (help.equals(m)){
                word = map.get(m);
            }
        }
        return (E) word;
    }
    
    public void set(E item, int... indices){
        int real = this.furtherDimLens.length + 1;
        if (indices.length != this.furtherDimLens.length +1){
            throw new IllegalArgumentException("The array has " + real + " dimensions but " + indices.length + " indices were given.");
        }
        for (int i = 0; i < indices.length; i++){
            if (i == 0){
               if (indices[i]< 0 || indices[i] >= this.firstDimlen){
                   real -= 1;
                    throw new IndexOutOfBoundsException("Illegal index " + indices[i] + " for dimension " + real + " of length " + indices[i] + ".");
               }
            }else{
                if (indices[i]< 0 || indices[i] >= this.furtherDimLens[i-1]){
                    real -= 1;
                    throw new IndexOutOfBoundsException("Illegal index " + indices[i] + " for dimension " + real + " of length " + indices[i] + ".");
                }
            }

            
        }
        lista.add(item);
        String apu = "";
        for (int i = 0; i < indices.length; i++){
            apu += String.valueOf(indices[i]);
            
        }
        set = item;
        map.put(apu, set);
        
        //System.out.println(Arrays.toString(set));
        
    }
    
    public int[] getDimensions(){
        int[] a = new int[1+ this.furtherDimLens.length];
        for (int i = 0; i < a.length; i++){
            if (i == 0){
                a[i] = this.firstDimlen;
            }else{
                a[i] = this.furtherDimLens[i-1];
                
            } 
        }
        return a;
    }
    
    
    
}
