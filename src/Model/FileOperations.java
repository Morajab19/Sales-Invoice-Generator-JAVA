
package Model;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import View.Invoice_UI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FileOperations {
    private Invoice_UI UI;
    
    public FileOperations(Invoice_UI UI) {
        this.UI = UI;
    }
//reading invoice data from the selected CSV header and line files
 public ArrayList<Invoice_Model> readFile(){
     String invoicePath = "";
     String itemPath = "";
        File InvoicesFile ;
        File itemsFile;
        List<String> invoiceRow=null;
        List<String> itemRow=null;
        int Picked;
        String split = ",";
        ArrayList<Invoice_Model> invArray = new ArrayList<>();
  
            JOptionPane.showMessageDialog(UI, " insert the Headers File "); 
            JFileChooser file = new JFileChooser();
            
               Picked = file.showOpenDialog(UI);
            if (Picked == JFileChooser.APPROVE_OPTION) {
                
                InvoicesFile = file.getSelectedFile();
                if(InvoicesFile.getName().contains(".csv")){
                    invoicePath=InvoicesFile.getAbsolutePath();
                }
                else{
                 JOptionPane.showMessageDialog(UI, "Wrong File Format, insert a .CSV file ");  
                }
            }
 JOptionPane.showMessageDialog(UI, " insert the item Lines File "); 
                Picked = file.showOpenDialog(UI);
                
                if (Picked == JFileChooser.APPROVE_OPTION) {
                    itemsFile = file.getSelectedFile();
                    if(itemsFile.getName().contains(".csv")){
                        itemPath= itemsFile.getAbsolutePath();      
                    }
                    else{
         
                 JOptionPane.showMessageDialog(UI, "Wrong File Format, insert a .CSV file");
                }
                }
                
            try {
                invoiceRow = Files.lines(Paths.get(invoicePath)).collect(Collectors.toList());
            } catch (IOException ex) {
               
                 JOptionPane.showMessageDialog(UI, "Wrong Headers File Path");
                 ex.getStackTrace();
            }
           
            try {
                itemRow = Files.lines(Paths.get(itemPath)).collect(Collectors.toList());
            } catch (IOException ex) {
               
                 JOptionPane.showMessageDialog(UI, "Wrong Items File Patth");
                 ex.getStackTrace();
            }
            
               
                
                if(invoiceRow!=null && itemRow !=null){
                for (String invRow : invoiceRow) {
                    
                    String[] invArr = invRow.split(split);
                    Invoice_Model invoice = new Invoice_Model(Integer.parseInt(invArr[0]), invArr[2], invArr[1]);
                    invArray.add(invoice);
                    UI.getInvoices().add(invoice);
                   
                }
                
                for (String itRow : itemRow) {
                    String[] itenArr = itRow.split(split);
                    int num = Integer.parseInt(itenArr[0]);
                    Invoice_Model invoice=retrieveInvoice(num);
                    Item it = new Item(itenArr[1],Integer.parseInt(itenArr[3]),Double.parseDouble(itenArr[2]),invoice);
                    invoice.getItems().add(it);
                }
                }
                
                return invArray;        
          
 }

 
//getting the invoice by number
 public Invoice_Model retrieveInvoice(int num){
    for(Invoice_Model inv : UI.getInvoices()){
        if(inv.getNum()==num){
            return inv;
        }
    } 
        return null;
}

 //saving the invoice from the tables to the CSV file selected 
 public void saveFile(ArrayList<Invoice_Model> invs) {
       
        String invoices = "";
        String items = "";
        File invoiceFile;
        File itemFile;
        int selectedFile;
     
        for(Invoice_Model invoice: invs){
            String invRows = invoice.getInvoicesFromTabel();
            invoices=invoices+invRows;
            invoices=invoices+"\n";
            
            for(Item item : invoice.getItems()){
                String itFile = item.getItemsFromTabel();
                items = items+itFile;
                items = items+"\n";
            }
        }
        
        
        JOptionPane.showMessageDialog(UI, " choose the invoice Headers file ");
        JFileChooser file = new  JFileChooser();
        
        selectedFile = file.showSaveDialog(UI);
        if(selectedFile == JFileChooser.APPROVE_OPTION){
            invoiceFile = file.getSelectedFile();
            if(invoiceFile.getName().contains(".csv")){
                FileWriter invFileWriter = null;
                try {
                    invFileWriter = new FileWriter(invoiceFile);
                    invFileWriter.write(invoices);
                    invFileWriter.flush();
                    
                } catch (IOException ex) {
                    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        invFileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
                else{
                 JOptionPane.showMessageDialog(UI, "Wrong File Format, insert a .CSV file");  
                }
        }
        
            
            JOptionPane.showMessageDialog(UI, " choose the item Lines file ");
            
            selectedFile = file.showSaveDialog(UI);
            if(selectedFile == JFileChooser.APPROVE_OPTION){
                itemFile= file.getSelectedFile();
                if(itemFile.getName().contains(".csv")){
                FileWriter itemFileWriter = null;
                    try {
                        itemFileWriter = new FileWriter(itemFile);
                        itemFileWriter.write(items);
                        itemFileWriter.flush();
                        
                    } catch (IOException ex) {
                        Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    finally {
                        try {
                            itemFileWriter.close();
                        } catch (IOException ex) {
                            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            }
            }
            else{
                 JOptionPane.showMessageDialog(UI, "Wrong File Format, insert a .CSV file");   
            }
       
       
        
}
}