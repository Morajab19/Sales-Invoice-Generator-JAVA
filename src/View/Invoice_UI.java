
package View;

import Controller.Invoice_Controller;
import Controller.Table_Controller;
import Model.FileOperations;
import Model.Invoice_Table;
import Model.Invoice_Model;
import Model.Item;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Invoice_UI extends javax.swing.JFrame{

    public Invoice_UI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(tbController);
        jScrollPane2 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        invoiceNum = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        labelTostalCost = new javax.swing.JLabel();
        invoiceTotalCost = new javax.swing.JLabel();
        labelInvoiceNum = new javax.swing.JLabel();
        btnNewInvoice = new javax.swing.JButton();
        btnNewInvoice.addActionListener(invController);
        btnDeleteInvoice = new javax.swing.JButton();
        btnDeleteInvoice.addActionListener(invController);
        addItemBtn = new javax.swing.JButton();
        addItemBtn.addActionListener(invController);
        deleteItemBtn = new javax.swing.JButton();
        deleteItemBtn.addActionListener(invController);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Datetxt = new javax.swing.JTextField();
        Nametxt = new javax.swing.JTextField();
        JMenuBar = new javax.swing.JMenuBar();
        MenuBar = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(invController);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(invController);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoiceTable);

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(itemTable);
        itemTable.getAccessibleContext().setAccessibleName("");

        invoiceNum.setText("Invoice NO.");

        invoiceDate.setText("Invoice Date:");

        customerName.setText("Customer Name:");

        labelTostalCost.setText("-");

        invoiceTotalCost.setText("Total");

        btnNewInvoice.setText("Create New Invoice");

        btnDeleteInvoice.setText("Delete Invoice");

        addItemBtn.setText("Add Item");
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });

        deleteItemBtn.setText("Delete Item");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Invoice Table");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Items Table");

        Nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NametxtActionPerformed(evt);
            }
        });

        MenuBar.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        MenuBar.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        MenuBar.add(saveMenuItem);

        JMenuBar.add(MenuBar);

        setJMenuBar(JMenuBar);
        JMenuBar.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnNewInvoice)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteInvoice)
                        .addGap(269, 269, 269)
                        .addComponent(addItemBtn)
                        .addGap(44, 44, 44)
                        .addComponent(deleteItemBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invoiceDate)
                                            .addComponent(customerName)
                                            .addComponent(invoiceTotalCost)
                                            .addComponent(invoiceNum))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Nametxt)
                                            .addComponent(Datetxt)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelInvoiceNum, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelTostalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jLabel2)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(invoiceNum)
                            .addComponent(labelInvoiceNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceDate)
                            .addComponent(Datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerName)
                            .addComponent(Nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(invoiceTotalCost)
                            .addComponent(labelTostalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewInvoice)
                    .addComponent(btnDeleteInvoice)
                    .addComponent(addItemBtn)
                    .addComponent(deleteItemBtn))
                .addGap(40, 40, 40))
        );

        invoiceDate.getAccessibleContext().setAccessibleName("jLabel2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void btnNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewInvoiceActionPerformed

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addItemBtnActionPerformed

    private void NametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NametxtActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Invoice_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Invoice_UI frame= new Invoice_UI();
                
                frame.setVisible(true);
                FileOperations fileOperations = new FileOperations(frame);
                ArrayList<Invoice_Model> inv= fileOperations.readFile();
                frame.setInvoices(inv);
                Invoice_Table invoiceTable = new Invoice_Table(inv);
                frame.setInvoiceTable(invoiceTable);
                frame.getInvoicesTable().setModel(invoiceTable);
                frame.getInvoiceTable().fireTableDataChanged();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Datetxt;
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JMenu MenuBar;
    private javax.swing.JTextField Nametxt;
    private javax.swing.JButton addItemBtn;
    private javax.swing.JButton btnDeleteInvoice;
    private javax.swing.JButton btnNewInvoice;
    private javax.swing.JLabel customerName;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceNum;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel invoiceTotalCost;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelInvoiceNum;
    private javax.swing.JLabel labelTostalCost;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
private Invoice_Controller invController = new Invoice_Controller(this);
private Table_Controller tbController = new Table_Controller(this);
private ArrayList<Invoice_Model> invoicesList;
private ArrayList<Item> itemsList;
//public SimpleDateFormat date = new  SimpleDateFormat("dd/mm/yyyy");

    public JTextField getDate() {
        return Datetxt;
    }

    public void setDate(JTextField Datetxt) {
        this.Datetxt = Datetxt;
    }

    public JTextField getCustomer() {
        return Nametxt;
    }

    public void setCustomerLabel(JTextField Nametxt) {
        this.Nametxt = Nametxt;
    }

    public Invoice_Controller getController() {
        return invController;
    }

    public JLabel getInvNumber() {
        return labelInvoiceNum;
    }

    public void setInvNumber(JLabel labelInvoiceNum) {
        this.labelInvoiceNum = labelInvoiceNum;
    }

    public void setItems(ArrayList<Item> items) {
        this.itemsList = items;
    }
private Invoice_Table headerTabel;

    public Invoice_Table getInvoiceTable() {
        return headerTabel;
    }
 public void setInvoiceTable(Invoice_Table headerTabel){
        this.headerTabel= headerTabel;
    }
public ArrayList<Invoice_Model> getInvoices(){
    if(invoicesList==null){
        invoicesList= new ArrayList<>();
    }
    return invoicesList;
}

    public void setInvoices(ArrayList<Invoice_Model> invoices) {
       this.invoicesList= invoices;
    }

    public JLabel getCustomerName() {
        return customerName;
    }

    public JLabel getInvoiceDate() {
        return invoiceDate;
    }

    public JLabel getInvoiceNum() {
        return invoiceNum;
    }

    public JLabel getInvoiceTotalCost() {
        return invoiceTotalCost;
    }

    public JLabel getLabelTostalCost() {
        return labelTostalCost;
    }

    public JTable getInvoicesTable() {
        return invoiceTable;
    }

    public JTable getItemsTable() {
        return itemTable;
    }

   public Invoice_Controller getLisener(){
       return invController;
   }
  
   
   public void setCustomerName(String name){
       invoiceTable.setName(name);
       
   }
   public int calcTotalInvs(){
       int num=0;
       for(Invoice_Model invoice: invoicesList){
           if(invoice.getNum()>num){
               num= invoice.getNum();
           }
       }
       
       return num;
   }
}
