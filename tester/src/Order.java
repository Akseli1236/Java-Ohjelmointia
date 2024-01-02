
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aksel
 */
public class Order {
    
    private int entryCount;
    private int itemCount;
    private double totalPrice;

    public Order() {
    }

    public static class Item{
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }
        
        public boolean equals(Item other){
            return true;
        }
        
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Item{" + "name=" + name + ", price=" + price + '}';
        }
        
    }
    
    public static class Entry{
        private int count;
        private Item item;
        private String itemName;
        private double unitPrice;
        
        
        public Entry(Item item, int count) {
            this.item = item;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public Item getItem() {
            return item;
        }

        public String getItemName() {
            return itemName;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        @Override
        public String toString() {
            return "Entry{" + "count=" + count + ", item=" + item + ", itemName=" + itemName + ", unitPrice=" + unitPrice + '}';
        }
        
        
    }
    
    
    public boolean addItems(Item item, int count){
        return true;
    }
    public boolean addItems(String name, int count){
        Order.Item a = new Order.Item(null, 1);
        return true;
    }
    
    public List<Entry> getEntries(){
        List<Entry> a = new ArrayList<>();
        return a;
    } 

    public int getEntryCount() {
        return entryCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
    public boolean isEmpty(){
        return true;
    }
    public boolean removeItems(String name, int count){
        return true;
    }
    
}
