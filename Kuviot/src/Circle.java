
public class Circle implements IShapeMetrics{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Circle with radius: %.2f", this.radius);
    }
    
    @Override
    public String name(){
        return "circle";
    }
    
    @Override
    public double area(){
        return PI*Math.pow(this.radius, 2);
    }
    
    @Override
    public double circumference(){
        return 2*PI*this.radius;
    }
    
    
    
}
