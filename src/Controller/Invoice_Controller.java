package Controller;

import Model.FileOperations;
import Model.Invoice_Table;
import Model.Item_Table;
import Model.Invoice_Model;
import Model.Item;
import View.Invoice_UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import View.CreateInvoiceView;
import View.CreateItemView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Invoice_Controller implements ActionListener, ListSelectionListener {

    private Invoice_UI UI;
    private Invoice_Model invoice;
    private Item item;
    private String customerName ;
    private CreateInvoiceView invView;
    private CreateItemView itemView;
    
    public Invoice_Controller(Invoice_UI UI) {
        this.UI = UI;

    }

    @Override
    
    public void actionPerformed(ActionEvent e) {
        //based on the action command, a specefic action will be done
        //showing the new invoice dialog
         if("Create New Invoice".equals(e.getActionCommand())){
            invView = new CreateInvoiceView(UI);
            invView.setVisible(true);
        }
         //deleting the selected invoice row
        else if ("Delete Invoice".equals(e.getActionCommand())){
            int rowPicked = UI.getInvoicesTable().getSelectedRow();
            if(rowPicked != -1){
                UI.getInvoices().remove(rowPicked);
                UI.getInvoiceTable().fireTableDataChanged();
            }
        }
        //finalizing the creation of the invoice
        else if("OK".equals(e.getActionCommand())){
            String date= invView.getInvoiceDate().getText();
            String name = invView.getCustomerName().getText();
            //calculating the total of the invoices 
            int total= UI.calcTotalInvs();
            total+=1;
            Invoice_Model inv = new Invoice_Model(total,name,date);
            UI.getInvoices().add(inv);
            UI.getInvoiceTable().fireTableDataChanged();
           //dialog shutdown
            invView.setVisible(false);
            invView.dispose();
            invView=null;
        }
        //cancel the new invoice process
        else if("cancelInv".equals(e.getActionCommand())){
            invView.setVisible(false);
            invView.dispose();
            invView=null;
        }
        //load data from csv file
        else if("Load File".equals(e.getActionCommand())){
            UI.setInvoices(null);
            ArrayList<Invoice_Model> invList;
            FileOperations fo = new FileOperations(UI);
            invList = fo.readFile();
            UI.setInvoices(invList);
            Invoice_Table invTable = new Invoice_Table(invList);
            UI.setInvoiceTable(invTable);
            UI.getInvoicesTable().setModel(invTable);
            UI.getInvoiceTable().fireTableDataChanged();
        }
        //saving invoice data to csv file
        else if(e.getActionCommand()=="Save File"){
         FileOperations fo = new FileOperations(UI);           
          fo.saveFile(UI.getInvoices());
        }
//        //saving the editable text fields of a selected invoice row
//        else if(e.getActionCommand()=="Save"){
//            String date= UI.getDate().getText();
//            String name = UI.getCustomer().getText();
//            int rowSelected = UI.getInvoicesTable().getSelectedRow();
//            int total= UI.calcTotalInvs();
//            UI.getInvoices().get(rowSelected).setDate(date);
//            UI.getInvoices().get(rowSelected).setName(name);
//            UI.getInvoiceTable().fireTableDataChanged();
//            
//        }
//        //cancel the updates
//        else if(e.getActionCommand() == "Cancel"){
//            int rowSelected = UI.getInvoicesTable().getSelectedRow();
//            UI.getCustomer().setText(UI.getInvoices().get(rowSelected).getName());
//            UI.getDate().setText(UI.getInvoices().get(rowSelected).getDate());
//        }
         //adding new item to invoice
        else if("Add Item".equals(e.getActionCommand())){
             itemView = new CreateItemView(UI);
             itemView.setVisible(true);
         }
        //deleting a selected item from invoice
        else if("Delete Item".equals(e.getActionCommand())){
            int pickedInv= UI.getInvoicesTable().getSelectedRow();
          int rowPicked = UI.getItemsTable().getSelectedRow();
        if((pickedInv!=-1) && (rowPicked!= -1)){
            Invoice_Model invoice = UI.getInvoices().get(pickedInv);
            invoice.getItems().remove(rowPicked);
            UI.getInvoiceTable().fireTableDataChanged();
            Item_Table itemSelected = new Item_Table(invoice.getItems());
            UI.getItemsTable().setModel(itemSelected);
            itemSelected.fireTableDataChanged();
        }
        }
        //finlizing the creation and adding of the item by clicking Add Item btn
        else if ("Create Item".equals(e.getActionCommand())){
            int invoiceSelected= UI.getInvoicesTable().getSelectedRow();
        if(invoiceSelected!=-1){
            Invoice_Model inv = UI.getInvoices().get(invoiceSelected);
            String it= itemView.getiName().getText();
            String price = itemView.getPrice().getText();
            String count = itemView.getCount().getText();
            double doublePrice = Double.parseDouble(price);
            int intCount = Integer.parseInt(count);
            Item newItem = new Item(it,intCount,doublePrice,inv);
            inv.getItems().add(newItem);
            Item_Table lineSelected = new Item_Table(inv.getItems());
            UI.getInvoiceTable().fireTableDataChanged();
            UI.getItemsTable().setModel(lineSelected);
            lineSelected.fireTableDataChanged();

        }
        itemView.setVisible(false);
        itemView.dispose();
        itemView=null;
            
        }
        //Cancel the process of the item creation
        else if("Cancel Item".equals(e.getActionCommand())){
            itemView.setVisible(false);
            itemView.dispose();
            itemView=null;
        }
         
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }



