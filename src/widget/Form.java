package widget;

import listener.CustomMouseListener;
import javax.swing.*;
import java.io.*;

public class Form {
    private final JFrame jFrame;

    public Form() {
        jFrame = new JFrame();
    }

    public void initConfig() {
        jFrame.setTitle("LOGIN");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(285, 215);
        jFrame.setLocation(100, 100);
        jFrame.setLayout(null);

        JLabel signin_label = new JLabel("SIGN IN");
        signin_label.setBounds(115, 10, 50, 30);

        JLabel userName_label = new JLabel("Username");
        userName_label.setBounds(20, 50, 60, 30);

        JTextField userName_textField = new JTextField("Username");
        userName_textField.setBounds(100, 50, 150, 30);

        JLabel password_label = new JLabel("Password");
        password_label.setBounds(20, 90, 60, 30);

        JPasswordField password_textField = new JPasswordField();
        password_textField.setBounds(100, 90, 150, 30);

        JButton singin_button = new JButton("Sign in");
        singin_button.setBounds(100, 130, 80, 30);
        singin_button.addMouseListener(new CustomMouseListener());
        singin_button.addActionListener(e -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.initConfig();
            loginFrame.run();

            String username = userName_textField.getText();
            String password = String.valueOf(password_textField.getPassword());

            if (username.equals("Username") || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username and password");
                return;
            }

            File file = new File("src\\User.txt");
            saveUser(file, username, password);

            jFrame.setVisible(false);
        });

        jFrame.add(signin_label);
        jFrame.add(userName_label);
        jFrame.add(password_label);
        jFrame.add(password_textField);
        jFrame.add(userName_textField);
        jFrame.add(singin_button);
    }

    private void saveUser(File file, String username, String password) {
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Create file success!");
                } else {
                    System.out.println("Create file failed!");
                }
            }
            FileOutputStream fos = new FileOutputStream(file, true);
            String user = "Username: " + username + "\nPassword: " + password + "\n";
            fos.write(user.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        jFrame.setVisible(true);
    }
}
