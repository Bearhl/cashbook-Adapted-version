package E;//饼状图

import java.awt.Font;
import java.awt.Color;
import java.io.File;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;



import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.UIManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PieChart {
	static String utype;
	static int	uamount;
	public static final String url="jdbc:mysql://localhost:3306/cashbook_aeontanvir?serverTimezone=UTC";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "88879556";
	public Connection conn = null;
	public PreparedStatement pst = null;
	static ResultSet ret = null;
	static PieChart db1 = null;
	public static final String sql="select * from consume_total";

	public PieChart(String sql) {
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

		DefaultPieDataset dataset = new DefaultPieDataset();
		db1 = new PieChart(sql);//创建对象
		try {
			ret = db1.pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {
				utype = ret.getString(1);
				uamount = ret.getInt(2);
				dataset.setValue(utype, uamount);
			}//显示数据
			ret.close();
			db1.close();//关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}



		JFreeChart chart = ChartFactory.createPieChart("年支出占比", // chart
				dataset, // data
				true, // include legend
				true, false);
		setChart(chart);
		PiePlot pieplot = (PiePlot) chart.getPlot();
		pieplot.setSectionPaint("美食", Color.decode("#749f83"));
		pieplot.setSectionPaint("衣服", Color.decode("#2f4554"));
		pieplot.setSectionPaint("交通", Color.decode("#61a0a8"));
		pieplot.setSectionPaint("生活用品", Color.decode("#d48265"));
		pieplot.setSectionPaint("娱乐", Color.decode("#91c7ae"));
		//pieplot.setSectionPaint("F", Color.decode("#c23531"));
		//pieplot.setSectionPaint("G", Color.decode("#ca8622"));
		//pieplot.setSectionPaint("H", Color.decode("#bda29a"));
		//pieplot.setSectionPaint("I", Color.decode("#6e7074"));
		//pieplot.setSectionPaint("J", Color.decode("#546570"));
		//pieplot.setSectionPaint("K", Color.decode("#c4ccd3"));

		try {

			// 创建图形显示面板
			ChartFrame cf = new ChartFrame("饼状图", chart);
			// cf.pack();
			// // 设置图片大小
			cf.setSize(600, 600);
			// // 设置图形可见
			cf.setVisible(true);


			// 保存图片到指定文件夹
			//ChartUtilities.saveChartAsPNG(new File("d:\\PieChart2.png"), chart, 1500, 800);
			//System.err.println("成功");
		} catch (Exception e) {
			System.err.println("创建图形时出错");
		}
	}


	public static void setChart(JFreeChart chart) {
		chart.setTextAntiAlias(true);

		PiePlot pieplot = (PiePlot) chart.getPlot();
		// 设置图表背景颜色
		pieplot.setBackgroundPaint(ChartColor.WHITE);


		pieplot.setLabelBackgroundPaint(null);// 标签背景颜色


		pieplot.setLabelOutlinePaint(null);// 标签边框颜色


		pieplot.setLabelShadowPaint(null);// 标签阴影颜色


		pieplot.setOutlinePaint(null); // 设置绘图面板外边的填充颜色


		pieplot.setShadowPaint(null); // 设置绘图面板阴影的填充颜色

		DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
		NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
		StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
		pieplot.setLabelGenerator(sp1);//设置饼图显示百分比

		pieplot.setSectionOutlinesVisible(false);
		pieplot.setNoDataMessage("没有可供使用的数据！");
		chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
		PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
		piePlot.setLabelFont(new Font("宋体",Font.BOLD,20));//解决乱码
		chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,15));

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


