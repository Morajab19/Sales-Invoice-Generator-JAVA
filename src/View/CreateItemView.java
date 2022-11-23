
package View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
//creating the dialog of creating new item
public class CreateItemView extends JDialog {
    private JTextField iName;
    private JTextField price;
    private JTextField count;
    private JLabel lableItemName;
    private JLabel lableItemPrice;
    private JLabel lableCount;
    private JButton OK;
    private JButton cancel;

    public CreateItemView(Invoice_UI frame) {
        lableItemName= new JLabel("Item Name");
        iName = new JTextField(30);
        lableItemPrice = new JLabel("Item Price");
        price = new JTextField(30);
        lableCount = new JLabel("Count");
        count = new JTextField(30);
        OK= new JButton("Add Item");
        cancel = new JButton("Cancel");
        OK.setActionCommand("Create Item");
        cancel.setActionCommand("Cancel Item");
        OK.addActionListener(frame.getController());
        cancel.addActionListener(frame.getController());
        setLayout(new GridLayout(5, 5));
        add(lableItemName);
        add(iName);
        add(lableItemPrice);
        add(price);
        add(lableCount);
        add(count);
        add(OK);
        add(cancel);
        
        pack();
    }

    public JTextField getiName() {
        return iName;
    }

    public JTextField getPrice() {
        return price;
    }

    public JTextField getCount() {
        return count;
    }
    
}
