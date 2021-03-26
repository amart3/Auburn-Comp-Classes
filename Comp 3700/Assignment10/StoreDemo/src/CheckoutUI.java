import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutUI {

    private DataAdapter dataAdapter;
    private  Order order;
    private JButton btnAdd = new JButton("Add a New Item");
    private JButton btnPay = new JButton("Finish and Pay");

    private DefaultTableModel items = new DefaultTableModel(); // store information for the table!

    private JTable tblItems = new JTable(items); // null, new String[]{"ProductID", "Product Name", "Price", "Quantity", "Cost"});
    private JLabel labTotal = new JLabel("Total: ");
    private JPanel mainPanel;

    public CheckoutUI(DataAdapter dataAdapter) {

        this.dataAdapter = dataAdapter;

        this.mainPanel = new JPanel();



        items.addColumn("Product ID");
        items.addColumn("Customer ID");
        items.addColumn("Name");
        items.addColumn("Price");
        items.addColumn("Quantity");
        items.addColumn("Cost");

        JPanel panelOrder = new JPanel();
        panelOrder.setPreferredSize(new Dimension(400, 450));
        panelOrder.setLayout(new BoxLayout(panelOrder, BoxLayout.PAGE_AXIS));
        tblItems.setBounds(0, 0, 400, 350);
        panelOrder.add(tblItems.getTableHeader());
        panelOrder.add(tblItems);
        panelOrder.add(labTotal);
        tblItems.setFillsViewportHeight(true);
        this.mainPanel.add(panelOrder);

        JPanel panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400, 100));
        panelButton.add(btnAdd);
        panelButton.add(btnPay);
        this.mainPanel.add(panelButton);

        order = new Order();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveOrder();
            }
        });

    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnPay() {
        return btnPay;
    }

    public JLabel getLabTotal() {
        return labTotal;
    }

    public void addRow(Object[] row) {
        items.addRow(row);              // add a row to list of item!
        //    items.fireTableDataChanged();
    }

    private void addProduct() {
        String id = JOptionPane.showInputDialog("Enter ProductID: ");
        Product product = dataAdapter.loadProduct(Integer.parseInt(id));
        if (product == null) {
            JOptionPane.showMessageDialog(null, "This product does not exist!");
            return;
        }

        String customerID = JOptionPane.showInputDialog("Enter CustomerID: ");

        double quantity = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter quantity: "));

        if (quantity < 0 || quantity > product.getQuantity()) {
            JOptionPane.showMessageDialog(null, "This quantity is not valid!");
            return;
        }

        OrderLine line = new OrderLine();
        line.setOrderID(this.order.getOrderID());
        line.setProductID(product.getProductID());
        line.setQuantity(quantity);
        line.setCost(quantity * product.getPrice());

        product.setQuantity(product.getQuantity() - quantity); // update new quantity!!
        dataAdapter.saveProduct(product); // and store this product back right away!!!

        order.getLines().add(line);
        order.setTotalCost(order.getTotalCost() + line.getCost());
        order.setCustomerId(customerID);

        Object[] row = new Object[6];
        row[0] = line.getProductID();
        row[1] = customerID;
        row[2] = product.getName();
        row[3] = product.getPrice();
        row[4] = line.getQuantity();
        row[5] = line.getCost();

        addRow(row);
        getLabTotal().setText("Total: $" + order.getTotalCost());
        //invalidate();
    }

    private void saveOrder() {
        JOptionPane.showMessageDialog(null, "This function is being implemented!");
    }

    public void showWindow() {
        JFrame frame = new JFrame("Checkout");
        frame.setContentPane(this.mainPanel);//
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
