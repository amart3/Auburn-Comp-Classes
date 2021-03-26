import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CostGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField quantityTextField;
    private JLabel quantityLabel;
    private JButton calculateButton;
    private JLabel priceLabel;
    private JPanel mainLabel;
    private JTextField priceTextField;
    private JLabel Total;

    public CostGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double total = (Double.parseDouble(quantityTextField.getText())
                        * Double.parseDouble(priceTextField.getText()));
                Total.setText("$" + total);
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new CostGUI("Cost Calculator");
        frame.setVisible(true);
    }
}
