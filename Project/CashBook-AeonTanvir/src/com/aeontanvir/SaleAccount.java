/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeontanvir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleAccount {

    private static String getusername_final(){
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

    public static int saleIn(String type, String details, String date, String money) {
        int row = 0;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            String name = getusername_final();
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO data_all(type, details, date, money, status,user) VALUES(?,?,?,?,?,?)";
            psm = conn.prepareStatement(sql);
            psm.setString(1, type);
            psm.setString(2, details);
            psm.setString(3, date);
            psm.setString(4, money);
            psm.setString(5, "收入");
            psm.setString(6, name);

            row = psm.executeUpdate();

        } catch (Exception ex) {
            System.out.println("saleIn" + ex);
        }finally{
            try {
                conn.close();
                psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(CashAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return row;
    }

    public static int saleDelete(Object type, Object details, Object dr_ac, Object date) {
        int line=0;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            String name = getusername_final();
            //String s = row+"";
            //System.out.print(s);
            conn = DatabaseConnection.getConnection();
            //System.out.print(jCashTable.getValueAt(jCashTable.getSelectedRow(),2));
            String sql = "DELETE FROM data_all WHERE type=? and details=? and money=? and date=? and status=? and user=?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, String.valueOf(type));
            psm.setString(2, String.valueOf(details));
            psm.setString(3, String.valueOf(dr_ac));
            psm.setString(4, String.valueOf(date));
            psm.setString(5, "收入");
            psm.setString(6, name);
            line = psm.executeUpdate();


        } catch (Exception ex) {
            System.out.println("saleDelete" + ex);
        } finally {
            try {
                conn.close();
                psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(CashAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return line;
    }
}