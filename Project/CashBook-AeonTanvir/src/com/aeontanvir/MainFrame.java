/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeontanvir;

import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MainFrame extends javax.swing.JFrame {

    private static JTable jPurchaseTable;

    public MainFrame() throws ClassNotFoundException {
        initComponents();
        updateInfo();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    private void initComponents() {
        //定义窗口的各组件
        mainTabPane = new JTabbedPane();    //定义Tab栏
        jpanelHome = new JPanel();
        jPanel9 = new JPanel();
        jpanelHomeIcon = new JPanel();
        //定义Tab栏按钮及Label
        btnTabOne = new JButton();
        btnTabTwo = new JButton();
        btnTabThree = new JButton();
        btnTabFour = new JButton();
        btnTabFive = new JButton();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel34 = new JLabel();
        btnTabSix = new JButton();
        btnTab1 = new JButton();
        btnTab2 = new JButton();
        btnTab3 = new JButton();
        btnTab4 = new JButton();
        btnTab5 = new JButton();
        btnTab6= new JButton();
        btnTab7 = new JButton();
        jLabel35 = new JLabel();
        btnTabSeven = new JButton();
        jLabel36 = new JLabel();
        btnTabEight = new JButton();
        jLabel37 = new JLabel();

        jPanel13 = new JPanel();
        jPanel16 = new JPanel();
        jLabel44 = new JLabel();
        lblCashInHand = new JLabel();
        jLabel45 = new JLabel();
        jpanelCash = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jLabel4 = new JLabel();
        jCashDate = new JDateChooser();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        txtCashType = new JComboBox();
        txtCashType.addItem("美食");
        txtCashType.addItem("交通");
        txtCashType.addItem("生活用品");
        txtCashType.addItem("服装");
        txtCashType.addItem("娱乐");
        txtCashType.addItem("其他");
        txtCashType.setVisible(true);

        txtSaleType = new JComboBox();
        txtSaleType.addItem("工资");
        txtSaleType.addItem("奖金");
        txtSaleType.addItem("生活费");
        //txtSaleType.addItem("");
        //txtSaleType.addItem("租借");
        txtSaleType.addItem("其他");
        txtSaleType.setVisible(true);

        txtPurchaseType = new JComboBox();
        txtPurchaseType.addItem("美食");
        txtPurchaseType.addItem("交通");
        txtPurchaseType.addItem("生活用品");
        txtPurchaseType.addItem("服装");
        txtPurchaseType.addItem("娱乐");
        txtPurchaseType.addItem("工资");
        txtPurchaseType.addItem("奖金");
        txtPurchaseType.addItem("生活费");
        txtPurchaseType.addItem("其他");
        txtPurchaseType.setVisible(true);

        txtPurchase2Choose =new JComboBox();
        txtPurchase2Choose.addItem("收入");
        txtPurchase2Choose.addItem("支出");
        txtPurchase2Choose.addItem("全部(不必选类型)");
        txtPurchase2Choose.setVisible(true);

        jbeiwang = new JTextArea(10,30);
        jbeiwang.setTabSize(4);
        jbeiwang.setFont(new Font("黑体",1,11));
        jbeiwang.setLineWrap(true);
        jbeiwang.setWrapStyleWord(true);
        txtCashDetails = new JTextField();
        txtSaleDetails = new JTextField();
        txtCashAmount = new JTextField();
        txtSaleAmount = new JTextField();
        btnCashAdd = new JButton();
        jPanel17 = new JPanel();
        jLabel46 = new JLabel();
        jCashDateStart = new JDateChooser();
        jLabel47 = new JLabel();
        jCashDateEnd = new JDateChooser();
        btnCashShowOnTable = new JButton();
        btnCashDeleteTable = new JButton();
        btnSaleDeleteTable = new JButton();
        btnPurchaseChangeTable = new JButton();
        jScrollPane1 = new JScrollPane();
        jCashTable = new JTable();
        jpanelSale = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jLabel10 = new JLabel();
        jSaleDate = new JDateChooser();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        txtSaleCusName = new JTextField();
        txtSaleCusMobile = new JTextField();
        txtSaleProductDetails = new JTextField();
        txtSaleInvoice = new JTextField();
        txtSaleTotal = new JTextField();
        txtSaleDiscount = new JTextField();
        txtSaleGrandTotal = new JTextField();
        btnSaleAdd = new JButton();
        jPanel18 = new JPanel();
        jLabel51 = new JLabel();
        jSaleDateStart = new JDateChooser();
        jLabel52 = new JLabel();
        jSaleDateEnd = new JDateChooser();
        btnSaleShowOnTable = new JButton();
        jScrollPane2 = new JScrollPane();
        jSaleTable = new JTable();
        jpanelPurchase = new JPanel();
        jPanel7 = new JPanel();
        jPanel8 = new JPanel();
        jLabel26 = new JLabel();
        jPurchaseDate = new JDateChooser();
        jLabel27 = new JLabel();
        jLabel28 = new JLabel();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jLabel33 = new JLabel();
        txtPurchase2 = new JTextField();
        txtPurchase6 = new JTextField();
        txtPurchase5 = new JTextField();
        txtPurchase7 = new JTextField();
        txtPurchase3 = new JTextField();
        txtPurchase4 = new JTextField();
        btnPurchaseAdd = new JButton();
        jPanel19 = new JPanel();
        jLabel53 = new JLabel();
        jPurchaseDateStart = new JDateChooser();
        jdatestart = new JDateChooser();
        jdateend = new JDateChooser();
        jLabel54 = new JLabel();
        jPurchaseDateEnd = new JDateChooser();
        btnPurchaseShowOnTable = new JButton();
        btnPurchaseChange2Table = new JButton();
        jScrollPane3 = new JScrollPane();
        jPurchaseTable = new JTable();
        jpanelExpenses = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        txtExpType = new JTextField();
        txtExpDetails = new JTextField();
        txtExpVoucher = new JTextField();
        txtExpAmount = new JTextField();
        jLabel6 = new JLabel();
        jExpDate = new JDateChooser();
        btnExpAdd = new JButton();
        jPanel20 = new JPanel();
        jLabel55 = new JLabel();
        jExpenseDateStart = new JDateChooser();
        jLabel56 = new JLabel();
        jExpenseDateEnd = new JDateChooser();
        btnExpenseShowOnTable = new JButton();
        jScrollPane4 = new JScrollPane();
        jExpenseTable = new JTable();
        jpanelBank = new JPanel();
        jPanel10 = new JPanel();
        jPanel14 = new JPanel();
        jLabel38 = new JLabel();
        jBankDate = new JDateChooser();
        jLabel39 = new JLabel();
        jLabel40 = new JLabel();
        jLabel41 = new JLabel();
        jLabel42 = new JLabel();
        cmbBankType = new JComboBox<>();
        txtBankDetails = new JTextField();
        txtBankTransitionNo = new JTextField();
        txtBankAmount = new JTextField();
        btnBankUpdate = new JButton();
        jPanel15 = new JPanel();
        jLabel43 = new JLabel();
        lblBankAccountBalance = new JLabel();
        jPanel21 = new JPanel();
        jLabel57 = new JLabel();
        jBankDateStart = new JDateChooser();
        jLabel58 = new JLabel();
        jBankDateEnd = new JDateChooser();
        btnBankShowOnTable = new JButton();
        jScrollPane5 = new JScrollPane();
        jBankTable = new JTable();
        jpanelWitdraw = new JPanel();
        jPanel11 = new JPanel();
        jPanel12 = new JPanel();
        jLabel22 = new JLabel();
        jWitdrawDatestart = new JDateChooser();
        jWitdrawDateend = new JDateChooser();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        txtWitdrawType = new JTextField();
        txtWitdrawDetails = new JTextField();
        txtWitdrawAmount = new JTextField();
        btnWitdrawUpdate = new JButton();
        jPanel22 = new JPanel();
        jLabel59 = new JLabel();
        jWitdrawDateStart = new JDateChooser();
        jLabel60 = new JLabel();
        jWitdrawDateEnd = new JDateChooser();
        btnWitdrawShowOnTable = new JButton();
        jScrollPane6 = new JScrollPane();
        jWitdrawTable = new JTable();
        jpanelReport = new JPanel();
        jpanelSide = new JPanel();
        btnHome = new JButton();
        btnMakerInfo = new JButton();
        btnLogout = new JButton();
        btnmessage = new JButton();
        jLabel48 = new JLabel();
        jLabel49 = new JLabel();
        jLabel50 = new JLabel();
        //以下是数据统计部分
        jLabel70 = new JLabel();
        jLabel71 = new JLabel();
        jLabel72 = new JLabel();
        jLabel73 = new JLabel();
        jLabel74 = new JLabel();
        jLabel75 = new JLabel();
        jLabel76 = new JLabel();
        jLabel77 = new JLabel();
        jLabel78 = new JLabel();
        jLabel79 = new JLabel();
        jLabel80 = new JLabel();
        jLabel81 = new JLabel();
        jLabel82 = new JLabel();
        jLabel83 = new JLabel();
        jLabel84 = new JLabel();
        jLabel85 = new JLabel();
        jLabel86 = new JLabel();
        jLabel87 = new JLabel();
        jLabel88 = new JLabel();
        jLabel89 = new JLabel();
        jLabel90 = new JLabel();
        jLabel91 = new JLabel();
        jLabel92 = new JLabel();
        jLabel93 = new JLabel();
        jLabel94 = new JLabel();
        jLabel95 = new JLabel();
        jLabel96 = new JLabel();
        jLabel97 = new JLabel();
        jLabel98 = new JLabel();
        jLabel99 = new JLabel();
        jLabel100 = new JLabel();
        jLabel101 = new JLabel();
        jLabel102 = new JLabel();
        jLabel103 = new JLabel();
        jLabel104 = new JLabel();
        jLabel105 = new JLabel();
        jLabel106 = new JLabel();
        jLabel107 = new JLabel();
        jLabel108 = new JLabel();
        //jLabel101 = new JLabel();
        //设置退出方式
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //设置Title以及背景样式
        setTitle("多功能记账本 designed by Group Four");
        setBackground(new Color(153, 153, 153));
        setResizable(true);
        //设置Tab栏背景
        mainTabPane.setBackground(new Color(153, 153, 153));
        //设置主Panpel的风格颜色
        jpanelHome.setBackground(new Color(255, 255, 255));
        jpanelHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel9.setBackground(new Color(204, 204, 204));
        jPanel9.setBorder(new LineBorder(new Color(0, 0, 153), 1, true));

        jpanelHomeIcon.setBackground(new Color(255, 255, 255));
        //设置第一个按钮的Icon及动作函数
        btnTabOne.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/money.png"))); // NOI18N
        btnTabOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTabOneActionPerformed(evt);
            }
        });
        //设置第二个按钮的Icon及动作函数
        btnTabTwo.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/sale.png"))); // NOI18N
        btnTabTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTabTwoActionPerformed(evt);
            }
        });
        //设置第三个按钮的Icon及动作函数
        btnTabThree.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/buy.png"))); // NOI18N
        btnTabThree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTabThreeActionPerformed(evt);
            }
        });
        //设置第四个按钮的Icon及动作函数
        btnTabFour.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/expenses.png"))); // NOI18N
        btnTabFour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTabFourActionPerformed(evt);
            }
        });
        //设置第五个按钮的Icon及动作函数
        btnTabFive.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/bank.png"))); // NOI18N
        btnTabFive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTabFiveActionPerformed(evt);
            }
        });

        //定义消费记录Label
        jLabel18.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel18.setText("支出记录一览");
        //定义收入记录Label
        jLabel19.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel19.setText("收入记录一览");
        //定义收支记录Label
        jLabel20.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel20.setText("收支记录一览");
        //定义备忘录
        jLabel21.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel21.setText("备忘录提醒");
        //定义图表生成
        jLabel34.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel34.setText("图表生成");

        //设置第六个按钮的Icon及动作函数
        btnTabSix.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/payment.png"))); // NOI18N
        btnTabSix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTabSixActionPerformed(evt);
            }
        });
        jLabel35.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel35.setText("多功能");

        //设置第七个按钮的Icon及动作函数
        //btnTabSeven.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/report.png"))); // NOI18N
        //btnTabSeven.addActionListener(new ActionListener() {
        //    public void actionPerformed(ActionEvent evt) {
        //        btnTabSevenActionPerformed(evt);
        //    }
        //});
        //jLabel36.setFont(new Font("黑体", 1, 11)); // NOI18N
        //jLabel36.setText("设置");

        //设置第八个按钮的Icon及动作函数
        btnTabEight.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/setup.png"))); // NOI18N
        btnTabEight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTabEightActionPerformed(evt);
            }
        });
        jLabel37.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel37.setText("切换账户");
        //整合Layout以及按钮排版
        GroupLayout jpanelHomeIconLayout = new GroupLayout(jpanelHomeIcon);
        jpanelHomeIcon.setLayout(jpanelHomeIconLayout);
        jpanelHomeIconLayout.setHorizontalGroup(
            jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnTabOne, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTabSix, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel18))
                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel35)))
                .addGap(18, 18, 18)
                .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                        .addComponent(btnTabTwo, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTabThree, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTabFour, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTabFive, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                        .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            //.addComponent(btnTabSeven, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(72, 72, 72))
                            .addGroup(GroupLayout.Alignment.LEADING, jpanelHomeIconLayout.createSequentialGroup()
                                .addGap(48, 48, 48)))
                                //.addComponent(jLabel36)))
                        .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel20)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel21)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34)
                                .addGap(67, 67, 67))
                            .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                                .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTabEight, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel37)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        //同上
        jpanelHomeIconLayout.setVerticalGroup(
            jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTabThree, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTabFour, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTabFive, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTabOne, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTabTwo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel34))
                .addGap(11, 11, 11)
                .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                        .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnTabSix))
                            //.addComponent(btnTabSeven))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelHomeIconLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)))
                            //.addComponent(jLabel36)))
                    .addGroup(jpanelHomeIconLayout.createSequentialGroup()
                        .addComponent(btnTabEight)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new Color(255, 210, 109));

        jPanel16.setBackground(new Color(255, 255, 255));
        jPanel16.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        //主界面右下角的参数显示
        jLabel44.setFont(new Font("黑体", 1, 24)); // NOI18N
        jLabel44.setText("当前余额：");

        lblCashInHand.setFont(new Font("黑体", 1, 24)); // NOI18N
        lblCashInHand.setForeground(new Color(255, 0, 51));
        lblCashInHand.setText("78.00");

        jLabel45.setFont(new Font("黑体", 1, 24)); // NOI18N
        jLabel45.setForeground(new Color(255, 0, 51));
        jLabel45.setText("¥");

        GroupLayout jPanel16Layout = new GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(lblCashInHand, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
                .addGap(163, 163, 163))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(lblCashInHand))
                .addGap(54, 54, 54))
        );

        GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanelHomeIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelHomeIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jpanelHomeLayout = new GroupLayout(jpanelHome);
        jpanelHome.setLayout(jpanelHomeLayout);
        jpanelHomeLayout.setHorizontalGroup(
            jpanelHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelHomeLayout.setVerticalGroup(
            jpanelHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabPane.addTab("主界面", jpanelHome);

        //定义第一个按钮的左侧界面
        jpanelCash.setBackground(new Color(255, 255, 255));
        jpanelCash.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel3.setBackground(new Color(255, 255, 255));
        jPanel3.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jPanel4.setBackground(new Color(255, 255, 255));
        jPanel4.setBorder(BorderFactory.createTitledBorder("支出记录登记"));

        jLabel4.setText("日期");

        jCashDate.setDateFormatString("yyyy-MM-dd");

        jLabel7.setText("类型");

        jLabel8.setText("备注");

        jLabel9.setText("额度");

        btnCashAdd.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnCashAdd.setText("确 定");
        btnCashAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCashAddActionPerformed(evt);
            }
        });
        //第一个按钮页面排版
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jCashDate, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCashAdd)
                            .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCashAmount, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(63, 63, 63))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(55, 55, 55)))
                                    .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCashDetails, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCashType, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jCashDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCashType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCashDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCashAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCashAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        jPanel17.setBackground(new Color(255, 255, 255));
        jPanel17.setBorder(BorderFactory.createTitledBorder("支出记录查询"));

        jLabel46.setText("日 期：");

        jCashDateStart.setDateFormatString("yyyy-MM-dd");

        jLabel47.setText("至");

        jCashDateEnd.setDateFormatString("yyyy-MM-dd");

        btnCashDeleteTable.setText("删除");
        btnCashDeleteTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCashDeleteOnTableActionPerformed(evt);
            }
        });

        btnCashShowOnTable.setText("查询");
        btnCashShowOnTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCashShowOnTableActionPerformed(evt);
            }
        });

        jCashTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "序号", "日期", "类型", "备注", "额度"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jCashTable);

        GroupLayout jPanel17Layout = new GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCashDateStart, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCashDateEnd, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCashShowOnTable)
                    .addComponent(btnCashDeleteTable)
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCashShowOnTable)
                        .addComponent(btnCashDeleteTable)
                    .addComponent(jCashDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCashDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout jpanelCashLayout = new GroupLayout(jpanelCash);
        jpanelCash.setLayout(jpanelCashLayout);
        jpanelCashLayout.setHorizontalGroup(
            jpanelCashLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelCashLayout.setVerticalGroup(
            jpanelCashLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        //第二个按钮的界面
        mainTabPane.addTab("支出记录一览", jpanelCash);

        jpanelSale.setBackground(new Color(255, 255, 255));
        jpanelSale.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel5.setBackground(new Color(255, 255, 255));
        jPanel5.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jPanel6.setBackground(new Color(255, 255, 255));
        jPanel6.setBorder(BorderFactory.createTitledBorder("收入记录登记"));

        jLabel10.setText("日期");

        jSaleDate.setDateFormatString("yyyy-MM-dd");

        jLabel11.setText("类型");

        jLabel12.setText("备注");

        jLabel13.setText("额度");

        btnSaleAdd.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnSaleAdd.setText("确 定");
        btnSaleAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaleAddActionPerformed(evt);
            }
        });
        //第二个按钮页面排版
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(151, 151, 151)
                                                .addComponent(jLabel10)
                                                .addGap(31, 31, 31)
                                                .addComponent(jSaleDate, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnSaleAdd)
                                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                        .addComponent(jLabel13)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txtSaleAmount, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel11)
                                                                                        .addGap(63, 63, 63))
                                                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel12)
                                                                                        .addGap(55, 55, 55)))
                                                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtSaleDetails, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtSaleType, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSaleDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSaleType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(txtSaleDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(txtSaleAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaleAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
        );

        jPanel18.setBackground(new Color(255, 255, 255));
        jPanel18.setBorder(BorderFactory.createTitledBorder("收入记录查询"));

        jLabel51.setText("日 期：");

        jSaleDateStart.setDateFormatString("yyyy-MM-dd");

        jLabel52.setText("至");

        jSaleDateEnd.setDateFormatString("yyyy-MM-dd");

        btnSaleDeleteTable.setText("删除");
        btnSaleDeleteTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaleDeleteOnTableActionPerformed(evt);
            }
        });

        btnSaleShowOnTable.setText("查询");
        btnSaleShowOnTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaleShowOnTableActionPerformed(evt);
            }
        });

        jSaleTable.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "序号", "日期", "类型", "备注", "额度"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jSaleTable);

        GroupLayout jPanel18Layout = new GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSaleDateStart, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSaleDateEnd, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaleShowOnTable)
                    .addComponent(btnSaleDeleteTable)
                .addContainerGap(59, Short.MAX_VALUE))
            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaleShowOnTable)
                        .addComponent(btnSaleDeleteTable)
                    .addComponent(jSaleDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSaleDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout jpanelSaleLayout = new GroupLayout(jpanelSale);
        jpanelSale.setLayout(jpanelSaleLayout);
        jpanelSaleLayout.setHorizontalGroup(
            jpanelSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelSaleLayout.setVerticalGroup(
            jpanelSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabPane.addTab("收入记录一览", jpanelSale);

        jpanelPurchase.setBackground(new Color(255, 255, 255));
        jpanelPurchase.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel7.setBackground(new Color(255, 255, 255));
        jPanel7.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jPanel8.setBackground(new Color(255, 255, 255));
        jPanel8.setBorder(BorderFactory.createTitledBorder("收支记录查询及修改"));

        jLabel26.setText("日期");

        jPurchaseDate.setDateFormatString("yyyy-MM-dd");

        jLabel27.setText("类型");

        jLabel28.setText("收支选择");

        jLabel29.setText("备注（可选）");

        jLabel30.setText("额度下区间");

        jLabel31.setText("额度上区间");

        jLabel32.setText("日期起始");
        jdatestart.setDateFormatString("yyyy-MM-dd");

        jLabel33.setText("日期终止");
        jdateend.setDateFormatString("yyyy-MM-dd");

        btnPurchaseAdd.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnPurchaseAdd.setText("查 询");
        btnPurchaseAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPurchaseAddActionPerformed(evt);
            }
        });

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jPurchaseDate, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPurchaseType, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(txtPurchase2Choose)
                                .addComponent(txtPurchase6)
                                .addComponent(txtPurchase5, GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPurchase7, GroupLayout.Alignment.TRAILING))))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE))
        )));
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPurchaseDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtPurchaseType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtPurchase2Choose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtPurchase6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtPurchase5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtPurchase7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel19.setBackground(new Color(255, 255, 255));
        jPanel19.setBorder(BorderFactory.createTitledBorder("收支情况查询结果"));

        jLabel53.setText("日期");

        jPurchaseDateStart.setDateFormatString("yyyy-MM-dd");

        jLabel54.setText("至");

        jPurchaseDateEnd.setDateFormatString("yyyy-MM-dd");

        btnPurchaseChangeTable.setText("删除");
        btnPurchaseChangeTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //System.out.println(jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),5).equals("支出"));
                if(jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),5).equals("支出")) {
                    setBtnPurchaseChangeTableTableActionPerformed1(evt);
                    System.out.println("done1!");
                }
                else{
                    setBtnPurchaseChangeTableTableActionPerformed2(evt);
                    System.out.println("done2!");
                }
            }
        });

        btnPurchaseShowOnTable.setText("查询");
        btnPurchaseShowOnTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPurchaseShowOnTableActionPerformed(evt);
            }
        });
        btnPurchaseChange2Table.setText("更改");
        btnPurchaseChange2Table.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                btnPurchaseChangeActionPerformed(evt);
            }
        });

        jPurchaseTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "序号", "日期", "类型", "备注", "额度","收入/支出"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jPurchaseTable);

        GroupLayout jPanel19Layout = new GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPurchaseDateStart, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPurchaseDateEnd, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPurchaseShowOnTable)
                .addComponent(btnPurchaseChangeTable)
                .addComponent(btnPurchaseChange2Table)
                .addContainerGap(55, Short.MAX_VALUE))
            .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPurchaseShowOnTable)
                    .addComponent(btnPurchaseChangeTable)
                    .addComponent(btnPurchaseChange2Table)
                    .addComponent(jPurchaseDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPurchaseDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout jpanelPurchaseLayout = new GroupLayout(jpanelPurchase);
        jpanelPurchase.setLayout(jpanelPurchaseLayout);
        jpanelPurchaseLayout.setHorizontalGroup(
            jpanelPurchaseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jpanelPurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelPurchaseLayout.setVerticalGroup(
            jpanelPurchaseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jpanelPurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabPane.addTab("收支记录一览", jpanelPurchase);

        jpanelExpenses.setBackground(new Color(255, 255, 255));
        jpanelExpenses.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setBorder(BorderFactory.createTitledBorder("备忘录提醒"));

        btnExpAdd.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnExpAdd.setText("添 加");
        btnExpAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExpAddActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                //.addComponent(jLabel6)
                //.addGap(34, 34, 34)
                //.addComponent(jExpDate, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                //.addGap(47, 47, 47))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    //.addComponent(txtExpType, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                    //.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        //.addGroup(jPanel2Layout.createSequentialGroup()
                            //.addContainerGap()
                        .addComponent(jbeiwang, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                        //.addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            //.addGap(23, 23, 23)
                            //.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                //.addComponent(jLabel1)
                                //.addComponent(jLabel2)
                                //.addComponent(jLabel3)
                                //.addComponent(jLabel5))
                            //.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                //.addGroup(jPanel2Layout.createSequentialGroup()
                                    //.addGap(28, 28, 28)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnExpAdd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
                                        //.addComponent(txtExpDetails, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
                                //.addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    //.addGap(141, 141, 141)
                                    //.addComponent(txtExpAmount, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))))
                //.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        ));
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                //.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    //.addComponent(jLabel6)
                    //.addComponent(jExpDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                //.addGap(59, 59, 59)
                //.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jLabel1)
                    //.addComponent(txtExpType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                //.addGap(39, 39, 39)
                //.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jLabel2)
                    //.addComponent(txtExpDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                //.addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jLabel3)
                    .addComponent(jbeiwang, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                //.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jLabel5)
                    //.addComponent(txtExpAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExpAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)));

        jPanel20.setBackground(new Color(255, 255, 255));
        jPanel20.setBorder(BorderFactory.createTitledBorder("备忘录内容显示"));

        jLabel55.setText("日期：");

        jExpenseDateStart.setDateFormatString("yyyy-MM-dd");

        jLabel56.setText("至");

        jExpenseDateEnd.setDateFormatString("yyyy-MM-dd");

        btnExpenseShowOnTable.setText("显示");
        btnExpenseShowOnTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExpenseShowOnTableActionPerformed(evt);
            }
        });

        jExpenseTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "日期","备忘录内容"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jExpenseTable);

        GroupLayout jPanel20Layout = new GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jExpenseDateStart, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jExpenseDateEnd, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExpenseShowOnTable)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExpenseShowOnTable)
                    .addComponent(jExpenseDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jExpenseDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout jpanelExpensesLayout = new GroupLayout(jpanelExpenses);
        jpanelExpenses.setLayout(jpanelExpensesLayout);
        jpanelExpensesLayout.setHorizontalGroup(
            jpanelExpensesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelExpensesLayout.setVerticalGroup(
            jpanelExpensesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabPane.addTab("备忘录提醒", jpanelExpenses);

        jpanelBank.setBackground(new Color(255, 255, 255));
        jpanelBank.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel10.setBackground(new Color(255, 255, 255));
        jPanel10.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jPanel14.setBackground(new Color(255, 255, 255));
        jPanel14.setBorder(BorderFactory.createTitledBorder("图表生成"));

        //jLabel38.setText("Date");

        //jBankDate.setDateFormatString("yyyy-MM-dd");

        jLabel39.setText("图表生成1");

        jLabel40.setText("图表生成2");

        jLabel41.setText("图表生成3");

        jLabel102.setText("图表生成4");

        jLabel103.setText("图表生成5");

        jLabel104.setText("图表生成6");

        jLabel99.setText("         月支出柱状图     ");
        jLabel100.setText("         日支出折线图     ");
        jLabel101.setText("年支出各消费类型占比饼图");
        jLabel105.setText("各年总收入与总支出柱状图");
        jLabel106.setText("各月总收入与总支出折线图");
        jLabel107.setText("一年中各月总支出占比饼状图");

        //jLabel42.setText("Amount");

        //cmbBankType.setModel(new DefaultComboBoxModel<>(new String[] { "Cash Deposit", "Cash Witdraw" }));

        btnBankUpdate.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnBankUpdate.setText("生成图表");
        btnBankUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
//                clean_table("consume_barchart");
//                clean_table("consume_line_cache");
//                clean_table("consume_line");
//                clean_table("consume_total");
//                clean_table("consume_barchart2");
//                clean_table("consume_line2");
//                clean_table("consume_line2_cache");
//                clean_table("consume_total2");
                try {
                    Bar1();
                    Line1();
                    Pie1();
                    Bar2();
                    //Line2();
                    Pie2();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                B.BarChartDemo.main(null);
                B.BarChartDemo2.main(null);
                D.Line.main(null);
                D.Line2.main(null);
                E.PieChart.main(null);
                E.PieChart2.main(null);
            }
        });

        btnTab1.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnTab1.setText("生成图表");
        btnTab1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
//                    clean_table("consume_barchart");
                     Bar1();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                B.BarChartDemo.main(null);
            }
        });
        btnTab2.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnTab2.setText("生成图表");
        btnTab2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
