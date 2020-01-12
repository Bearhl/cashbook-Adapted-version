package com.aeontanvir;

import com.sun.tools.javac.Main;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import com.aeontanvir.MainFrame;

public class ChangeFrame extends javax.swing.JFrame{
    int num;
    public ChangeFrame(){
        init();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }


    private void init(){
        titleLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        //dateText = new com.toedter.calendar.JDateChooser();
        //dateText.getDateFormatString();
        //dateText.setDateFormatString();
        typeText = new javax.swing.JTextField();

        noteText = new javax.swing.JTextField();

        amountText = new javax.swing.JTextField();

        baseBox1 = new javax.swing.Box(0);
        baseBox2 = new javax.swing.Box(1);
        box0 = new javax.swing.Box(1);
        box1 = new javax.swing.Box(1);
        box2 = new javax.swing.Box(1);
        box3 = new javax.swing.Box(0);
        TypeTxt = new javax.swing.JComboBox();
        TypeTxt.addItem("美食");
        TypeTxt.addItem("奢侈品");
        TypeTxt.addItem("日用品");
        TypeTxt.addItem("服装");
        TypeTxt.addItem("租借");
        TypeTxt.addItem("其他");
        TypeTxt.setVisible(true);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        titleLabel = new JLabel("注  册");
        //dateLabel = new JLabel("日             期");
        typeLabel= new JLabel("类             型");
        noteLabel= new JLabel("备             注");
        amountLabel= new JLabel("额             度");
        //typeText = new JTextField(20);
        typeText.setText(MainFrame.gettabletype());
        noteText = new JTextField(20);
        noteText.setText(MainFrame.gettablenote());
        amountText = new JTextField(20);
        amountText.setText(MainFrame.gettablemoney());
        okButton = new JButton("确定");
        resetButton = new JButton("重置");


//		lab = new JLabel("用户注册页面");
        box0 = Box.createVerticalBox();
        box0.add(titleLabel);

        box1 = Box.createVerticalBox();
        //box1.add(dateLabel);
        //box1.add(Box.createVerticalStrut(20));
        box1.add(typeLabel);
        box1.add(Box.createVerticalStrut(20));
        box1.add(noteLabel);
        box1.add(Box.createVerticalStrut(20));
        box1.add(amountLabel);

        box2 = Box.createVerticalBox();
        //box2.add(dateText);
        //box2.add(Box.createVerticalStrut(10));
        box2.add(TypeTxt);
        box2.add(Box.createVerticalStrut(10));
        box2.add(noteText);
        box2.add(Box.createVerticalStrut(10));
        box2.add(amountText);

        box3 = Box.createHorizontalBox();
        box3.add(okButton);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(resetButton);

        baseBox1 = Box.createHorizontalBox();
        baseBox1.add(box1);
        baseBox1.add(Box.createHorizontalStrut(10));
        baseBox1.add(box2);

        baseBox2 = Box.createVerticalBox();
        baseBox2.add(box0);
        baseBox2.add(baseBox1);
        baseBox2.add(Box.createVerticalStrut(10));
        baseBox2.add(box3);
        add(baseBox2);

        setBounds(200,200,400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("数据修改界面");
        //重置按钮定义
        resetButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnresetPerformed(evt);}
        });
        okButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnokPerformed(evt);}
        });
    }

    private void btnresetPerformed(java.awt.event.ActionEvent evt) {
        //重置操作
        typeText.setText("");
        noteText.setText("");
        amountText.setText("");
    }
    private void btnokPerformed(java.awt.event.ActionEvent evt) {
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        //dateText.setDateFormatString(df.format(new Date()));
        if ("".equals(typeText.getText())) {
            JOptionPane.showMessageDialog(rootPane, "");
            typeText.requestFocus();
        } else if ("".equals(amountText.getText())) {
            JOptionPane.showMessageDialog(rootPane, "请输入密码！！！");
            noteText.requestFocus();
        } else {
            Connection conn = null;
            PreparedStatement psm = null;
            ResultSet rs = null;
            try {
                conn = DatabaseConnection.getConnection();
                String sql = "UPDATE data_all SET type = '"
                        +typeText.getText()
                        +"' , details ='"
                        +noteText.getText()
                        +"' , money = '"
                        + amountText.getText()
                        +"' where type ='"
                        +MainFrame.gettabletype()
                        +"' and money='"
                        +MainFrame.gettablemoney()
                        +"' and details='"
                        +MainFrame.gettablenote()
                        + "'";
                System.out.println(sql);
                psm = conn.prepareStatement(sql);
                psm.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "更改数据成功！！");
                this.setVisible(false);
            } catch(Exception ex) {
                System.err.println("btnCHangeActionPerformed" + ex);
            } finally {
                if (conn != null || psm != null) {
                    try {
                        conn.close();
                        psm.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeFrame().setVisible(true);
            }
        });
    }


    private javax.swing.JButton okButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JLabel amountLabel;
    private com.toedter.calendar.JDateChooser dateText;
    private javax.swing.JTextField typeText;
    private javax.swing.JTextField noteText;
    private javax.swing.JTextField amountText;
    private javax.swing.Box baseBox1;
    private javax.swing.Box baseBox2;
    private javax.swing.Box box0;
    private javax.swing.Box box1;
    private javax.swing.Box box2;
    private javax.swing.Box box3;
    private javax.swing.JComboBox TypeTxt;
}