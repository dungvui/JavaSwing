package widget;

import listener.CommonWindowListener;
import listener.CustomMouseListener;

import javax.swing.*;

public class LoginFrame {
    private final JFrame jFrame;

    public LoginFrame() {
        jFrame = new JFrame();
    }

    public void initConfig() {
        jFrame.setTitle("LOGIN");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(285, 215);
        jFrame.setLocation(100, 100);
        jFrame.setLayout(null);

        JPanel panel = new JPanel();
        JLabel login_label = new JLabel("LOGIN");
        login_label.setBounds(115, 10, 50, 30);

        JLabel userName_label = new JLabel("Username");
        userName_label.setBounds(20, 50, 60, 30);

        JTextField userName_textField = new JTextField("Username");
        userName_textField.setBounds(100, 50, 150, 30);

        JLabel password_label = new JLabel("Password");
        password_label.setBounds(20, 90, 60, 30);

        JPasswordField password_textField = new JPasswordField();
        password_textField.setBounds(100, 90, 150, 30);

        JButton login_button = new JButton("Login");
        login_button.setBounds(45, 130, 80, 30);
        login_button.addMouseListener(new CustomMouseListener());

        JButton signup_button = new JButton("Signup");
        signup_button.setBounds(155, 130, 80, 30);
        signup_button.addMouseListener(new CustomMouseListener());
        signup_button.addActionListener(e -> {
            Form form = new Form();
            form.initConfig();
            form.run();

            jFrame.setVisible(false);
        });

        jFrame.add(login_label);
        jFrame.add(userName_label);
        jFrame.add(password_label);
        jFrame.add(password_textField);
        jFrame.add(login_button);
        jFrame.add(userName_textField);
        jFrame.add(signup_button);
    }


    public void run() {
        jFrame.setVisible(true);
    }
}
