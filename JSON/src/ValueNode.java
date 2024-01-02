
public class ValueNode extends Node{
    
    //private double number;
    //private String string;
    //private boolean totuusarvo;
    
    private Object value;
    
    
    public ValueNode(double value) {
        //this.number = value;
        this.value = value;
        //this.node = new Node(value);
    }
    
    public ValueNode(boolean value) {
        this.value = value;
    }
    
    public ValueNode(String value) {
        this.value = value;
    }
    
    public boolean isNumber(){
        return value instanceof Double;
        
    }
    public boolean isBoolean(){
        
        return value instanceof Boolean;
    }
    public boolean isString(){
        return this.value instanceof String;
    }
    public boolean isNull(){
        return this.value == null;
    }

    public double getNumber() {
       
        return (double) value;
        
    }

    public String getString() {
        return (String) value;
    }
    
    public boolean getBoolean(){
        return (Boolean) value;
    }
}