//                clean_table("consume_line_cache");
//                clean_table("consume_line");
                Line1();
                D.Line.main(null);
            }
        });
        btnTab3.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnTab3.setText("生成图表");
        btnTab3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
//                clean_table("consume_total");
                Pie1();
                E.PieChart.main(null);
            }
        });

        btnTab4.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnTab4.setText("生成图表");
        btnTab4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
//                clean_table("consume_barchart2");
                Bar2();
                B.BarChartDemo2.main(null);
            }
        });
        btnTab5.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnTab5.setText("生成图表");
        btnTab5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
//                clean_table("consume_line2");
//                clean_table("consume_line2_cache");
                //Line2();
                D.Line2.main(null);
            }
        });
        btnTab6.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnTab6.setText("生成图表");
        btnTab6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
//                clean_table("consume_total2");
                Pie2();
                E.PieChart2.main(null);
            }
        });
        jPanel15.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 102)));

        jLabel43.setFont(new Font("黑体", 1, 14)); // NOI18N
        jLabel43.setText("图表生成");

        lblBankAccountBalance.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblBankAccountBalance.setForeground(new Color(204, 0, 0));
        lblBankAccountBalance.setText("00.00");

        GroupLayout jPanel15Layout = new GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel43, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblBankAccountBalance, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(lblBankAccountBalance, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        GroupLayout jPanel14Layout = new GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            //.addGroup(jPanel14Layout.createSequentialGroup()
                                //.addComponent(jLabel42)
                                //.addGap(175, 175, 175)
                                //.addComponent(txtBankAmount, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()

                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                            .addComponent(jLabel39,GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel99, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTab1,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))

                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        //.addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel100, GroupLayout.PREFERRED_SIZE,170, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnTab2,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))

                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                                .addComponent(jLabel41,GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel101,GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnTab3,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))

                                                .addGroup(jPanel14Layout.createSequentialGroup()
                                                        .addGap(15, 15, 15)
                                                        .addComponent(jLabel102,GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel105,GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnTab4,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))

                                                .addGroup(jPanel14Layout.createSequentialGroup()
                                                        .addGap(15, 15, 15)
                                                        .addComponent(jLabel103,GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel106,GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnTab5,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))

                                                .addGroup(jPanel14Layout.createSequentialGroup()
                                                        .addGap(15, 15, 15)
                                                        .addComponent(jLabel104,GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel107,GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnTab6,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))


                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(200, 200, 200)
                                                .addComponent(btnBankUpdate, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                        )))
                        ))
                        //.addGroup(jPanel14Layout.createSequentialGroup()
                            //.addGap(126, 126, 126)
                            //.addComponent(jLabel38)
                            //.addGap(18, 18, 18)
                            //.addComponent(jBankDate, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                //.addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    //.addComponent(jLabel38)
                    //.addComponent(jBankDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                //.addGap(62, 62, 62)
                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel99, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTab1))

                    .addGap(47, 47, 47)
                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel100, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTab2))
                    .addGap(47, 47, 47)
                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel101, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTab3))
                    .addGap(47, 47, 47)
                    .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102)
                            .addComponent(jLabel105, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTab4))
                    .addGap(47, 47, 47)
                    .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel103)
                            .addComponent(jLabel106, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTab5))
                    .addGap(47, 47, 47)
                    .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(jLabel107, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTab6))
                    .addGap(47, 47, 47)
                //.addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jLabel42)
                    //.addComponent(txtBankAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBankUpdate, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel21.setBackground(new Color(255, 255, 255));
        jPanel21.setBorder(BorderFactory.createTitledBorder("消费类型汇总"));

        jLabel57.setText("日期（年-月）");

        jBankDateStart.setDateFormatString("yyyy-MM");

        jLabel58.setText("至");

        jBankDateEnd.setDateFormatString("yyyy-MM");

        btnBankShowOnTable.setText("查 询");
        btnBankShowOnTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    btnBankShowOnTableActionPerformed(evt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        jBankTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "序号", "消费类型", "月份", "年份", "额度"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jBankTable);

        GroupLayout jPanel21Layout = new GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBankDateStart, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBankDateEnd, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBankShowOnTable)
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBankShowOnTable)
                    .addComponent(jBankDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBankDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout jpanelBankLayout = new GroupLayout(jpanelBank);
        jpanelBank.setLayout(jpanelBankLayout);
        jpanelBankLayout.setHorizontalGroup(
            jpanelBankLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelBankLayout.setVerticalGroup(
            jpanelBankLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabPane.addTab("图表生成", jpanelBank);

        //以下为数据统计界面
        jpanelWitdraw.setBackground(new Color(255, 255, 255));
        jpanelWitdraw.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jPanel11.setBackground(new Color(255, 255, 255));
        jPanel11.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        jPanel12.setBackground(new Color(255, 255, 255));
        jPanel12.setBorder(BorderFactory.createTitledBorder("数据统计功能"));

        jLabel70.setText("日期选择(年-月)：");

        jWitdrawDatestart.setDateFormatString("yyyy-MM");
        jWitdrawDateend.setDateFormatString("yyyy-MM");

        jLabel71.setText("至");
        jLabel72.setText("类型：");
        jLabel73.setText("月消费收入统计:  ");
        jLabel74.setText("月消费的总值:    ");
        jLabel75.setText("月消费的平均值:  ");
        jLabel76.setText("月收入的总值:    ");
        jLabel77.setText("月收入的平均值:  ");
        jLabel78.setText("月消费最多的月份:");

        jLabel79.setText("年消费收入统计:  ");
        jLabel80.setText("年消费的总值:    ");
        jLabel81.setText("年消费的平均值:  ");
        jLabel82.setText("年收入的总值:    ");
        jLabel83.setText("年收入的平均值:  ");
        jLabel84.setText("年消费最多的年份:");

        jLabel85.setText("0");
        jLabel86.setText("0");
        jLabel87.setText("0");
        jLabel88.setText("0");
        jLabel89.setText("0");
        jLabel90.setText("0");
        jLabel90.setText("0");
        jLabel91.setText("0");
        jLabel92.setText("0");
        jLabel93.setText("0");
        jLabel94.setText("0");
        jLabel95.setText("0");
        jLabel96.setText("0");
        jLabel97.setText("0");
        jLabel98.setText("0");

        btnWitdrawUpdate.setFont(new Font("黑体", 0, 14)); // NOI18N
        btnWitdrawUpdate.setText("更 新");
        btnWitdrawUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    btnWitdrawShowOnTableActionPerformed(evt);
                    int clon = 1;
                    int sum_shouru = 0;
                    int sum_zhichu = 0;
                    int count_shouru = 0;
                    int count_zhichu = 0;
                    int max_zhichu = 0;
                    int temp = 0;
                    int year_count=0;
                    int max_year = 0;
                    for(int i=0;i<jWitdrawTable.getRowCount();i++){
                        if(jWitdrawTable.getValueAt(i,4).equals("收入")){
                         int onecell = (int)jWitdrawTable.getValueAt(i,clon);
                         sum_shouru = sum_shouru + onecell;
                         count_shouru++;
                        }
                        if(jWitdrawTable.getValueAt(i,4).equals("支出")){
                            int onecell = (int)jWitdrawTable.getValueAt(i,clon);
                            if(onecell>max_zhichu){
                                max_zhichu = (int)jWitdrawTable.getValueAt(i,2);
                                max_year = (int)jWitdrawTable.getValueAt(i,3);
                            }
                            sum_zhichu = sum_zhichu + onecell;
                            count_zhichu++;
                        }
                    }
                    for(int i=0;i<jWitdrawTable.getRowCount();i++){
                        int onecell = (int)jWitdrawTable.getValueAt(i,3);
                        if(onecell != temp){
                            temp = onecell;
                            year_count++;
                        }
                    }
                    jLabel85.setText(String.valueOf(sum_zhichu));
                    jLabel86.setText(String.valueOf(sum_zhichu/count_zhichu));
                    jLabel87.setText(String.valueOf(sum_shouru));
                    jLabel88.setText(String.valueOf(sum_shouru/count_shouru));
                    jLabel89.setText(String.valueOf(max_zhichu));
                    jLabel90.setText(String.valueOf(sum_zhichu));
                    jLabel91.setText(String.valueOf(sum_zhichu/year_count));
                    jLabel92.setText(String.valueOf(sum_shouru));
                    jLabel93.setText(String.valueOf(sum_shouru/year_count));
                    jLabel94.setText(String.valueOf(max_year));
                    System.out.println("\n"+sum_shouru+"   "+sum_zhichu);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnWitdrawUpdate)
                .addGap(54, 54, 54))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(32, 32, 32)//水平总体间距
                        .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(64, 64, 64))//水平组件间距
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel78)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel89))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel77)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel88))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel76)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel87))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel75)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel86))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel85)))

                            .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addGap(64, 64, 64))//水平组件间距
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel84)
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel94))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel83)
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel93))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel82)
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel92))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel81)
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel91))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel80)
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel90))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel79)
                                            .addGap(60, 60, 60))))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel73))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel70)
                        .addGap(39, 39, 39)
                        .addComponent(jWitdrawDatestart, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                    .addGap(20,20,20)
                            .addComponent(jLabel71)
                            .addGap(20,20,20)
                    .addComponent(jWitdrawDateend, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel70)
                    .addComponent(jWitdrawDatestart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71)
                        .addComponent(jWitdrawDateend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel73)
                            .addGap(20, 20, 20))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel85,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel86,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel87,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel88,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel89,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78)
                            .addGap(30, 30, 30))

                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel79)
                            .addGap(40, 40, 40))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel90,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel91,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel92,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel93,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83)
                            .addGap(30, 30, 30))
                    .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel94,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84)
                            .addGap(30, 30, 30))
                //.addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING))
                        //.addComponent(jLabel22)
                    //.addComponent(jLabel23)
                //.addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jLabel24))
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                    //.addComponent(jLabel25)
                    //.addComponent(txtWitdrawAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnWitdrawUpdate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)));

        jPanel22.setBackground(new Color(255, 255, 255));
        jPanel22.setBorder(BorderFactory.createTitledBorder("收支总额数据统计"));

        //jLabel59.setText("Date");

        //jWitdrawDateStart.setDateFormatString("yyyy-MM-dd");

        //jLabel60.setText("To");

        //jWitdrawDateEnd.setDateFormatString("yyyy-MM-dd");

        //btnWitdrawShowOnTable.setText("Show All");
        //btnWitdrawShowOnTable.addActionListener(new ActionListener() {
        //    public void actionPerformed(ActionEvent evt) {
         //       btnWitdrawShowOnTableActionPerformed(evt);
         //   }
        //});

        jWitdrawTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "序号", "总额度", "月份", "年份","收支"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        //以下可以加图片
        //JLabel jl3=new JLabel(new ImageIcon("1jpg"));
        //jScrollPane6.add(jl3);
        //jl3.setBounds(0, 150, 700, 500);
        //以下可注释
        jScrollPane6.setViewportView(jWitdrawTable);

        GroupLayout jPanel22Layout = new GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                //.addComponent(jLabel59)
                //.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                //.addComponent(jWitdrawDateStart, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(jLabel60)
                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(jWitdrawDateEnd, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(btnWitdrawShowOnTable)
                //.addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        ));
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    //.addComponent(btnWitdrawShowOnTable)
                    //.addComponent(jWitdrawDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    //.addComponent(jWitdrawDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    //.addComponent(jLabel59)
                    //.addComponent(jLabel60))
                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                //.addContainerGap())
        )));
        //以上可注释
        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout jpanelWitdrawLayout = new GroupLayout(jpanelWitdraw);
        jpanelWitdraw.setLayout(jpanelWitdrawLayout);
        jpanelWitdrawLayout.setHorizontalGroup(
            jpanelWitdrawLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelWitdrawLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelWitdrawLayout.setVerticalGroup(
            jpanelWitdrawLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelWitdrawLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabPane.addTab("多功能", jpanelWitdraw);

        jpanelReport.setBackground(new Color(255, 255, 255));
        jpanelReport.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        GroupLayout jpanelReportLayout = new GroupLayout(jpanelReport);
        jpanelReport.setLayout(jpanelReportLayout);
        jpanelReportLayout.setHorizontalGroup(
            jpanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        jpanelReportLayout.setVerticalGroup(
            jpanelReportLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        //mainTabPane.addTab("设置", jpanelReport);

        jpanelSide.setBackground(new Color(255, 255, 255));
        jpanelSide.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        btnHome.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/home.png"))); // NOI18N
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sub("data_all");
                btnHomeActionPerformed(evt);
            }
        });

        btnmessage.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/home.png"))); // NOI18N
        btnmessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnmessageActionPerformed(evt);
            }
        });

        btnMakerInfo.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/user_info.png"))); // NOI18N
        btnMakerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMakerInfoActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new ImageIcon(getClass().getResource("/com/aeontanvir/img/logout.png"))); // NOI18N
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel48.setFont(new Font("退出", 1, 11)); // NOI18N
        jLabel48.setForeground(new Color(204, 0, 0));
        jLabel48.setText("退出");

        jLabel49.setFont(new Font("黑体", 1, 11)); // NOI18N
        jLabel49.setText("主界面");

        jLabel108.setFont(new Font("黑体",1,11));
        jLabel108.setText("意见反馈");

        jLabel50.setFont(new Font("关于我们", 1, 11)); // NOI18N
        jLabel50.setForeground(new Color(102, 102, 102));
        jLabel50.setText("关于我们");

        GroupLayout jpanelSideLayout = new GroupLayout(jpanelSide);
        jpanelSide.setLayout(jpanelSideLayout);
        jpanelSideLayout.setHorizontalGroup(
            jpanelSideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelSideLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel49)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpanelSideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelSideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelSideLayout.createSequentialGroup()
                        //.addGap(10, 10, 10)
                        .addComponent(jLabel50)
                        .addGap(0, 0, Short.MAX_VALUE)
                        //.addGap(10,10,10)
                    )
                        .addGap(31,31,31)
                        .addComponent(jLabel108)
                        .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jpanelSideLayout.createSequentialGroup()
                        .addGroup(jpanelSideLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnMakerInfo, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnmessage,GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jpanelSideLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel48)
                        .addGap(23, 23, 23))))
        );
        jpanelSideLayout.setVerticalGroup(
            jpanelSideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpanelSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addComponent(btnHome)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                    .addGap(18,18,18)
                    .addComponent(btnmessage)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel108)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMakerInfo, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addGap(6, 6, 6))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabPane)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpanelSide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(mainTabPane)
                    .addComponent(jpanelSide, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCashAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashAddActionPerformed
        String date = ((JTextField) jCashDate.getDateEditor().getUiComponent()).getText();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        jCashDate.setDateFormatString(df.format(new Date()));
        if ("".equals(txtCashType.getSelectedItem()) || "".equals(txtCashDetails.getText()) || "".equals(txtCashAmount.getText()) || "".equals(date)) {
            JOptionPane.showMessageDialog(rootPane, "输入为空！请重新输入！");
        }
        else {
            int n = CashAccount.cashIn(txtCashType.getSelectedItem().toString(), txtCashDetails.getText(), date, txtCashAmount.getText());
            if (n > 0) {
                try {
                    updateInfo();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane, "成功录入消费记录信息！！");
                SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                System.out.println(d.format(new Date()));// new Date()为获取当前系统时间
                //jCashDate.setDateFormatString(df.format(new Date()));
                txtCashDetails.setText("");
                txtCashAmount.setText("");

            } else {
                JOptionPane.showMessageDialog(rootPane, "金额输入不是数字！请重新输入！");
                try {
                    ErrorHelper.exceptionError("btnCashAddActionPerformed");
                } catch (Exception ex) {
                }
            }

        }
    }//GEN-LAST:event_btnCashAddActionPerformed

    private void Bar1() throws ParseException {
        Connection conn = null;
        PreparedStatement psm =null;
        ResultSet rs = null;
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM");
        try{
            conn = DatabaseConnection.getConnection();
            rs = Statistics_type2("data_all");
            String sql = "INSERT INTO consume_barchart values(?,?,?)";
            psm = conn.prepareStatement(sql);
            while(rs.next()) {
                //psm.setString(1, tablename);
                psm.setInt(1, rs.getInt(1));
                psm.setString(2, rs.getString(4));
                psm.setInt(3, rs.getInt(2));
                System.out.println(psm);
                psm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ResultSet Statistics_type2(String tablename){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Calendar time = Calendar.getInstance();
        int year_now = time.get(Calendar.YEAR);
        try{
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            String shouzhi = "支出";
            String sql = "select sum(money) as money, month(date) as month, year(date) as year, type from "
                    + tablename +
                    " where year(date) = '" +
                    year_now +
                    "' and status = '" +
                    shouzhi
                    +"' and user = '"
                    +name
                    +"' group by month(date),year(date),type";
            System.out.print(sql);
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            return rs;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Static_shouzhi_error" + ex);
        }
        return rs;
    }

    private void Bar2(){
        Connection conn = null;
        PreparedStatement psm =null;
        ResultSet rs = null;
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM");
        try{
            conn = DatabaseConnection.getConnection();
            rs = Statistics_shouzhi_month_sum2("data_all");
            String sql = "INSERT INTO consume_barchart2 values(?,?,?)";
            psm = conn.prepareStatement(sql);
            while(rs.next()) {
                //psm.setString(1, tablename);
                psm.setInt(1, rs.getInt(1));
                psm.setString(2, rs.getString(3));
                psm.setInt(3, rs.getInt(2));
                System.out.println(psm);
                psm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ResultSet Statistics_shouzhi_month_sum2(String tablename) {
        Connection conn = null;
        PreparedStatement psm =null;
        ResultSet rs = null;
        int sum0 = 0;
        try{
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            //String sql = "select sum(money),month(date) from "
            //        + tablename
            //        + " where date between '"
            //        + datestart0
            //        +"' and '"
            //        +dateend0
            //        +"'"
            //        + "and status='"
            //        +shouzhi
            //        +"'";

            String sql0 = "select sum(money) as revenue, year(date) as year, status from "
                    + tablename
                    +" where user = '" +
                    name +
                    "'"+
                    " group by year(date),status";
            System.out.print(sql0);
            psm = conn.prepareStatement(sql0);

            rs = psm.executeQuery();
            return rs;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Static_shouzhi_error" + ex);
        }
        return rs;
    }

    private ResultSet zhichu_type(String tablename) {
        Connection conn = null;
        PreparedStatement psm =null;
        ResultSet rs = null;
        int sum0 = 0;
        try{
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();

            String sql0 = "Select sum(money),type,date from " +
                    tablename
                    +" where user = '" +
                    name +
                    "'"+
                    " group by type,date,status";
            psm = conn.prepareStatement(sql0);
            System.out.print(psm);
            rs = psm.executeQuery();

            return rs;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Static_shouzhi_error" + ex);
        }
        return rs;
    }

    private void mix(){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            rs = zhichu_type("data_all");
            String sql = "INSERT INTO consume_line_cache values(?,?,?,?,?,?)";
            psm = conn.prepareStatement(sql);
            while(rs.next()){
                if(rs.getString(2).equals("美食")){
                    psm.setInt(1,rs.getInt(1));
                    psm.setInt(2,0);
                    psm.setInt(3,0);
                    psm.setInt(4,0);
                    psm.setInt(5,0);
                }
                else if(rs.getString(2).equals("交通")){
                    psm.setInt(3,rs.getInt(1));
                    psm.setInt(1,0);
                    psm.setInt(2,0);
                    psm.setInt(4,0);
                    psm.setInt(5,0);
                }
                else if(rs.getString(2).equals("生活用品")){
                    psm.setInt(4,rs.getInt(1));
                    psm.setInt(1,0);
                    psm.setInt(2,0);
                    psm.setInt(3,0);
                    psm.setInt(5,0);
                }
                else if(rs.getString(2).equals("服装")){
                    psm.setInt(2,rs.getInt(1));
                    psm.setInt(1,0);
                    psm.setInt(3,0);
                    psm.setInt(4,0);
                    psm.setInt(5,0);
                }
                else if(rs.getString(2).equals("娱乐")){
                    psm.setInt(5,rs.getInt(1));
                    psm.setInt(1,0);
                    psm.setInt(2,0);
                    psm.setInt(3,0);
                    psm.setInt(4,0);
                }
                psm.setDate(6,rs.getDate(3));
                psm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ResultSet Line_cache(String tablename) throws SQLException {
        mix();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            String sql = "select sum(Food),sum(Clothe),sum(Transports),sum(Live),sum(Entertainments),date from "+
                    tablename +
                    " group by date";
            psm = conn.prepareStatement(sql);
            rs =psm.executeQuery();
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void Line1() {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnection.getConnection();
            rs = Line_cache("consume_line_cache");
            String sql = "INSERT INTO consume_line values(?,?,?,?,?,?)";
            psm = conn.prepareStatement(sql);
            while (rs.next()) {
                psm.setInt(1, rs.getInt(1));
                psm.setInt(2, rs.getInt(2));
                psm.setInt(3, rs.getInt(3));
                psm.setInt(4, rs.getInt(4));
                psm.setInt(5, rs.getInt(5));
                psm.setDate(6, rs.getDate(6));
                psm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ResultSet Line2_cache0(String tablename){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Calendar time = Calendar.getInstance();
        int year_now = time.get(Calendar.YEAR);
        try{
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            String sql = "select sum(money),month(date),status from "
                    + tablename +
                    " where year(date) = '"
                    + year_now
                    +"' and user = '"
                    + name
                    + "' group by month(date),status";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            return rs;
        }catch( SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return rs;
    }

    private void Line2_cache1() {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnection.getConnection();
            rs = Line2_cache0("data_all");
            String sql = "INSERT INTO consume_line2_cache values(?,?,?)";
            System.out.println(sql);
            psm = conn.prepareStatement(sql);
            while (rs.next()) {
                if (rs.getString(3).equals("收入")) {
                    psm.setInt(1, rs.getInt(1));
                    psm.setInt(2, 0);
                    psm.setInt(3, rs.getInt(2));
                }
                if (rs.getString(3).equals("支出")) {
                    psm.setInt(1, 0);
                    psm.setInt(2, rs.getInt(1));
                    psm.setInt(3, rs.getInt(2));
                }
                psm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ResultSet Line2_cache2(String tablename) {
        Line2_cache1();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnection.getConnection();

            String sql = "select * from "
                         + tablename +
                         " group by month";
            System.out.println(sql);
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
                return rs;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void Line2() {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DatabaseConnection.getConnection();
            rs = Line2_cache2("consume_line2_cache");
            String sql = "INSERT INTO consume_line2 values(?,?,?)";
            psm = conn.prepareStatement(sql);
            while (rs.next()) {
                psm.setInt(1, rs.getInt(1));
                psm.setInt(2, rs.getInt(2));
                psm.setInt(3, rs.getInt(3));
                psm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ResultSet Pie_cache(String tablename){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Calendar time = Calendar.getInstance();
        int year_now = time.get(Calendar.YEAR);
        String zhichu = "支出";
        try{
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            String sql = "select sum(money),type,status from "
                    + tablename
                    + " where year(date) ="
                    + year_now
                    +" and user = '"
                    + name
                    +"' group by type,status";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            return rs;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    private void Pie1(){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            rs = Pie_cache("data_all");
            String sql = "INSERT INTO consume_total values(?,?)";
            psm = conn.prepareStatement(sql);
            while(rs.next()){
                if(rs.getString(3).equals("支出")) {
                    psm.setString(1, rs.getString(2));
                    psm.setInt(2, rs.getInt(1));
                }
                psm.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet Pie2_cache(String tablename){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Calendar time = Calendar.getInstance();
        int year_now = time.get(Calendar.YEAR);
        try{
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            String sql = "select sum(money),month(date),status from "
                    +tablename
                    +" where year(date) = "
                    +year_now
                    +" and user = '"
                    + name
                    +"' group by month(date),status";
                    psm = conn.prepareStatement(sql);
                    rs = psm.executeQuery();
                    return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void Pie2(){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            rs = Pie2_cache("data_all");
            String sql = "INSERT INTO consume_total2 values(?,?)";
            psm = conn.prepareStatement(sql);
            while(rs.next()){
                if(rs.getString(3).equals("支出")) {
                    psm.setInt(1, rs.getInt(2));
                    psm.setInt(2, rs.getInt(1));
                }
                psm.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void btnExpAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpAddActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        if (jbeiwang.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "备忘录内容为空，请重新输入！！");
        } else {
            Connection conn = null;
            PreparedStatement psm = null;
            try {
                conn = DatabaseConnection.getConnection();
                String sql = "INSERT INTO note VALUES(?,?)";
                psm = conn.prepareStatement(sql);
                psm.setString(1, date);
                psm.setString(2, jbeiwang.getText());

                int t = psm.executeUpdate();

                //int n = CashAccount.cashIn(txtExpType.getText(), txtExpDetails.getText(), now, txtExpAmount.getText());
                if(!jbeiwang.getText().equals("")){
                    updateInfo();
                    JOptionPane.showMessageDialog(rootPane, "备忘录录入成功！！");
                    jExpDate.setDate(null);
                    jbeiwang.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "备忘录录入失败！！");
                    try {
                        ErrorHelper.exceptionError("btnExpAddActionPerformed");
                    } catch (Exception ex) {
                    }
                }
            } catch (Exception ex) {
                System.err.println("btnExpAddActionPerformed" + ex);
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

    private void btnSaleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleAddActionPerformed
        String date = ((JTextField) jSaleDate.getDateEditor().getUiComponent()).getText();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        jSaleDate.setDateFormatString(df.format(new Date()));
        if ("".equals(txtSaleType.getSelectedItem()) || "".equals(txtSaleDetails.getText()) || "".equals(txtSaleAmount.getText()) || "".equals(date)) {
            JOptionPane.showMessageDialog(rootPane, "输入为空！请重新输入！");
        }
        else {

            int n = SaleAccount.saleIn(txtSaleType.getSelectedItem().toString(), txtSaleDetails.getText(), date, txtSaleAmount.getText());
            if (n > 0) {
                try {
                    updateInfo();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane, "成功录入收入记录信息！！");
                SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                System.out.println(d.format(new Date()));// new Date()为获取当前系统时间
                //jSaleDate.setDateFormatString(df.format(new Date()));
                txtSaleDetails.setText("");
                txtSaleAmount.setText("");

            } else {
                JOptionPane.showMessageDialog(rootPane, "金额输入不是数字！请重新输入！");
                try {
                    ErrorHelper.exceptionError("btnSaleAddActionPerformed");
                } catch (Exception ex) {
                }
            }

        }
    }//GEN-LAST:event_btnCashAddActionPerformed

    private void btnPurchaseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseAddActionPerformed
        String dateStart = ((JTextField) jPurchaseDateStart.getDateEditor().getUiComponent()).getText();
        String dateEnd = ((JTextField) jPurchaseDateEnd.getDateEditor().getUiComponent()).getText();
        if ( "".equals(txtPurchase5.getText()) || "".equals(txtPurchase7.getText()) || "".equals(dateStart) ||"".equals(dateEnd)) {
            JOptionPane.showMessageDialog(rootPane, "信息查询输入错误！！请重新输入！");
        } else {
            try {
                ResultSet rs = tableDataBetweenDate(dateStart, dateEnd, "data_all","收入");
                DefaultTableModel dtm = (DefaultTableModel) jPurchaseTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[6];
                int no = 1;

                while (rs.next()) {
                    tempObject[0] = no++;
                    tempObject[1] = rs.getDate(4);
                    tempObject[2] = rs.getString(2);
                    tempObject[3] = rs.getString(3);
                    tempObject[4] = rs.getInt(5);
                    tempObject[5] = rs.getString(6);//这行可以去掉
                    dtm.addRow(tempObject);
                }
            } catch (Exception ex) {
                System.out.println("btnPurchaseShowOnTableActionPerformed" + ex);
            }

        }
    }


    private int Statistics_shouzhi_month_avg(String tablename,String shouzhi){
        String datestart0 = ((JTextField) jWitdrawDatestart.getDateEditor().getUiComponent()).getText();
        String dateend0 = ((JTextField) jWitdrawDateend.getDateEditor().getUiComponent()).getText();
        Connection conn = null;
        PreparedStatement psm =null;
        ResultSet rs = null;
        int avg0 = 0;
        try{
            conn = DatabaseConnection.getConnection();
            String sql = "select avg(money) from "
                    + tablename
                    + " where date between '"
                    + datestart0
                    +"' and '"
                    +dateend0
                    +"'"
                    + "and status='"
                    +shouzhi
                    +"'";
            System.out.print(sql);
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();
            while (rs.next()) {
                avg0 = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException ex
        ) {
            System.err.println("columnSum " + ex);
        } finally {
            if (conn != null || psm != null || rs != null) {
                try {
                    conn.close();
                    psm.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return avg0;
    }

    private void btnWitdrawUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWitdrawUpdateActionPerformed
        String date = ((JTextField) jWitdrawDate.getDateEditor().getUiComponent()).getText();

        if ("".equals(txtWitdrawType.getText()) || "".equals(txtWitdrawDetails.getText()) || "".equals(txtWitdrawAmount.getText()) || "".equals(date)) {
            JOptionPane.showMessageDialog(rootPane, "Enter value on field");
        } else {
            Connection conn = null;
            PreparedStatement psm = null;
            try {
                conn = DatabaseConnection.getConnection();
                String sql = "INSERT INTO witdraws_ac(type, details, date, amount) VALUES(?,?,?,?)";
                psm = conn.prepareStatement(sql);
                psm.setString(1, txtWitdrawType.getText());
                psm.setString(2, txtWitdrawDetails.getText());
                psm.setString(3, date);
                psm.setString(4, txtWitdrawAmount.getText());

                int t = psm.executeUpdate();

                int n = CashAccount.cashIn(txtWitdrawType.getText(), txtWitdrawDetails.getText(), date, txtWitdrawAmount.getText());
                if (n > 0 && t > 0) {
                    updateInfo();
                    JOptionPane.showMessageDialog(rootPane, "Witdraw account update Successfully");
                    jWitdrawDate.setDate(null);
                    txtWitdrawType.setText("");
                    txtWitdrawDetails.setText("");
                    txtWitdrawAmount.setText("");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "No Entry Execute Successfully");
                    try {
                        ErrorHelper.exceptionError("btnWitdrawUpdateActionPerformed");
                    } catch (Exception ex) {
                    }
                }
            } catch (Exception ex) {
                System.err.println("btnWitdrawUpdateActionPerformed" + ex);
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
    }//GEN-LAST:event_btnWitdrawUpdateActionPerformed

    // btn start
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        try {
            cashBalanceUpadate();
            String name = getusername_final();
            //clean_table("user_cache");
            //System.out.println(name);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainTabPane.setSelectedIndex(0);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnmessageActionPerformed(java.awt.event.ActionEvent evt) {
        //登陆界面的判断
        //若无输入用户名或者密码则提示
        messageFrame messageFrame = new messageFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        messageFrame.setLocation(dim.width / 2 - messageFrame.getSize().width / 2, dim.height / 2 - messageFrame.getSize().height / 2);
        messageFrame.setVisible(true);
    }

    //主界面的第一个按钮的跳转函数
    private void btnTabOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabCashActionPerformed
        try {
            cashBalanceUpadate();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            jCashDate.setDate(new Date());
            jCashDateStart.setDate(new Date());
            jCashDateEnd.setDate(new Date());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainTabPane.setSelectedIndex(1);
    }

    //主界面的第二个按钮的跳转函数
    private void btnTabTwoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            cashBalanceUpadate();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            jSaleDate.setDate(new Date());
            jSaleDateStart.setDate(new Date());
            jSaleDateEnd.setDate(new Date());
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainTabPane.setSelectedIndex(2);
    }

    //主界面的第三个按钮的跳转函数
    private void btnTabThreeActionPerformed(java.awt.event.ActionEvent evt) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            jPurchaseDate.setDate(new Date());
            jPurchaseDateStart.setDate(new Date());
            jPurchaseDateEnd.setDate(new Date());
        mainTabPane.setSelectedIndex(3);
    }

    //主界面的第四个按钮的跳转函数
    private void btnTabFourActionPerformed(java.awt.event.ActionEvent evt) {
        mainTabPane.setSelectedIndex(4);
    }

    //主界面的第五个按钮的跳转函数
    private void btnTabFiveActionPerformed(java.awt.event.ActionEvent evt) {
        mainTabPane.setSelectedIndex(5);
    }

    //主界面的第六个按钮的跳转函数
    private void btnTabSixActionPerformed(java.awt.event.ActionEvent evt) {
        mainTabPane.setSelectedIndex(6);
    }

    //主界面的第七个按钮的跳转函数
    private void btnTabSevenActionPerformed(java.awt.event.ActionEvent evt) {
        mainTabPane.setSelectedIndex(7);
    }

    //主界面切换用户按钮的跳转函数
    private void btnTabEightActionPerformed(java.awt.event.ActionEvent evt) {
        LoginFrame adminLogin = new LoginFrame();
        adminLogin.setVisible(true);
        this.setVisible(false);
    }
    //定义关于作者名片函数
    private void btnMakerInfoActionPerformed(java.awt.event.ActionEvent evt) {
        Information i = new Information();
        i.setVisible(true);

    }
    //btn end


    private void btnBankUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBankUpdateActionPerformed
        String date = ((JTextField) jBankDate.getDateEditor().getUiComponent()).getText();

        if ("".equals(txtBankDetails.getText()) || "".equals(txtBankTransitionNo.getText()) || "".equals(txtBankAmount.getText()) || "".equals(date)) {
            JOptionPane.showMessageDialog(rootPane, "Enter value on field");
        } else {
            Connection conn = null;
            PreparedStatement psm = null;
            try {
                int dr = 0;
                int cr = 0;
                if (cmbBankType.getSelectedIndex() == 0) {
                    dr = Integer.parseInt(txtBankAmount.getText());
                } else if (cmbBankType.getSelectedIndex() == 1) {
                    cr = Integer.parseInt(txtBankAmount.getText());
                }

                conn = DatabaseConnection.getConnection();
                String sql = "INSERT INTO bank_ac(type, details, transitionno, date, dr_ac, cr_ac) VALUES(?,?,?,?,?,?)";
                psm = conn.prepareStatement(sql);
                psm.setString(1, "" + cmbBankType.getSelectedItem());
                psm.setString(2, txtBankDetails.getText());
                psm.setString(3, txtBankTransitionNo.getText());
                psm.setString(4, date);
                psm.setString(5, "" + dr);
                psm.setString(6, "" + cr);

                int t = psm.executeUpdate();

                int n = CashAccount.cashIn("" + cmbBankType.getSelectedItem(), txtBankDetails.getText(), date, "" + dr);
                if (n > 0 && t > 0) {
                    updateInfo();
                    JOptionPane.showMessageDialog(rootPane, "Bank account update Successfully");
                    jBankDate.setDate(null);
                    cmbBankType.setSelectedIndex(0);
                    txtBankDetails.setText("");
                    txtBankTransitionNo.setText("");
                    txtBankAmount.setText("");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "No Entry Execute Successfully");
                    try {
                        ErrorHelper.exceptionError("btnBankUpdateActionPerformed");
                    } catch (Exception ex) {
                    }
                }
            } catch (Exception ex) {
                System.err.println("btnBankUpdateActionPerformed" + ex);
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
    }//GEN-LAST:event_btnBankUpdateActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int check = JOptionPane.showConfirmDialog(mainTabPane, "是否确定退出系统");
        if (check == 0) {
            try {
                ErrorHelper.login("Logout - ");
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(1);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCashShowOnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashShowOnTableActionPerformed
        String dateStart = ((JTextField) jCashDateStart.getDateEditor().getUiComponent()).getText();
        String dateEnd = ((JTextField) jCashDateEnd.getDateEditor().getUiComponent()).getText();
        if ("".equals(dateStart) || "".equals(dateEnd)) {
            JOptionPane.showMessageDialog(rootPane, "日期输入错误！请重新选择！");
        } else {
            try {
                ResultSet rs = tableDataBetweenDateForzhichu(dateStart, dateEnd, "data_all","支出");
                DefaultTableModel dtm = (DefaultTableModel) jCashTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[5];
                int no = 1;

                while (rs.next()) {
                    tempObject[0] = no++;
                    tempObject[1] = rs.getDate(4);
                    tempObject[2] = rs.getString(2);
                    tempObject[3] = rs.getString(3);
                    tempObject[4] = rs.getInt(5);
                    //tempObject[5] = rs.getInt(6);//这行可以去掉
                    dtm.addRow(tempObject);
                }
            } catch (Exception ex) {
                System.out.println("btnCashShowOnTableActionPerformed" + ex);
            }

        }
    }

    private void btnWithdrawShowOnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashShowOnTableActionPerformed
        String dateStart = ((JTextField) jWitdrawDatestart.getDateEditor().getUiComponent()).getText();
        String dateEnd = ((JTextField) jWitdrawDateend.getDateEditor().getUiComponent()).getText();
        if ("".equals(dateStart) || "".equals(dateEnd)) {
            JOptionPane.showMessageDialog(rootPane, "日期输入错误！请重新选择！");
        } else {
            try {
                ResultSet rs = tableDataBetweenDateForzhichu(dateStart, dateEnd, "data_all","支出");
                DefaultTableModel dtm = (DefaultTableModel) jCashTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[6];
                int no = 1;

                while (rs.next()) {
                    tempObject[0] = no++;
                    tempObject[1] = rs.getDate(4);
                    tempObject[2] = rs.getString(2);
                    tempObject[3] = rs.getString(3);
                    tempObject[4] = rs.getInt(5);
                    //tempObject[5] = rs.getInt(6);//这行可以去掉
                    dtm.addRow(tempObject);
                }
            } catch (Exception ex) {
                System.out.println("btnCashShowOnTableActionPerformed" + ex);
            }

        }
    }


    private void btnCashDeleteOnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashShowOnTableActionPerformed
        CashAccount.cashDelete(jCashTable.getValueAt(jCashTable.getSelectedRow(),2),
                jCashTable.getValueAt(jCashTable.getSelectedRow(),3),
                jCashTable.getValueAt(jCashTable.getSelectedRow(),4),
                jCashTable.getValueAt(jCashTable.getSelectedRow(),1));
        System.out.print(jCashTable.getValueAt(jCashTable.getSelectedRow(),2));
        DefaultTableModel dtm = (DefaultTableModel) jCashTable.getModel();
        dtm.removeRow(jCashTable.getSelectedRow());
    }

    private void btnSaleDeleteOnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashShowOnTableActionPerformed
        SaleAccount.saleDelete(jSaleTable.getValueAt(jSaleTable.getSelectedRow(),2),
                jSaleTable.getValueAt(jSaleTable.getSelectedRow(),3),
                jSaleTable.getValueAt(jSaleTable.getSelectedRow(),4),
                jSaleTable.getValueAt(jSaleTable.getSelectedRow(),1));
        System.out.print(jSaleTable.getValueAt(jSaleTable.getSelectedRow(),2));
        DefaultTableModel dtm = (DefaultTableModel) jSaleTable.getModel();
        dtm.removeRow(jSaleTable.getSelectedRow());
    }


    private void btnSaleShowOnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleShowOnTableActionPerformed
        String dateStart = ((JTextField) jSaleDateStart.getDateEditor().getUiComponent()).getText();
        String dateEnd = ((JTextField) jSaleDateEnd.getDateEditor().getUiComponent()).getText();
        if ("".equals(dateStart) || "".equals(dateEnd)) {
            JOptionPane.showMessageDialog(rootPane, "日期输入错误！请重新选择！");
        } else {
            try {
                ResultSet rs = tableDataBetweenDate(dateStart, dateEnd, "data_all","收入");
                DefaultTableModel dtm = (DefaultTableModel) jSaleTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[5];
                int no = 1;

                while (rs.next()) {
                    tempObject[0] = no++;
                    tempObject[1] = rs.getDate(4);
                    tempObject[2] = rs.getString(2);
                    tempObject[3] = rs.getString(3);
                    tempObject[4] = rs.getInt(5);
                    //tempObject[5] = rs.getInt(6);//这行可以去掉
                    dtm.addRow(tempObject);
                }
            } catch (Exception ex) {
                System.out.println("btnSaleShowOnTableActionPerformed" + ex);
            }

        }
    }//GEN-LAST:event_btnSaleShowOnTableActionPerformed

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    private void btnPurchaseShowOnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseShowOnTableActionPerformed
        String type = txtPurchaseType.getSelectedItem().toString();
        String shouzhi = txtPurchase2Choose.getSelectedItem().toString();
        String note = txtPurchase6.getText();
        String dateStart = ((JTextField) jPurchaseDateStart.getDateEditor().getUiComponent()).getText();
        String dateEnd = ((JTextField) jPurchaseDateEnd.getDateEditor().getUiComponent()).getText();
        String moneystart = txtPurchase5.getText();
        String moneyend = txtPurchase7.getText();
        System.out.print(moneyend);

        if ("".equals(dateStart) || "".equals(dateEnd)) {
            JOptionPane.showMessageDialog(rootPane, "日期输入错误！请重新选择！");
        }
        else if ("".equals(txtPurchase5)||"".equals(txtPurchase7)){
            JOptionPane.showMessageDialog(rootPane, "金额输入错误！请重新选择！");
        }
        else if (!isNumeric(moneystart) && !isNumeric(moneyend)){
            JOptionPane.showMessageDialog(rootPane, "金额输入错误！请重新选择！");
        }
        else {
            try {
                System.out.println(shouzhi);
                ResultSet rs = tableDataForPurchase("data_all",shouzhi,type,note,moneystart,moneyend,dateStart,dateEnd);
                System.out.println(rs);
                DefaultTableModel dtm = (DefaultTableModel) jPurchaseTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[6];
                int no = 1;

                while (rs.next()) {
                    tempObject[0] = no++;
                    tempObject[1] = rs.getDate(4);
                    tempObject[2] = rs.getString(2);
                    tempObject[3] = rs.getString(3);
                    tempObject[4] = rs.getString(5);
                    tempObject[5] = rs.getString(6);
                    dtm.addRow(tempObject);
                }
            } catch (Exception ex) {
                System.out.println("btnPurchaseShowOnTableActionPerformed" + ex);
            }

        }
    }//GEN-LAST:event_btnPurchaseShowOnTableActionPerformed

    public static String gettabledate(){
        return (String) jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),1);
    }

    public static String gettabletype(){
        return (String) jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),2);
    }

    public static String gettablenote(){
        return (String) jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),3);
    }

    public static String gettablemoney(){
        return (String) jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),4);
    }

    private void btnPurchaseChangeActionPerformed(java.awt.event.ActionEvent evt){
        ChangeFrame ChangeFrame = new ChangeFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ChangeFrame.setLocation(dim.width / 2 - ChangeFrame.getSize().width / 2, dim.height / 2 - ChangeFrame.getSize().height / 2);
        ChangeFrame.setVisible(true);
    }
        private void setBtnPurchaseChangeTableTableActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashShowOnTableActionPerformed
            System.out.println("done");
                CashAccount.cashDelete(jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 2),
                        jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 3),
                        jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 4),
                        jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 1));
            System.out.print(jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),5));
            DefaultTableModel dtm = (DefaultTableModel) jPurchaseTable.getModel();
            dtm.removeRow(jPurchaseTable.getSelectedRow());}

    private void setBtnPurchaseChangeTableTableActionPerformed2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashShowOnTableActionPerformed
        System.out.println("done");
        SaleAccount.saleDelete(jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 2),
                jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 3),
                jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 4),
                jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(), 1));
        System.out.print(jPurchaseTable.getValueAt(jPurchaseTable.getSelectedRow(),5));
        DefaultTableModel dtm = (DefaultTableModel) jPurchaseTable.getModel();
        dtm.removeRow(jPurchaseTable.getSelectedRow());}

        private ResultSet btn_show(String tablename){
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement psm = null;
        try{
            conn = DatabaseConnection.getConnection();
            String sql = "select * from "
                    +tablename;
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        }

    private void btnExpenseShowOnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpenseShowOnTableActionPerformed
        String dateStart = ((JTextField) jExpenseDateStart.getDateEditor().getUiComponent()).getText();
        String dateEnd = ((JTextField) jExpenseDateEnd.getDateEditor().getUiComponent()).getText();
        if ("".equals(dateStart) || "".equals(dateEnd)) {
            JOptionPane.showMessageDialog(rootPane, "日期输入为空！请重新输入");
        } else {
            try {
                ResultSet rs = btn_show("note");
                DefaultTableModel dtm = (DefaultTableModel) jExpenseTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[2];
                //int no = 1;

                while (rs.next()) {
                    tempObject[0] = rs.getDate(1);
                    tempObject[1] = rs.getString(2);
                    dtm.addRow(tempObject);
                }
            } catch (Exception ex) {
                System.out.println("btnExpenseShowOnTableActionPerformed" + ex);
            }

        }
    }//GEN-LAST:event_btnExpenseShowOnTableActionPerformed

    private void btnBankShowOnTableActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {//GEN-FIRST:event_btnBankShowOnTableActionPerformed
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM");

        String datestart = ((JTextField) jBankDateStart.getDateEditor().getUiComponent()).getText();
        Date datestart0 =sdf.parse(datestart);
        Calendar datestart00 = Calendar.getInstance();
        datestart00.setTime(datestart0);
        int yearstart = datestart00.get(Calendar.YEAR);
        int monthstart = datestart00.get(Calendar.MONTH);

        String dateend = ((JTextField) jBankDateEnd.getDateEditor().getUiComponent()).getText();
        Date dateend0 =sdf.parse(dateend);
        Calendar dateend00 = Calendar.getInstance();
        dateend00.setTime(dateend0);
        int yearend = dateend00.get(Calendar.YEAR);
        int monthend = dateend00.get(Calendar.MONTH);
        if ("".equals(datestart) || "".equals(dateend)) {
            JOptionPane.showMessageDialog(rootPane, "日期输入错误！！请重新输入");
        }  else {
            try {
                ResultSet rs = Statistics_type("data_all",String.valueOf(yearstart), String.valueOf(yearend), String.valueOf(monthstart+1),String.valueOf(monthend+1));
                DefaultTableModel dtm = (DefaultTableModel) jBankTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[5];
                int no = 1;
                //"序号", "消费类型", "月份", "年份", "额度"
                while (rs.next()) {
                    tempObject[0] = no++;
                    tempObject[1] = rs.getString(4);
                    tempObject[2] = rs.getInt(2);
                    tempObject[3] = rs.getInt(3);
                    tempObject[4] = rs.getInt(1);
                    dtm.addRow(tempObject);
                }
            } catch (Exception ex) {
                System.out.println("btnBankShowOnTableActionPerformed" + ex);
            }

        }
    }//GEN-LAST:event_btnBankShowOnTableActionPerformed

    private void btnWitdrawShowOnTableActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {//GEN-FIRST:event_btnWitdrawShowOnTableActionPerformed
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM");

        String datestart = ((JTextField) jWitdrawDatestart.getDateEditor().getUiComponent()).getText();
        Date datestart0 =sdf.parse(datestart);
        Calendar datestart00 = Calendar.getInstance();
        datestart00.setTime(datestart0);
        int yearstart = datestart00.get(Calendar.YEAR);
        int monthstart = datestart00.get(Calendar.MONTH);

        String dateend = ((JTextField) jWitdrawDateend.getDateEditor().getUiComponent()).getText();
        Date dateend0 =sdf.parse(dateend);
        Calendar dateend00 = Calendar.getInstance();
        dateend00.setTime(dateend0);
        int yearend = dateend00.get(Calendar.YEAR);
        int monthend = dateend00.get(Calendar.MONTH);
        if ("".equals(datestart) || "".equals(dateend)) {
            JOptionPane.showMessageDialog(rootPane, "日期输入错误！！请重新输入");
        } else {
            try {
                ResultSet rs = Statistics_shouzhi_month_sum("data_all", String.valueOf(yearstart),String.valueOf(yearend), String.valueOf(monthstart+1),String.valueOf(monthend+1));
                DefaultTableModel dtm = (DefaultTableModel) jWitdrawTable.getModel();
                dtm.setRowCount(0);
                Object[] tempObject = new Object[5];
                int no = 1;

                while (rs.next()) {
                    tempObject[0] = no++;
                    tempObject[1] = rs.getInt(1);
                    tempObject[2] = rs.getInt(2);
                    tempObject[3] = rs.getInt(3);
                    tempObject[4] = rs.getString(4);
                    dtm.addRow(tempObject);
                }
                //System.out.println(sum);
                //jLabel85.setText(String.valueOf(sum));
            } catch (Exception ex) {
                System.out.println("btnWitdrawShowOnTableActionPerformed" + ex);
            }

        }
    }//GEN-LAST:event_btnWitdrawShowOnTableActionPerformed

    public ResultSet tableDataBetweenDate(String dataStart, String dateEnd, String tableName,String shouzhi) throws ClassNotFoundException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            String sql = "select * from "
                    + tableName
                    + " where date between '"
                    + dataStart
                    + "' and '"
                    + dateEnd
                    + "'"
                    +" and status='"
                    +shouzhi
                    +"'"
                    +" and user='"
                    + name
                    +"'";

            System.out.print(sql);
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            return rs;
        } catch (SQLException ex) {
            System.err.println("tableDataBetweenDate " + ex);
        }
        return rs;
    }
    public ResultSet tableDataBetweenDateForzhichu(String dataStart, String dateEnd, String tableName, String zhichu) throws ClassNotFoundException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "select * from "
                    + tableName
                    + " where date between '"
                    + dataStart
                    + "' and '"
                    + dateEnd
                    + "' and status="
                    + "'"
                    + zhichu
                    + "'";

            System.out.print(sql);
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            return rs;
        } catch (SQLException ex) {
            System.err.println("tableDataBetweenDate " + ex);
        }
        return rs;
    }
    private ResultSet Statistics_shouzhi_month_sum(String tablename,String yearstart,String yearend, String monthstart, String monthend) {
        Connection conn = null;
        PreparedStatement psm =null;
        ResultSet rs = null;
        int sum0 = 0;
        try{
            conn = DatabaseConnection.getConnection();
            //String sql = "select sum(money),month(date) from "
            //        + tablename
            //        + " where date between '"
            //        + datestart0
            //        +"' and '"
            //        +dateend0
            //        +"'"
            //        + "and status='"
            //        +shouzhi
            //        +"'";

            String sql0 = "select sum(money)as money, month(date) as month,year(date)as year, status from "
                    + tablename +
                    " where year(date) >= '" +
                    yearstart +
                    "' and year(date) <='" +
                    yearend +
                    "' and month(date) >= '" +
                    monthstart +
                    "' and month(date) <='" +
                    monthend +
                    "' group by month(date),year(date),status";
            System.out.print(sql0);
            psm = conn.prepareStatement(sql0);

            rs = psm.executeQuery();
            return rs;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Static_shouzhi_error" + ex);
        }
        return rs;
    }

    private ResultSet Statistics_type(String tablename, String yearstart, String yearend, String monthstart, String monthend){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            String shouzhi = "支出";
            String sql = "select sum(money)as revenue, month(date) as month,year(date)as year, type from "
                    + tablename +
                    " where year(date) >= '" +
                    yearstart +
                    "' and year(date) <='" +
                    yearend +
                    "' and month(date) >= '" +
                    monthstart +
                    "' and month(date) <='" +
                    monthend +
                    "' and status = '" +
                    shouzhi
                    +"' group by month(date),year(date),type";
                System.out.print(sql);
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                return rs;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Static_shouzhi_error" + ex);
        }
        return rs;
    }

    private void sub(String tablename){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            int num = 0;
            int num0 = 0;
            int num1 = 0;
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            String sql = "select sum(money) from "
                    +tablename
                    +" where user = '"
                    + name
                    +"' group by status";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while(rs.next()){
                if(num==1){
                    num1 = rs.getInt(1);
                }
                num0 = rs.getInt(1);
                num++;
            }
            System.out.println(num0);
            System.out.println(num1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet tableDataForPurchase(String tablename, String shouzhi, String Type, String note, String moneystart, String moneyend,String dateStart, String dateEnd) throws ClassNotFoundException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DatabaseConnection.getConnection();
            if (note.equals("") && shouzhi.equals("支出")) {
                String sql = "select * from "
                        + tablename
                        + " where (date between '"
                        + dateStart
                        + "' and '"
                        + dateEnd
                        + "')"
                        + " and "
                        + "(money between '"
                        + moneystart
                        + "' and '"
                        + moneyend
                        + "')"
                        + " and"
                        + " type ='"
                        + Type
                        + "'"
                        + " and"
                        + " status ='"
                        + shouzhi
                        + "'";
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                return rs;
            }
            else if(!(note.equals("")) && shouzhi.equals("支出")){
                String sql = "select * from "
                        + tablename
                        + " where (date between '"
                        + dateStart
                        + "' and '"
                        + dateEnd
                        + "')"
                        + " and "
                        + "(money between '"
                        + moneystart
                        + "' and '"
                        + moneyend
                        + "')"
                        + " and"
                        + " type ='"
                        + Type
                        + "'"
                        + " and"
                        + " details ='"
                        + note
                        + "'"
                        + " and"
                        + " status ='"
                        + shouzhi
                        + "'";
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                return rs;
            }
            else if (note.equals("") && shouzhi.equals("收入")) {
                String sql = "select * from "
                        + tablename
                        + " where (date between '"
                        + dateStart
                        + "' and '"
                        + dateEnd
                        + "')"
                        + " and "
                        + "(money between '"
                        + moneystart
                        + "' and '"
                        + moneyend
                        + "')"
                        + " and"
                        + " type ='"
                        + Type
                        + "'"
                        + " and"
                        + " status ='"
                        + shouzhi
                        + "'";
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                return rs;
            }
            else if(!(note.equals("")) && shouzhi.equals("收入")){
                String sql = "select * from "
                        + tablename
                        + " where (date between '"
                        + dateStart
                        + "' and '"
                        + dateEnd
                        + "')"
                        + " and "
                        + "(money between '"
                        + moneystart
                        + "' and '"
                        + moneyend
                        + "')"
                        + " and"
                        + " type ='"
                        + Type
                        + "'"
                        + " and"
                        + " details ='"
                        + note
                        + "'"
                        + " and"
                        + " status ='"
                        + shouzhi
                        + "'";
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                return rs;
            }
            else if (note.equals("") && shouzhi.equals("全部(不必选类型)")) {
                String sql = "select * from "
                        + tablename
                        + " where (date between '"
                        + dateStart
                        + "' and '"
                        + dateEnd
                        + "')"
                        + " and "
                        + "(money between '"
                        + moneystart
                        + "' and '"
                        + moneyend
                        + "')";
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                return rs;
            }
            else if(!(note.equals("")) && shouzhi.equals("全部(不必选类型)")){
                String sql = "select * from "
                        + tablename
                        + " where (date between '"
                        + dateStart
                        + "' and '"
                        + dateEnd
                        + "')"
                        + " and "
                        + "(money between '"
                        + moneystart
                        + "' and '"
                        + moneyend
                        + "')"
                        + " and"
                        + " details ='"
                        + note
                        + "'";
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                return rs;
            }
        } catch (SQLException ex) {
            System.err.println("tableDataBetweenDateForPurchase " + ex);
        }
        return rs;
    }
    public int columnSum(String columnName, String tableName) throws ClassNotFoundException {
        int sum = 0;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {

            conn = DatabaseConnection.getConnection();
            String sql = "Select SUM("
                    + columnName
                    + ") FROM "
                    + tableName
                    + " ";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            if (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("columnSum " + ex);
        } finally {
            if (conn != null || psm != null || rs != null) {
                try {
                    conn.close();
                    psm.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return sum;
    }
/*

    private ResultSet getusername0() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            String status = "在线";
            conn = DatabaseConnection.getConnection();
            String sql = "select * from user where status ='"
                    +status
                    +"'";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs;
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void getusername(){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            rs = getusername0();
            String sql = "INSERT INTO user_cache values(?,?,?,?,?,?)";
            psm = conn.prepareStatement(sql);
            while(rs.next()){
                psm.setInt(1,1);
                psm.setString(2,rs.getString(2));
                psm.setString(3,rs.getString(3));
                psm.setString(4,rs.getString(4));
                psm.setString(5,rs.getString(5));
                psm.setString(6,rs.getString(6));
                psm.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

    private String getusername_final(){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        String name="";
        try{
            String status = "在线";
            conn = DatabaseConnection.getConnection();
            String sql = "select * from user where status ='"
                    +status
                    +"'";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while(rs.next()) {
                name = rs.getString(2);
            }
            System.out.println(name);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    private void clean_table(String tablename){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try{
            conn = DatabaseConnection.getConnection();
            String sql = "truncate table " + tablename;
            psm = conn.prepareStatement(sql);
            psm.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bankBalanceUpadate() throws ClassNotFoundException {
        //求和函数
        int dr = columnSum("dr_ac", "bank_ac");
        int cr = columnSum("cr_ac", "bank_ac");
        //图表生成页面的记录
        lblBankAccountBalance.setText("" + (dr - cr));
    }

    public void cashBalanceUpadate() throws ClassNotFoundException {
        //求和函数
        //int dr = columnSum("dr_ac", "cash_ac");
        //int cr = columnSum("cr_ac", "cash_ac");
        //主界面的Cash In Hand
        //lblCashInHand.setText("" + (dr - cr));
    }

    public void updateInfo() throws ClassNotFoundException {
        bankBalanceUpadate();
        //cashBalanceUpadate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBankShowOnTable;
    private javax.swing.JButton btnBankUpdate;
    private javax.swing.JButton btnCashAdd;
    private javax.swing.JButton btnCashShowOnTable;
    private javax.swing.JButton btnCashDeleteTable;
    private javax.swing.JButton btnSaleDeleteTable;
    private javax.swing.JButton btnPurchaseChangeTable;
    private javax.swing.JButton btnExpAdd;
    private javax.swing.JButton btnExpenseShowOnTable;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMakerInfo;
    private javax.swing.JButton btnPurchaseAdd;
    private javax.swing.JButton btnPurchaseShowOnTable;
    private javax.swing.JButton btnPurchaseChange2Table;
    private javax.swing.JButton btnSaleAdd;
    private javax.swing.JButton btnSaleShowOnTable;
    private javax.swing.JButton btnTabFive;
    private javax.swing.JButton btnTabOne;
    private javax.swing.JButton btnTabFour;
    private javax.swing.JButton btnTabThree;
    private javax.swing.JButton btnTabSeven;
    private javax.swing.JButton btnTabTwo;
    private javax.swing.JButton btnTabEight;
    private javax.swing.JButton btnTabSix;
    private javax.swing.JButton btnTab1;
    private javax.swing.JButton btnTab2;
    private javax.swing.JButton btnTab3;
    private javax.swing.JButton btnTab4;
    private javax.swing.JButton btnTab5;
    private javax.swing.JButton btnTab6;
    private javax.swing.JButton btnTab7;
    private javax.swing.JButton btnWitdrawShowOnTable;
    private javax.swing.JButton btnWitdrawUpdate;
    private javax.swing.JButton btnmessage;
    private javax.swing.JComboBox<String> cmbBankType;
    private com.toedter.calendar.JDateChooser jBankDate;
    private com.toedter.calendar.JDateChooser jBankDateEnd;
    private com.toedter.calendar.JDateChooser jBankDateStart;
    public javax.swing.JTable jBankTable;
    private com.toedter.calendar.JDateChooser jCashDate;
    private com.toedter.calendar.JDateChooser jCashDateEnd;
    private com.toedter.calendar.JDateChooser jCashDateStart;
    public javax.swing.JTable jCashTable;
    private com.toedter.calendar.JDateChooser jExpDate;
    private com.toedter.calendar.JDateChooser jExpenseDateEnd;
    private com.toedter.calendar.JDateChooser jExpenseDateStart;
    public javax.swing.JTable jExpenseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextArea jbeiwang;
    private com.toedter.calendar.JDateChooser jPurchaseDate;
    private com.toedter.calendar.JDateChooser jPurchaseDateEnd;
    private com.toedter.calendar.JDateChooser jPurchaseDateStart;
    private com.toedter.calendar.JDateChooser jdatestart;
    private com.toedter.calendar.JDateChooser jdateend;
    //public javax.swing.JTable jPurchaseTable;
    private com.toedter.calendar.JDateChooser jSaleDate;
    private com.toedter.calendar.JDateChooser jSaleDateEnd;
    private com.toedter.calendar.JDateChooser jSaleDateStart;
    private javax.swing.JTable jSaleTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private com.toedter.calendar.JDateChooser jWitdrawDate;
    private com.toedter.calendar.JDateChooser jWitdrawDateEnd;
    private com.toedter.calendar.JDateChooser jWitdrawDateStart;
    private com.toedter.calendar.JDateChooser jWitdrawDatestart;
    private com.toedter.calendar.JDateChooser jWitdrawDateend;
    private javax.swing.JTable jWitdrawTable;
    private javax.swing.JPanel jpanelBank;
    private javax.swing.JPanel jpanelCash;
    private javax.swing.JPanel jpanelExpenses;
    private javax.swing.JPanel jpanelHome;
    private javax.swing.JPanel jpanelHomeIcon;
    private javax.swing.JPanel jpanelPurchase;
    private javax.swing.JPanel jpanelReport;
    private javax.swing.JPanel jpanelSale;
    private javax.swing.JPanel jpanelSide;
    private javax.swing.JPanel jpanelWitdraw;
    private javax.swing.JLabel lblBankAccountBalance;
    private javax.swing.JLabel lblCashInHand;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JTextField txtBankAmount;
    private javax.swing.JTextField txtBankDetails;
    private javax.swing.JTextField txtBankTransitionNo;
    private javax.swing.JTextField txtCashAmount;
    private javax.swing.JTextField txtSaleAmount;
    private javax.swing.JTextField txtCashDetails;
    private javax.swing.JTextField txtSaleDetails;
    private javax.swing.JComboBox txtCashType;
    private javax.swing.JComboBox txtSaleType;
    private javax.swing.JComboBox txtPurchaseType;
    private javax.swing.JComboBox txtPurchase2Choose;
    private javax.swing.JTextField txtExpAmount;
    private javax.swing.JTextField txtExpDetails;
    private javax.swing.JTextField txtExpType;
    private javax.swing.JTextField txtExpVoucher;
    private javax.swing.JTextField txtPurchase2;
    private javax.swing.JTextField txtPurchase3;
    private javax.swing.JTextField txtPurchase4;
    private javax.swing.JTextField txtPurchase5;
    private javax.swing.JTextField txtPurchase6;
    private javax.swing.JTextField txtPurchase7;
    private javax.swing.JTextField txtSaleCusMobile;
    private javax.swing.JTextField txtSaleCusName;
    private javax.swing.JTextField txtSaleDiscount;
    private javax.swing.JTextField txtSaleGrandTotal;
    private javax.swing.JTextField txtSaleInvoice;
    private javax.swing.JTextField txtSaleProductDetails;
    private javax.swing.JTextField txtSaleTotal;
    private javax.swing.JTextField txtWitdrawAmount;
    private javax.swing.JTextField txtWitdrawDetails;
    private javax.swing.JTextField txtWitdrawType;
    //以下是数据统计部分
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    // End of variables declaration//GEN-END:variables
}
