
package Controller;

import Model.Item_Table;
import Model.Invoice_Model;
import Model.Item;
import View.Invoice_UI;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Table_Controller implements ListSelectionListener{
    private Invoice_UI UI;

    public Table_Controller(Invoice_UI UI) {
        this.UI = UI;
    }
    
/*when an invoice is selected from the header tabel, the following method searchs for which invoice has been selected
    from the header tabel and gets its item lines and update the item table
    */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int invIndex = UI.getInvoicesTable().getSelectedRow();
        if(invIndex!= -1){
             Invoice_Model row = UI.getInvoices().get(invIndex);
             ArrayList<Item> items = row.getItems();
             UI.getCustomer().setText(row.getName());
             UI.getInvNumber().setText(""+row.getNum());
             UI.getDate().setText(row.getDate());
             UI.getLabelTostalCost().setText(""+row.getTotalInvoice());
             Item_Table it = new Item_Table(items);
             UI.getItemsTable().setModel(it);
             it.fireTableDataChanged();
             
        }
    }
    
}
