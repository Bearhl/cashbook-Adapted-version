package D;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class Line2 {
    static int []diffrence = new int[12];
    static String []month	=new String[12];
    static int m;
    static int uamount1;
    static int uamount2;
    static String udate;
    public static final String url="jdbc:mysql://localhost:3306/cashbook_aeontanvir?serverTimezone=UTC";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "88879556";
    public Connection conn = null;
    public PreparedStatement pst = null;
    static ResultSet ret = null;
    static Line2 db1 = null;
    public static final String sql="select * from consume_Line2";

    public Line2(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url,user,password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    public static void main(String[] args) {
        UIManager.put("RootPane.setupButtonVisible", false);//隐藏设置按钮
        try
        {
            //org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            //TODO exception
        }

        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
        ChartFactory.setChartTheme(mChartTheme);
        CategoryDataset mDataset = GetDataset();
        JFreeChart mChart = ChartFactory.createLineChart(
                "各月总收入与总支出折线图",//图名字
                "月份",//横坐标
                "元",//纵坐标
                mDataset,//数据集
                PlotOrientation.VERTICAL,
                true, // 显示图例
                true, // 采用标准生成器
                false);// 是否生成超链接

        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundPaint(Color.LIGHT_GRAY);


        ChartFrame mChartFrame = new ChartFrame("折线图", mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);




    }
    public static CategoryDataset GetDataset()
    {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        db1 = new Line2(sql);//创建对象
        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            int i=0;
            Object[] options ={ "否", "是" };
            m = JOptionPane.showOptionDialog(null, "是否要执行预警功能", "功能",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            while (ret.next()) {
                uamount1 = ret.getInt(1);
                uamount2 = ret.getInt(2);
                udate = ret.getString(3);
                mDataset.addValue(uamount1, "月收入", udate);
                mDataset.addValue(uamount2, "月支出", udate);

                month[i]=udate;
                diffrence[i]=uamount1-uamount2;
                i++;
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(m==1) {
            String s = "超额支出的月份有：\n";
            for(int i=0;i<diffrence.length;i++) {
                if(diffrence[i]<0) {
                    s=s.concat(month[i]+"月"+"超支\t"+-diffrence[i]+"元\n");
                }
            }
            JOptionPane.showMessageDialog(null,s, "警告",JOptionPane.ERROR_MESSAGE);
        }

        return mDataset;
    }
    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

