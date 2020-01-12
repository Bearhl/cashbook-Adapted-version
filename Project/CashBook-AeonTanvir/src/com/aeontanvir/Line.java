package D;//折线图

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class Line {
    static String s="消费支出状况如下:\n";
    static int m;			//用于判断是否要执行预警功能
    static int limit;		//用于设定每日支出额度
    static int uamount1;
    static int uamount2;
    static int uamount3;
    static int uamount4;
    static int uamount5;
    static String udate;
    public static final String url="jdbc:mysql://localhost:3306/cashbook_aeontanvir?serverTimezone=UTC";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "88879556";
    public Connection conn = null;
    public PreparedStatement pst = null;
    static ResultSet ret = null;
    static Line db1 = null;
    public static final String sql="select * from consume_line";

    public Line(String sql) {
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
                "日支出折线图",//图名字
                "日期",//横坐标
                "元",//纵坐标
                mDataset,//数据集
                PlotOrientation.VERTICAL,
                true, // 显示图例
                true, // 采用标准生成器
                false);// 是否生成超链接

        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
        mPlot.setOutlinePaint(Color.RED);//边界线

        ChartFrame mChartFrame = new ChartFrame("日支出折线图", mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);




    }
    public static CategoryDataset GetDataset()
    {int count;
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        db1 = new Line(sql);//创建对象
        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集

            Object[] options ={ "否", "是" };
            m = JOptionPane.showOptionDialog(null, "是否要执行预警功能", "功能",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            //System.out.println(m);
            if(m==1) {
                String title = JOptionPane.showInputDialog(null, "请输入：\n你要设定的每日支出总额度", "额度设定", JOptionPane.PLAIN_MESSAGE);
                limit=Integer.parseInt(title);
                //System.out.println(limit);
            }
            while (ret.next()) {
                uamount1 = ret.getInt(1);
                uamount2 = ret.getInt(2);
                uamount3 = ret.getInt(3);
                uamount4 = ret.getInt(4);
                uamount5 = ret.getInt(5);
                udate = ret.getString(6);
                count=uamount1+uamount2+uamount3+uamount4+uamount5;
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String proportion1 = numberFormat.format((float)uamount1/(float)count*100);
                String proportion2 = numberFormat.format((float)uamount2/(float)count*100);
                String proportion3 = numberFormat.format((float)uamount3/(float)count*100);
                String proportion4 = numberFormat.format((float)uamount4/(float)count*100);
                String proportion5 = numberFormat.format((float)uamount5/(float)count*100);
                double a1=Double.parseDouble(proportion1);
                double a2=Double.parseDouble(proportion2);
                double a3=Double.parseDouble(proportion3);
                double a4=Double.parseDouble(proportion4);
                double a5=Double.parseDouble(proportion5);
                double[] ints = {a1,a2,a3,a4,a5};
                double max=tomax(ints);
                if(m==1) {
                    if(count>limit) {
                        if(max==a1)	s=s.concat(udate+ "支出已超额"+(count-limit)+"元\n"+"美食支出所占比重最高:"+max+"%\n"+"------------------------\n");
                        else if(max==a2) 	s=s.concat(udate+ "支出已超额"+(count-limit)+"元\n"+"衣服支出所占比重最高:"+max+"%\n"+"------------------------\n");
                        else if(max==a3)	s=s.concat(udate+ "支出已超额"+(count-limit)+"元\n"+"交通支出所占比重最高:"+max+"%\n"+"------------------------\n");
                        else if(max==a4)	s=s.concat(udate+ "支出已超额"+(count-limit)+"元\n"+"生活用品支出所占比重最高:"+max+"%\n"+"------------------------\n");
                        else s=s.concat(udate+ "支出已超额"+(count-limit)+"元\n"+"娱乐支出所占比重最高:"+max+"%\n"+"------------------------\n");
                    }
                }






   	      /*Object[] possibleValues = { "美食 ", "衣服 ", "交通 " ,"生活用品","娱乐"};
                Object selectedValue = JOptionPane.showInputDialog(null, "消费类型选择", "日支出",
                JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);



                Object x=selectedValue;
        		if(x=="美食 ")
        			JOptionPane.showMessageDialog(null, udate+"美食"+"所占日出比重："+proportion1+"%"+"\n");
        		else if(x=="衣服 ")
        			JOptionPane.showMessageDialog(null, udate+"衣服"+"所占日出比重："+proportion2+"%"+"\n");
        		else if(x=="交通 ")
        			JOptionPane.showMessageDialog(null, udate+"交通"+"所占日出比重："+proportion3+"%"+"\n");
        		else if(x=="生活用品 ")
        			JOptionPane.showMessageDialog(null, udate+"生活用品"+"所占日出比重："+proportion4+"%"+"\n");
        		else
        			JOptionPane.showMessageDialog(null, udate+"娱乐"+"所占日出比重："+proportion5+"%"+"\n");	*/
        		/*SwingUtilities.invokeLater(new Runnable(){

                	public void run()

                	{Object x=selectedValue;
                		if(x=="美食 ")
                		JOptionPane.showMessageDialog(null, "所占日出比重："+"美食"+proportion1+"%"+"\n");

                	}

                	});        */


                mDataset.addValue(uamount1, "美食", udate);
                mDataset.addValue(uamount2, "衣服", udate);
                mDataset.addValue(uamount3, "交通", udate);
                mDataset.addValue(uamount4, "生活用品", udate);
                mDataset.addValue(uamount5, "娱乐", udate);

            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(m==1) {
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
    public static double tomax(double []ints) {



        double max = ints[0];
        for (int i =1 ; i < ints.length; i++) {
            if(ints[i]>max) {
                max = ints[i];
            }
        }
        return max;
    }


}

