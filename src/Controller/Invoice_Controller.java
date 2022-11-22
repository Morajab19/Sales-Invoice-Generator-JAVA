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
    
    public Invoice_Controller(Invoice_UI UI) {
        this.UI = UI;

    }

    @Override
    
    public void actionPerformed(ActionEvent e) {
        //based on the action command, a specefic action will be done
        //showing the new invoice dialog
         if("Create new Invoice".equals(e.getActionCommand())){
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
            Invoice_Model inv = new Invoice_Model(total,date,name);
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
        //saving the editable text fields of a selected invoice row
        else if(e.getActionCommand()=="Save"){
            String date= UI.getDate().getText();
            String name = UI.getCustomer().getText();
            int rowSelected = UI.getInvoicesTable().getSelectedRow();
            int total= UI.calcTotalInvs();
            UI.getInvoices().get(rowSelected).setDate(date);
            UI.getInvoices().get(rowSelected).setName(name);
            UI.getInvoiceTable().fireTableDataChanged();
            
        }
        //cancel the updates
        else if(e.getActionCommand() == "Cancel"){
            int rowSelected = UI.getInvoicesTable().getSelectedRow();
            UI.getCustomer().setText(UI.getInvoices().get(rowSelected).getName());
            UI.getDate().setText(UI.getInvoices().get(rowSelected).getDate());
        }
          
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }



