
// invoices table header model

package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Invoice_Table extends AbstractTableModel {

    private String[] cols = {"Num", "Date", "Customer", "Total"};
    private ArrayList<Invoice_Model> invoiceList;

    public Invoice_Table(ArrayList<Invoice_Model> invoices) {
        this.invoiceList = invoices;
    }

    @Override
    public int getRowCount() {
        return invoiceList.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
 @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice_Model inv = invoiceList.get(rowIndex);
        if(columnIndex ==0 )
             return inv.getNum();
        else if(columnIndex ==1)
            return inv.getDate();
        else if(columnIndex ==2)
               return inv.getName();
        else if(columnIndex ==3)
            return inv.getTotalInvoice();
        else 
            return null;
    }
   
    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

}
