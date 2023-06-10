import org.omg.CORBA.Object;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Nov 11 11:44:51 ICT 2022
 */



/**
 * @author lee_kayn
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        initComponents();
    }

//    private void toggleButton1(ActionEvent e) {
//        // TODO add your code here
//        if(toggleButton1.isSelected()){
//
//            JOptionPane.showMessageDialog(this,"send (Sends a file)\nreceive (Receives a file)\nlist (Lists all files in current working directiry)/"
//                    + "\ncd (change working directory)\nmkdir (creates a new directory)\nrmdir (deletes a directory if it's empty)\ndelete (delete's a file)" , "List of Comments", JOptionPane.INFORMATION_MESSAGE);
//
//            toggleButton1.doClick();
//        }
//    }


    //Execute
//    private void button1(ActionEvent e) {
//        // TODO add your code here
//        Thread queryThread = new Thread() {
//            public void run() {
//                button1.setEnabled(false);
//                try {
//                    executeCommands("");
//                } catch (IOException ex) {
//                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        queryThread.start();
//    }


    //Disconnect
    private void button2(ActionEvent e) {
        // TODO add your code here
        try {
            obj_client.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] args={"as"};
        Client_Form.main(args);
        this.setVisible(false);
    }

    private void button3(ActionEvent e) {
        button3.setEnabled(false);
        Thread queryThread = new Thread() {
            public void run() {
                try {
                    executeCommands("LIST","button3");
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        queryThread.start();
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        button4.setEnabled(false);
        Thread queryThread = new Thread() {
            public void run() {
                try {
                    executeCommands("SEND","button4");
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        queryThread.start();
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
        button5.setEnabled(false);
        Thread queryThread = new Thread() {
            public void run() {
                try {
                    executeCommands("receive","button5");
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        queryThread.start();
    }

    private void button6(ActionEvent e) {
        // TODO add your code here
        button6.setEnabled(false);
        Thread queryThread = new Thread() {
            public void run() {
                try {
                    executeCommands("mkdir","button6");
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        queryThread.start();
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
        button7.setEnabled(false);
        Thread queryThread = new Thread() {
            public void run() {
                try {
                    executeCommands("cd","button7");
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        queryThread.start();
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
        button8.setEnabled(false);
        Thread queryThread = new Thread() {
            public void run() {
                try {
                    executeCommands("rmdirAll","button8");
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        queryThread.start();
    }

    private void button9(ActionEvent e) {
        // TODO add your code here
        button9.setEnabled(false);
        Thread queryThread = new Thread() {
            public void run() {
                try {
                    executeCommands("delete","button9");
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        queryThread.start();
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button2 = new JButton();
        progressBar1 = new JProgressBar();
        label5 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        textField4 = new JTextField();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        fileChooser1 = new JFileChooser();
        fileChooser2 = new JFileChooser();

        //======== this ========
        setTitle("File Transfer Protocol");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Port");
        contentPane.add(label1);
        label1.setBounds(95, 150, 35, label1.getPreferredSize().height);

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setEnabled(false);
        contentPane.add(textField1);
        textField1.setBounds(155, 140, 265, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("PWD");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(95, 180), label3.getPreferredSize()));

        //---- textField3 ----
        textField3.setEditable(false);
        textField3.setEnabled(false);
        contentPane.add(textField3);
        textField3.setBounds(155, 175, 265, textField3.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Disconnect");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(430, 130), button2.getPreferredSize()));

        //---- progressBar1 ----
        progressBar1.setPreferredSize(new Dimension(146, 10));
        contentPane.add(progressBar1);
        progressBar1.setBounds(430, 180, 90, 25);

        //---- label5 ----
        label5.setIcon(new ImageIcon(getClass().getResource("/FTPImage.jpeg")));
        contentPane.add(label5);
        label5.setBounds(445, 355, 135, 130);

        //---- label4 ----
        label4.setText("Copyright (c) 2022 by Team88");
        contentPane.add(label4);
        label4.setBounds(205, 495, 180, 30);

        //---- label6 ----
        label6.setText("Hi,@username");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(20, 15), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("Welcome to our FTP service..Thank you for using our application. ");
        contentPane.add(label7);
        label7.setBounds(20, 45, 350, 16);

        //---- label8 ----
        label8.setText("Have a nice day at work \u2665");
        contentPane.add(label8);
        label8.setBounds(20, 75, 195, label8.getPreferredSize().height);

        //---- label9 ----
        label9.setText("Host");
        contentPane.add(label9);
        label9.setBounds(95, 110, 27, 16);

        //---- textField4 ----
        textField4.setEnabled(false);
        textField4.setEditable(false);
        contentPane.add(textField4);
        textField4.setBounds(155, 105, 265, 30);

        //---- label10 ----
        label10.setIcon(new ImageIcon(getClass().getResource("/.idea/FTP (1).png")));
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label10);
        label10.setBounds(15, 275, 135, 130);

        //---- label11 ----
        label11.setText("Simplicity is the ultimate sophistication.");
        contentPane.add(label11);
        label11.setBounds(140, 215, 220, label11.getPreferredSize().height);

        //---- label12 ----
        label12.setText("Leonardo da Vinci.");
        contentPane.add(label12);
        label12.setBounds(new Rectangle(new Point(360, 230), label12.getPreferredSize()));

        //---- button3 ----
        button3.setText("Show all files in curent working directory");
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(180, 255, 255, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("Send a file to Server");
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(180, 290, 255, button4.getPreferredSize().height);

        //---- button5 ----
        button5.setText("Receive a file");
        button5.addActionListener(e -> button5(e));
        contentPane.add(button5);
        button5.setBounds(180, 325, 255, button5.getPreferredSize().height);

        //---- button6 ----
        button6.setText("Create a directory");
        button6.addActionListener(e -> button6(e));
        contentPane.add(button6);
        button6.setBounds(180, 360, 255, button6.getPreferredSize().height);

        //---- button7 ----
        button7.setText("Chang current working directory");
        button7.addActionListener(e -> button7(e));
        contentPane.add(button7);
        button7.setBounds(180, 395, 255, button7.getPreferredSize().height);

        //---- button8 ----
        button8.setText("Deleted a directory");
        button8.addActionListener(e -> button8(e));
        contentPane.add(button8);
        button8.setBounds(180, 430, 255, button8.getPreferredSize().height);

        //---- button9 ----
        button9.setText("Delete a file");
        button9.addActionListener(e -> button9(e));
        contentPane.add(button9);
        button9.setBounds(180, 465, 255, button9.getPreferredSize().height);

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

        //---- fileChooser2 ----
        fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        setDefaultCloseOperation(3);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField3;
    private JButton button2;
    private JProgressBar progressBar1;
    private JLabel label5;
    private JLabel label4;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField textField4;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JFileChooser fileChooser1;
    private JFileChooser fileChooser2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    String userName,Port,pwd,Host,Role;
    ClientFTP obj_client = new ClientFTP();

    public MainFrame(String args[]) throws Exception {
        Host=args[0];
        Port=args[1];
        userName = args[2];
        Role=args[3];

        initComponents();
        myInitComponents();
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                try {
                    obj_client.disconnect();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                e.getWindow().dispose();
            }
        });
    }

    public void myInitComponents() throws Exception {
        label6.setText("Hi,"+userName);
        textField1.setText(Port);
        textField4.setText(Host);
        pwd= obj_client.getPWD();
        textField3.setText("PWD: "+pwd);
        if(Role.compareTo("emp")==0){
            button5.setEnabled(false);
            button9.setEnabled(false);
        }
    }

    public String getChoice() {
        String choice =null;
        int n;
        n=JOptionPane.showConfirmDialog(this,"Do you want to overwrite?","File Already Exists",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(n==0)
        {
            choice ="Y";
        }
        else {
            choice="N";
        }
        return choice;
    }

    private void executeCommands(String Comand,String button) throws IOException{

        Comand=Comand.toLowerCase();
        if (Comand.compareTo("send")==0){

            int returnVal = fileChooser1.showOpenDialog(this);
            if (returnVal == fileChooser1.APPROVE_OPTION) {
                File file = fileChooser1.getSelectedFile();

                ClientFTP.dout.writeUTF("SEND");
                ClientFTP.datasoc=new Socket(Host,ClientFTP.dataPort);
                ClientFTP.datadin=new DataInputStream(ClientFTP.datasoc.getInputStream());
                ClientFTP.dataout=new DataOutputStream(ClientFTP.datasoc.getOutputStream());
                String filename=file.getName();
                String path=file.getAbsolutePath();

                ClientFTP.dout.writeUTF(filename);

                String msgFromServer=ClientFTP.din.readUTF();
                int check=0;
                if(msgFromServer.compareTo("File Already Exists")==0)
                {
                    String Option;
                    MainFrame obj_main=new MainFrame();
                    Option=obj_main.getChoice();
                    if(Option=="Y")
                    {
                        ClientFTP.dout.writeUTF("Y");
                    }
                    else
                    {
                        ClientFTP.dout.writeUTF("N");
                        button4.setEnabled(true);
                        check=1;
                        return;
                    }
                }

                if(check==1){
                    return;
                }

                FileInputStream fin=new FileInputStream(file);
                double filelength=file.length();
                double updatelength=filelength/1000;

                int ch,count=0;

                do
                {
                    if(count >= updatelength){
                        double progValue=((updatelength/filelength)*100);
                        System.out.println("size" + (int) progValue);
                        updatelength+=updatelength;
                        progressBar1.setValue((int) progValue);
                        progressBar1.update(progressBar1.getGraphics());
                    }
                    count++;
                    ch=fin.read();

                    ClientFTP.dataout.writeUTF(String.valueOf(ch));
                }
                while(ch!=-1);
                fin.close();
                System.out.println(ClientFTP.din.readUTF());
                progressBar1.setValue(100);
                //return true;
                JOptionPane.showMessageDialog(this,"Send a file to Server successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
            }

        }
        else if (Comand.compareTo("receive")==0){

            ArrayList<String> fileList= new ArrayList<String>();
            try {
                fileList=obj_client.getFiles();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String fileList[] = new String[30];
            String[] inputlist = new String[fileList.size()];
            inputlist = fileList.toArray(inputlist);
            System.out.println("In receive before pane");
            String fileName = (String) JOptionPane.showInputDialog(this, "Choose a File to Download/Receive", "Input", JOptionPane.QUESTION_MESSAGE,
                    null, inputlist, "Titan");
            if (fileName==null){
                button5.setEnabled(true);
                return;
            }
            System.out.println("In receive after pane");
            System.out.println(fileName);
            ClientFTP.dout.writeUTF("GET");
            ClientFTP.datasoc=new Socket(Host,ClientFTP.dataPort);
            ClientFTP.datadin=new DataInputStream(ClientFTP.datasoc.getInputStream());
            ClientFTP.dataout=new DataOutputStream(ClientFTP.datasoc.getOutputStream());
            ClientFTP.dout.writeUTF(fileName);
            String msgFromServer=ClientFTP.din.readUTF();

            if(msgFromServer.compareTo("File Not Found")==0)
            {
                System.out.println("File not found on Server ...");
                return;
            }
            else if(msgFromServer.compareTo("READY")==0)
            {
                int check=0;
                File f=new File(fileName);
                if(f.exists())
                {
                    String Option;
                    MainFrame obj_main=new MainFrame();
                    Option=obj_main.getChoice();
                    if(Option=="N")
                    {
                        ClientFTP.dout.flush();
                        button5.setEnabled(true);
                        return;
                    }
                }

                FileOutputStream fout=new FileOutputStream(f);
                int ch;
                String temp;
                int count=0;
                double receivelength,filelength;
                filelength=ClientFTP.din.readDouble();
                receivelength=filelength/1000;

                do
                {
                    if (count > receivelength){
                        //System.out.println("in client" + updatelength);

                        double progValue=((receivelength/filelength)*100);
                        System.out.println("size" + (int) progValue);
                        receivelength+=receivelength;
                        progressBar1.setValue((int) progValue);
                        progressBar1.update(progressBar1.getGraphics());

                    }
                    count++;
                    temp=ClientFTP.datadin.readUTF();
                    ch=Integer.parseInt(temp);
                    if(ch!=-1)
                    {
                        fout.write(ch);
                    }
                }while(ch!=-1);
                fout.close();
                System.out.println(ClientFTP.din.readUTF());
                progressBar1.setValue(100);
                JOptionPane.showMessageDialog(this,"Receive a file from Server successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(Comand.compareTo("list")==0){
            ArrayList<String> fileList= new ArrayList<String>();
            try {
                fileList= obj_client.getList();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] inputlist = new String[fileList.size()];
            inputlist = fileList.toArray(inputlist);

            JOptionPane.showMessageDialog(this, inputlist, "List of Files/Folders", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (Comand.compareTo("cd")==0){
            String status="false";
            String selection = (String) JOptionPane.showInputDialog(this, "Enter a Path:", "Input", JOptionPane.QUESTION_MESSAGE,
                    null, null,null);
            if(selection==null){

            }
            else if (selection.isEmpty()){
                JOptionPane.showMessageDialog(this,"You didn't enter any path" , "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {

                try {
                    status= obj_client.setCD(selection);
                    myInitComponents();
                    if (status.compareTo("false")==0){
                        JOptionPane.showMessageDialog(this,"Directory not Exist" , "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"Change current working directory successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (Comand.compareTo("delete")==0){
            ArrayList<String> fileList= new ArrayList<String>();
            try {
                fileList=obj_client.getFiles();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String fileList[] = new String[30];
            String[] inputlist = new String[fileList.size()];
            inputlist = fileList.toArray(inputlist);

            String selection = (String) JOptionPane.showInputDialog(this, "Choose a File to delete", "Input", JOptionPane.QUESTION_MESSAGE,
                    null, inputlist, "Titan");
//            System.out.println(selection);
            if(selection==null){

            } else {
                try {
                    obj_client.deleteFile(selection);
                    JOptionPane.showMessageDialog(this,"Delete a file successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (Comand.compareTo("mkdir")==0){
            String status="false";
            String selection =JOptionPane.showInputDialog(this, "Enter a Directory name:", "Input", JOptionPane.PLAIN_MESSAGE);
            if(selection==null){

            }
            else if (selection.isEmpty()){
                JOptionPane.showMessageDialog(this,"You didn't enter any input" , "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{

                try {
                    status=obj_client.setNewDir(selection);
                    if (status.compareTo("false")==0){
                        JOptionPane.showMessageDialog(this,"Directory not created" , "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Directory created","Successfully",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (Comand.compareTo("rmdirall")==0){
            String status="false";
            ArrayList<String> fileList= new ArrayList<String>();
            try {
                fileList=obj_client.getDir();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String fileList[] = new String[30];
            String[] inputlist = new String[fileList.size()];
            inputlist = fileList.toArray(inputlist);

            String selection = (String) JOptionPane.showInputDialog(this, "Choose a Folder to delete", "Input", JOptionPane.QUESTION_MESSAGE,
                    null, inputlist, "Titan");
            if(selection == null) {

            }
            else {
                status=obj_client.deleteAllinFolder(selection,"NO");
                int countFile= obj_client.returnFile();
                int countFolder = obj_client.returnDir();
                int reply=JOptionPane.showConfirmDialog(this,"This Folder have "+countFile+" files and "+countFolder+" folders\n Do you want continue","Continue",JOptionPane.YES_NO_OPTION);
                if(reply==JOptionPane.NO_OPTION){

                } else {
                    try {
                        status=obj_client.deleteAllinFolder(selection,"YES");
                        if (status.compareTo("false")==0){
                            JOptionPane.showMessageDialog(this,"Directory contains Files!!!!" , "Error", JOptionPane.ERROR_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(this,"Remove Directory successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Invalid Command Click Help Button" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        progressBar1.setValue(0);

        if(button=="button3"){
            button3.setEnabled(true);
        }

        if(button=="button4"){
            button4.setEnabled(true);
        }

        if(button=="button5"){
            button5.setEnabled(true);
        }

        if(button=="button6"){
            button6.setEnabled(true);
        }

        if(button=="button7"){
            button7.setEnabled(true);
        }

        if(button=="button8"){
            button8.setEnabled(true);
        }

        if(button=="button9"){
            button9.setEnabled(true);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame(args).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
