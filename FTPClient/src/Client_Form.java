import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Nov 09 15:55:37 ICT 2022
 */



/**
 * @author lee_kayn
 */
public class Client_Form extends JFrame {
    public Client_Form() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String username=textField2.getText();
        String pass=new String(passwordField1.getPassword());
        String port = textField1.getText();
        String host = textField3.getText();
        String[] argument =new String[] {host,port,username,pass};
        String[] msg = new String[10];
        msg[0]="check";
        ClientFTP obj= new ClientFTP();
        try {
            msg = obj.connect(argument);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Host or Port is incorrect","Error",JOptionPane.ERROR_MESSAGE);
        }
        int err=0;
        if (msg[0].compareTo("Success")==0){
            String [] args = {host,port,username,msg[1]};
            try {
                MainFrame obj_m= new MainFrame();
                obj_m.main(args);
                this.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(Client_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(msg[0].compareTo("Fail")==0){
            err++;
            JOptionPane.showMessageDialog(this,"Username or Password is incorrect","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        passwordField1 = new JPasswordField();
        textField3 = new JTextField();
        label5 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();

        //======== this ========
        setTitle("Login");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Enter Port");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(20, 200), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(95, 190, 235, 30);

        //---- label2 ----
        label2.setText("UserName");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(20, 235), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Password");
        contentPane.add(label3);
        label3.setBounds(20, 265, 65, 16);
        contentPane.add(textField2);
        textField2.setBounds(95, 225, 235, 30);

        //---- button1 ----
        button1.setText("Connect");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 300), button1.getPreferredSize()));
        contentPane.add(passwordField1);
        passwordField1.setBounds(95, 260, 235, 30);
        contentPane.add(textField3);
        textField3.setBounds(95, 155, 235, 30);

        //---- label5 ----
        label5.setText("Enter Host");
        contentPane.add(label5);
        label5.setBounds(20, 165, 70, 16);

        //---- label7 ----
        label7.setText("Copyright (c) 2022 by Team88");
        contentPane.add(label7);
        label7.setBounds(100, 340, 180, 30);

        //---- label8 ----
        label8.setText("Hi,");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(15, 15), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("This is an FTP service, but it is simplified and more user-friendly.");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(15, 35), label9.getPreferredSize()));

        //---- label10 ----
        label10.setText("LOGIN");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD, label10.getFont().getSize() + 4f));
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(175, 110), label10.getPreferredSize()));

        //---- label11 ----
        label11.setText("Thank you for using our app.Wish you a good day \u2665");
        contentPane.add(label11);
        label11.setBounds(new Rectangle(new Point(15, 60), label11.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JPasswordField passwordField1;
    private JTextField textField3;
    private JLabel label5;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_Form().setVisible(true);
            }
        });
    }
}
