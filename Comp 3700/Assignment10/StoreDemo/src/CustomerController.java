import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerController {




    private DataAdapter dataAdapter;
    private JPanel mainPanel;
    private JTextField CustomerIDTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private JButton loadButton;
    private JButton saveButton;
    private JLabel CustomerIDLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel phoneNumberLabel;

    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }

    public void setDataAdapter(DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
    }

    public CustomerController(DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = dataAdapter.loadCustomer(CustomerIDTextField.getText());

                if (customer ==null) {
                    System.err.println("Customer ID cannot be generated.");
                }
                firstNameTextField.setText(customer.getFirstName());
                lastNameTextField.setText(customer.getLastName());
                phoneNumberTextField.setText(customer.getPhoneNumber());
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer();
                customer.setCustomerID(CustomerIDTextField.getText());
                customer.setFirstName(firstNameTextField.getText());
                customer.setLastName(lastNameTextField.getText());
                customer.setPhoneNumber(phoneNumberTextField.getText());

                boolean val = dataAdapter.saveCustomer(customer);

                if (!val) {
                    System.err.println("Customer ID cannot be saved.");
                }
            }
        });
    }


    public void Display() {
        JFrame frame = new JFrame("CustomerUI");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
