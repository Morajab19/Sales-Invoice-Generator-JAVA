
// item lines table model
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Item_Table extends AbstractTableModel {

    private String[] cols = {"Num", "Item", "Unit Price", "Quantity", "Total"};
    private ArrayList<Item> itemsList;

    public Item_Table(ArrayList<Item> items) {
        this.itemsList = items;
    }

    @Override
    public int getRowCount() {
        return itemsList.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Item i = itemsList.get(rowIndex);
        if(columnIndex ==0 )
          return i.getInvoice().getNum();
        else if(columnIndex ==1)
            return i.getItemName();
        else if(columnIndex ==2)
            return i.getUnitPrice();
        else if(columnIndex ==3)
            return i.getQuantity();
        else if(columnIndex==4)
            return i.calcTotalItemPrice();
        else 
            return null;
    }
   
    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
}
