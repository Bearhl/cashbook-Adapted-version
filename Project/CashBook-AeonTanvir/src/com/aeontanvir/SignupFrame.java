package com.aeontanvir;


import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class SignupFrame extends javax.swing.JFrame{
    int num;
    public SignupFrame(){
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
        baseBox1 = new javax.swing.Box(0);
        baseBox2 = new javax.swing.Box(1);
        box0 = new javax.swing.Box(1);
        box1 = new javax.swing.Box(1);
        box2 = new javax.swing.Box(1);
        box3 = new javax.swing.Box(0);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        titleLabel = new JLabel("注  册");
        accountLabel = new JLabel("账             号");
        passwordLabel= new JLabel("密             码");
        passwordcheckLabel = new JLabel("再次输入密码");
        accountText = new JTextField(10);
        nameText = new JPasswordField(20);
        passwordText = new JPasswordField(20);
        okButton = new JButton("确定");
        resetButton = new JButton("重置");


//		lab = new JLabel("用户注册页面");
        box0 = Box.createVerticalBox();
        box0.add(titleLabel);

        box1 = Box.createVerticalBox();
        box1.add(accountLabel);
        box1.add(Box.createVerticalStrut(20));
        box1.add(passwordLabel);
        box1.add(Box.createVerticalStrut(20));
        box1.add(passwordcheckLabel);

        box2 = Box.createVerticalBox();
        box2.add(accountText);
        box2.add(Box.createVerticalStrut(10));
        box2.add(nameText);
        box2.add(Box.createVerticalStrut(10));
        box2.add(passwordText);

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
        setTitle("用户注册界面");
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
            accountText.setText("");
            nameText.setText("");
            passwordText.setText("");
        }
        private void btnokPerformed(java.awt.event.ActionEvent evt){
            if ("".equals(accountText.getText())) {
                JOptionPane.showMessageDialog(rootPane, "请输入用户名！！！");
                accountText.requestFocus();
            } else if ("".equals(nameText.getText())) {
                JOptionPane.showMessageDialog(rootPane, "请输入密码！！！");
                nameText.requestFocus();

        } else if (!nameText.getText().equals(passwordText.getText())){
                JOptionPane.showMessageDialog(rootPane,"输入密码不一致，请重试！");
                passwordText.setText("");
                passwordText.requestFocus();
            }
            else{
                Connection conn = null;
                PreparedStatement pstm = null;
            try{
                conn = DatabaseConnection.getConnection();
                String sql0 = "select max(ID) from user";
                pstm = conn.prepareStatement(sql0);
                ResultSet rs0=pstm.executeQuery(sql0);
                rs0.next();
                num = rs0.getInt(1);
                num++;
                String sql = "insert into user values(?,?,?,?,?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1,num);
                pstm.setString(2,accountText.getText()); //待优化问题：账号名重复注册问题
                pstm.setString(3,passwordText.getText());
                pstm.setString(4,accountText.getText());
                pstm.setString(5,"0");
                pstm.setString(6,"0");
                int rs = pstm.executeUpdate();
                System.out.print(rs);
                    JOptionPane.showMessageDialog(rootPane, "注册成功！!");
                    this.setVisible(false);
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
}