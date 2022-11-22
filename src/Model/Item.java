

//class of Item which store in item name, unit price, quantity and links the invoice with it 


package Model;

public class Item {
    private Invoice_Model invoice;
    private String itemName;
    private double unitPrice;
    private int quantity;

    public Item() {
    }

    public Item(String itemName, int quantity,double unitPrice,Invoice_Model invoice) {
        this.invoice= invoice;
        this.quantity = quantity;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }
     public double calcTotalItemPrice(){
        return unitPrice * quantity;
    }



    public Invoice_Model getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice_Model invoice) {
        this.invoice = invoice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "sigItem{" + "itemName=" + itemName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }
    

   public String getItemsFromTabel(){
       return invoice.getNum() + "," + itemName + "," + unitPrice + "," +quantity;
   }

   
    
}
