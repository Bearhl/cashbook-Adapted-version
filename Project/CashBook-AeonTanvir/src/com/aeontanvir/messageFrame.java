package com.aeontanvir;


import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class messageFrame extends javax.swing.JFrame{
    int num;
    public messageFrame(){
        init();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }


    private void init(){

        titleLabel = new javax.swing.JLabel();
        accountLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        accountLabel = new javax.swing.JLabel();
        passwordcheckLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JPasswordField();
        passwordText = new javax.swing.JPasswordField();
        accountText = new javax.swing.JTextField();

        jmessage = new JTextArea(10,30);
        jmessage.setTabSize(4);
        jmessage.setFont(new Font("黑体",1,11));
        jmessage.setLineWrap(true);
        jmessage.setWrapStyleWord(true);
        baseBox1 = new javax.swing.Box(0);
        baseBox2 = new javax.swing.Box(1);
        box0 = new javax.swing.Box(1);
        box1 = new javax.swing.Box(1);
        box2 = new javax.swing.Box(1);
        box3 = new javax.swing.Box(0);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        titleLabel = new JLabel("意 见 反 馈");
        okButton = new JButton("确定");
        resetButton = new JButton("重置");

//		lab = new JLabel("用户注册页面");
        box0 = Box.createVerticalBox();
        box0.add(titleLabel);

        box1 = Box.createVerticalBox();
        box1.add(jmessage);

        box3 = Box.createHorizontalBox();
        box3.add(okButton);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(resetButton);

        baseBox2 = Box.createVerticalBox();
        baseBox2.add(box0);
        baseBox2.add(box1);
        baseBox2.add(Box.createVerticalStrut(10));
        baseBox2.add(box3);
        add(baseBox2);

        setBounds(200,200,400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("意见反馈界面");
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
        jmessage.setText("");
    }
    private void btnokPerformed(java.awt.event.ActionEvent evt){
        if ("".equals(jmessage.getText())) {
            JOptionPane.showMessageDialog(rootPane, "意见反馈为空！请重新输入！");
            jmessage.requestFocus();
        }
        else{
            Connection conn = null;
            PreparedStatement pstm = null;
            try{
                conn = DatabaseConnection.getConnection();
                String sql0 = "insert into message values(?,?)";
                pstm = conn.prepareStatement(sql0);
                pstm.setInt(1,num);
                pstm.setString(2,jmessage.getText());
                int rs = pstm.executeUpdate();
                System.out.print(rs);
                JOptionPane.showMessageDialog(rootPane, "保存成功");
            }catch (Exception e) {
                try {
                    ErrorHelper.exceptionError("SignupFrame btnLoginActionPerformed Error \t" + e);
                } catch (Exception ex) {
                    System.err.println("123654753");
                }
                System.err.println("SignupFrame btnLoginActionPerformed Error \t" + e);
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupFrame().setVisible(true);
            }
        });
    }


    private javax.swing.JButton okButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordcheckLabel;
    private javax.swing.JPasswordField nameText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField accountText;
    private javax.swing.Box baseBox1;
    private javax.swing.Box baseBox2;
    private javax.swing.Box box0;
    private javax.swing.Box box1;
    private javax.swing.Box box2;
    private javax.swing.Box box3;
    private javax.swing.JTextArea jmessage;
}