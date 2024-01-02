
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashSet;

public class Sudoku {
    private int i;
    private int j;
    private char c;
    
    private TreeMap<Integer, TreeMap<Integer, Character>> map = new TreeMap<>();

    public Sudoku() {
        for (int i = 0; i < 9; i++){
            this.map.put(i, new TreeMap<>());
            for (int j = 0; j < 9; j++){
                this.map.get(i).put(j,' ');
                
                
            }
        }
    }
    
    public void set(int i, int j, char c){
        if (i > 8 || j > 8){
            System.out.println("Trying to access illegal cell " + "("+i + ", " + j + ")!");
        }else{
            if (Character.isDigit(c)){
                this.map.get(i).replace(j,c); 
            }else if (c != ' '){
                System.out.println("Trying to set illegal character " + c + " to " + "("+i + ", " + j + ")!");
            }
           
        }
        
    }
    
    public void print(){
        String str = "#";
        String str_2 = "---+";
        String str_3 = "---#";
        System.out.println(str.repeat(37));
        for (int i = 0; i < 9; i++){
            System.out.print(str);
            for(int j = 0; j < 9; j++){
                System.out.print(" " + this.map.get(i).get(j));
                switch (j){
                    case 2, 5 ->System.out.print(" " + str);
                    case 8 -> System.out.print(" " + str);
                    default -> System.out.print(" |");
                }
            }
            switch (i) {
                case 2, 5 -> System.out.println("\n"+ str.repeat(37));
                case 8 -> System.out.println("\n"+ str.repeat(37));
                default -> System.out.println("\n" + str + str_2.repeat(2) + str_3 + str_2.repeat(2) + str_3 +str_2.repeat(2) + str_3);
            }
        }
        
        //System.out.println(this.map);
    }
    
    public boolean check(){
        
        for (int i = 0; i < 9; i++){
            //TreeMap<Integer,Integer> tester = new TreeMap<>();
            ArrayList<Integer> test = new ArrayList<>();
            ArrayList<Integer> test_2 = new ArrayList<>();
             for(int j = 0; j < 9; j++){
                //tester.put(Character.getNumericValue(this.map.get(i).get(j)), j);
                if (Character.getNumericValue(this.map.get(i).get(j)) > 0){
                    test.add(Character.getNumericValue(this.map.get(i).get(j)));
                }
                if (Character.getNumericValue(this.map.get(j).get(i)) > 0){
                    test_2.add(Character.getNumericValue(this.map.get(j).get(i)));
                }
                
            }
             //Set inputSet = new HashSet(test);
             //Set inputSet_2 = new HashSet(test_2);
             
             while (!test.isEmpty()){
                 int temp = test.get(0);
                 test.remove(0);
                 if (test.contains(temp)){
                     System.out.println("Row " + i + " has multiple " + temp + "'s!");
                     return false;
                 }
             }
             test.clear();
             test_2.clear();

        }
        for (int i = 0; i < 9; i++){
            //TreeMap<Integer,Integer> tester = new TreeMap<>();
            ArrayList<Integer> test = new ArrayList<>();
            ArrayList<Integer> test_2 = new ArrayList<>();
             for(int j = 0; j < 9; j++){
                //tester.put(Character.getNumericValue(this.map.get(i).get(j)), j);
                if (Character.getNumericValue(this.map.get(i).get(j)) > 0){
                    test.add(Character.getNumericValue(this.map.get(i).get(j)));
                }
                if (Character.getNumericValue(this.map.get(j).get(i)) > 0){
                    test_2.add(Character.getNumericValue(this.map.get(j).get(i)));
                }
                
            }
             //Set inputSet = new HashSet(test);
             //Set inputSet_2 = new HashSet(test_2);
             
             while (!test_2.isEmpty()){
                 int temp = test_2.get(0);
                 test_2.remove(0);
                 if (test_2.contains(temp)){
                     System.out.println("Column " + i + " has multiple " + temp + "'s!");
                     return false;
                 }
             }
        }
        
        int k = 0;
        int i = 0;
        int j = 0;
        int a = 0;
        int print = 0;
        int print_2 = 0;
        ArrayList<Integer> test_3 = new ArrayList<>();
        while (k < 3){
            
            
            if (Character.getNumericValue(this.map.get(j).get(i)) > 0){
                    test_3.add(Character.getNumericValue(this.map.get(j).get(i)));
                    //System.out.println(j + " " + i);
                    a++;
                }else{
                a++;
                }
            i++;
            if (i % 3 == 0){
                //System.out.println("Jakojäännös" + i);
                j++;
                if (k == 0){
                    i = 0;
                }else if (k == 1){
                    i = 3;
                }else{
                    i = 6;
                }
                
            }
            if (a==9){
                if (j < 3){
                    print = 0;
                }else if (j < 6){
                    print = 3;
                }else{
                    print = 6;
                }
                
                print = j - 3;
                //Set inputSet = new HashSet(test_3);
                //if (test_3.size() > inputSet.size()){
                 //System.out.println("Wrong_3" + i + j);
                 //return false;
                //}
                while (!test_3.isEmpty()){
                 int temp = test_3.get(0);
                 test_3.remove(0);
                 if (test_3.contains(temp)){
                     System.out.println("Block at (" + print + ", " + i + ") has multiple " + temp + "'s!");
                     return false;
                 }
             }
                test_3.clear();
                a=0;
            }
            
            if (j == 9){
                k++;
                j = 0;
                if (k == 1){
                    i = 3;
                }else if (k == 2){
                    i = 6;
                }         
            }
        }  
        return true;
    }
}
