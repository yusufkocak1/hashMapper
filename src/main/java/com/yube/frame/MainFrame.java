package com.yube.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Color;

import com.mysql.cj.xdevapi.JsonArray;
import com.yube.DB.Database;
import com.yube.DB.MysqlDB;
import com.yube.data.hashdata;
import com.yube.utils.FileOparations;
import com.yube.utils.Processor;
import com.yube.utils.WordCreator;
import org.json.JSONArray;

import java.awt.Panel;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.TextField;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    public MysqlDB db = new MysqlDB();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Generator 1.0.0");
        setBounds(100, 100, 390, 443);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 384, 406);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        contentPane.add(tabbedPane);

        Panel homePane = new Panel();
        tabbedPane.addTab("Home", null, homePane, null);
        homePane.setLayout(null);

        Panel panel_4 = new Panel();
        panel_4.setBackground(new Color(248, 248, 255));
        panel_4.setBounds(0, 0, 379, 376);
        homePane.add(panel_4);
        panel_4.setLayout(null);

        JButton btnKelimeret = new JButton("Kelime \u00FCret");

        btnKelimeret.setBounds(108, 13, 97, 25);
        panel_4.add(btnKelimeret);

        TextField wordLength = new TextField();
        wordLength.setBounds(10, 13, 91, 25);
        panel_4.add(wordLength);

        JLayeredPane Base64Pane = new JLayeredPane();
        Base64Pane.setForeground(new Color(0, 0, 0));
        Base64Pane.setBackground(new Color(255, 250, 250));
        tabbedPane.addTab("Base64", null, Base64Pane, null);
        tabbedPane.setForegroundAt(1, new Color(51, 0, 0));
        tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
        Base64Pane.setLayout(null);

        Panel panel = new Panel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 379, 376);
        Base64Pane.add(panel);
        panel.setLayout(null);

        JButton btnDecoderBase64 = new JButton("Decode");
        btnDecoderBase64.setBounds(276, 167, 90, 25);
        panel.add(btnDecoderBase64);

        JButton btnEncodeBase64 = new JButton("Encode");

        btnEncodeBase64.setBounds(10, 167, 90, 25);
        panel.add(btnEncodeBase64);

        TextArea base64TextIn = new TextArea();
        base64TextIn.setBounds(10, 10, 359, 139);
        panel.add(base64TextIn);

        TextArea base64TextOut = new TextArea();
        base64TextOut.setBounds(10, 209, 359, 150);
        panel.add(base64TextOut);

        JButton button_4 = new JButton("^");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                base64TextIn.setText(base64TextOut.getText());
                base64TextOut.setText("");
            }
        });
        button_4.setBounds(164, 167, 46, 25);
        panel.add(button_4);

        JLayeredPane SHA256Pane = new JLayeredPane();
        tabbedPane.addTab("SHA256", null, SHA256Pane, null);
        SHA256Pane.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 0, 379, 376);
        SHA256Pane.add(panel_1);
        panel_1.setLayout(null);

        TextArea SHA256TextIn = new TextArea();
        SHA256TextIn.setBounds(10, 10, 359, 139);
        panel_1.add(SHA256TextIn);

        JButton btnSHA256Encode = new JButton("Encode");

        btnSHA256Encode.setBounds(10, 167, 90, 25);
        panel_1.add(btnSHA256Encode);

        JButton btnSHA256Up = new JButton("^");
        btnSHA256Up.setBounds(164, 167, 46, 25);
        panel_1.add(btnSHA256Up);

        JButton btnSHA26Decode = new JButton("Decode");

        btnSHA26Decode.setBounds(276, 167, 90, 25);
        panel_1.add(btnSHA26Decode);

        TextArea SHA256TextOut = new TextArea();
        SHA256TextOut.setBounds(10, 209, 359, 150);
        panel_1.add(SHA256TextOut);

        JLayeredPane MD5Pane = new JLayeredPane();
        tabbedPane.addTab("MD5", null, MD5Pane, null);

        Panel panel_2 = new Panel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setLayout(null);
        panel_2.setBounds(0, 0, 379, 376);
        MD5Pane.add(panel_2);

        JButton btnDecodeMD5 = new JButton("Decode");
        btnDecodeMD5.setBounds(276, 167, 90, 25);
        panel_2.add(btnDecodeMD5);

        /****************************************
         *
         * wordcreate start
         *
         ****************************************/


        btnKelimeret.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                ArrayList<String> wordlist = new WordCreator().creator(Integer.parseInt(wordLength.getText()));
                new FileOparations().fileWriter(wordlist, "./word", "wordlist.json");
            }
        });


        /****************************************
         *
         * wordcreate end
         *
         ****************************************/


        /****************************************
         *
         * SHA256 start
         *
         ****************************************/

        btnSHA256Encode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = SHA256TextIn.getText();

                SHA256TextOut.setText(Processor.SHA256encoder(text));

                db.Insert(new hashdata.Builder(text, Processor.SHA256encoder(text), Processor.MD5Encoder(text)).build());

            }
        });
        btnSHA256Up.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SHA256TextIn.setText(SHA256TextOut.getText());

                SHA256TextOut.setText("");
            }
        });

        btnSHA26Decode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<hashdata> list = (ArrayList<hashdata>) db.Select(hashdata.class, "from hashdata s where SHA256='" + SHA256TextIn.getText() + "'");
                try {
                    SHA256TextOut.setText(list.get(0).getText());
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        });

        /****************************************
         *
         * SHA256 end
         *
         ****************************************/

        /****************************************
         *
         * md5 start
         *
         ****************************************/
        JButton btnEncodeMD5 = new JButton("Encode");

        btnEncodeMD5.setBounds(10, 167, 90, 25);
        panel_2.add(btnEncodeMD5);

        TextArea MD5TextIn = new TextArea();
        MD5TextIn.setBounds(10, 10, 359, 139);
        panel_2.add(MD5TextIn);

        TextArea MD5TextOut = new TextArea();
        MD5TextOut.setBounds(10, 209, 359, 150);
        panel_2.add(MD5TextOut);

        JButton btnUpMD5 = new JButton("^");
        btnUpMD5.setBounds(164, 167, 46, 25);
        panel_2.add(btnUpMD5);

        btnEncodeMD5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MD5TextOut.setText(Processor.MD5Encoder(MD5TextIn.getText()));
                db.Insert(new hashdata.Builder(MD5TextIn.getText(), Processor.SHA256encoder(MD5TextIn.getText()), Processor.MD5Encoder(MD5TextIn.getText())).build());

            }
        });
        btnDecodeMD5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<hashdata> list = (ArrayList<hashdata>) db.Select(hashdata.class, "from hashdata h where MD5='" + MD5TextIn.getText() + "'");

            try{
                String md5 = list.get(0).getText().toString();
                MD5TextOut.setText(md5);

            }catch(Exception exp){
                exp.printStackTrace();
                }
            }
        });

        btnUpMD5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MD5TextIn.setText(MD5TextOut.getText());
                MD5TextOut.setText("");

            }
        });

        /****************************************
         *
         * md5 end
         *
         ****************************************/

        /****************************************
         *
         * base64 start
         *
         ****************************************/

        btnEncodeBase64.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                base64TextOut.setText(Processor.Base64Encoder(base64TextIn.getText()));

            }
        });

        btnDecoderBase64.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                base64TextOut.setText(Processor.Base64Decoder(base64TextIn.getText()));
            }
        });

        /******************************************
         *
         * base64 end
         *
         ****************************************/
    }
}
