import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginScreen extends JFrame {
    private JTextField txtUserName = new JTextField(10);
    private JTextField txtPassword = new JTextField(10);
    private JButton    btnLogin    = new JButton("Login");

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }

    public LoginScreen() {


        this.setSize(300, 400);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(new JLabel ("Store Management System"));

        JPanel panelUserName = new JPanel();
        panelUserName.add(new JLabel("Username:"));
        panelUserName.add(txtUserName);

        this.getContentPane().add(panelUserName);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password:"));
        panelPassword.add(txtPassword);

        this.getContentPane().add(panelPassword);

        this.getContentPane().add(btnLogin);
    }
}

class LoginController implements ActionListener {
    private LoginScreen loginScreen;
    private DataAdapter dataAdapter;


    public LoginController(LoginScreen loginScreen, DataAdapter dataAdapter) {
        this.loginScreen = loginScreen;
        this.dataAdapter = dataAdapter;
        this.loginScreen.getBtnLogin().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginScreen.getBtnLogin()) {
            String username = loginScreen.getTxtUserName().getText().trim();
            String password = loginScreen.getTxtPassword().getText().trim();

            System.out.println("Login with username = " + username + " and password = " + password);
            User user = dataAdapter.loadUser(username, password);

            if (user == null) {
                JOptionPane.showMessageDialog(null, "This user does not exist!");
            }
            else {
                Application.getInstance().setCurrentUser(user);
                this.loginScreen.setVisible(false);
                Application.getInstance().getMainScreen().setVisible(true);
            }
        }
    }
}