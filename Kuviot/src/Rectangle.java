
public class Rectangle implements IShapeMetrics {
    private double heigth;
    private double width;

    public Rectangle(double heigth, double width) {
        this.heigth = heigth;
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format("Rectangle with height %.2f and width %.2f", this.heigth, this.width);
    }
    
    @Override
    public String name(){
        return "rectangle";
    }
    
    @Override
    public double area(){
        return this.heigth * this.width;
        
    }
    
    @Override
    public double circumference(){
        return this.heigth*2 + this.width*2;
    }
    
}
