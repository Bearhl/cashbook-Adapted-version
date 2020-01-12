package B;





import java.awt.Font;
import java.awt.RenderingHints;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



public class BarChartDemo {
	static int uamount;
	static String utype;
	static String umonth;
	public static final String url="jdbc:mysql://localhost:3306/cashbook_aeontanvir?serverTimezone=UTC";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "88879556";
	public Connection conn = null;
	public PreparedStatement pst = null;
	static ResultSet ret = null;
	static BarChartDemo db1 = null;
	public static final String sql="select * from consume_barchart";

	public BarChartDemo(String sql) {
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
		// 1. 得到数据

		CategoryDataset dataset = getDataSet();

		// 2. 构造chart

		JFreeChart chart = ChartFactory.createBarChart3D(

				"月支出柱状图", // 图表标题

				"月份", // 目录轴的显示标签--横轴

				"元", // 数值轴的显示标签--纵轴

				dataset, // 数据集

				PlotOrientation.VERTICAL, // 图表方向：水平、

				true, // 是否显示图例(对于简单的柱状图必须

				false, // 是否生成工具

				false // 是否生成URL链接

		);

		// 3. 处理chart中文显示问题

		processChart(chart);



		// 4. chart输出图片

		writeChartAsImage(chart);



		// 5. chart 以swing形式输出

		ChartFrame pieFrame = new ChartFrame("柱状图", chart);

		pieFrame.pack();

		pieFrame.setVisible(true);



	}



	/**

	 * 获取一个演示用的组合数据集对象

	 *

	 * @return

	 */

	private static CategoryDataset getDataSet() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		db1 = new BarChartDemo(sql);//创建DBHelper对象

		try {
			ret = db1.pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {
				uamount = ret.getInt(1);
				utype = ret.getString(2);
				umonth = ret.getString(3);
				dataset.addValue(uamount,utype,umonth);
			}//显示数据
			ret.close();
			db1.close();//关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}



		return dataset;

	}



	/**

	 * 解决图表汉字显示问题

	 *

	 * @param chart

	 */

	private static void processChart(JFreeChart chart) {

		CategoryPlot plot = chart.getCategoryPlot();

		CategoryAxis domainAxis = plot.getDomainAxis();

		ValueAxis rAxis = plot.getRangeAxis();

		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,

				RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		TextTitle textTitle = chart.getTitle();

		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));

		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));

		rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

		rAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));

		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

		// renderer.setItemLabelGenerator(new LabelGenerator(0.0));

		// renderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 12));

		// renderer.setItemLabelsVisible(true);

	}



	/**

	 * 输出图片

	 *

	 * @param chart

	 */

	private static void writeChartAsImage(JFreeChart chart) {

		FileOutputStream fos_jpg = null;

		try {

			fos_jpg = new FileOutputStream("C:\\Users\\92981\\Pictures\\xunzi.jpg");

			ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart, 400, 300, null);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				fos_jpg.close();

			} catch (Exception e) {

			}

		}

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

