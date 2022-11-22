
//class of Invoice_Model which store in it the invoice item lines, customer name, invoice number and date
package Model;

import java.util.ArrayList;
 
public class Invoice_Model {
   private int num;
   private String date;
   private String name;
   private ArrayList<Item> items;

   
    public Invoice_Model() {
    }
  

    public Invoice_Model(int num, String name, String date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }
    public double getTotalInvoice(){
        double total=0.0;
        for(Item item : getItems()){
            total= total + item.calcTotalItemPrice();
        }
        return total;
    }
   

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Item> getItems() {
        if(items==null){
            items=new ArrayList();
        }
        return items;
    }

    @Override
    public String toString() {
        return "sigHeader{" + "num=" + num + ", date=" + date + ", name=" + name  + ", items=" + items + '}';
    }
    public double getTotal(){
        double total=0;
        for(Item item: getItems()){
            total= total+ item.calcTotalItemPrice();
        }
        return total;
    }

   public String getInvoicesFromTabel(){
       return num + "," + date + "," + name ;
   }
   

   
 
}
