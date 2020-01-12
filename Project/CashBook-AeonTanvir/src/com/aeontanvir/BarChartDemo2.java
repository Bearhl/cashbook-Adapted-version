package B;//各年总收入与总支出柱状图
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.RenderingHints;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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



public class BarChartDemo2 {
	static int length;
	static int[] strArray1=new int[99];//收入数组
	static int[] strArray2=new int[99];//支出数组
	static String []count1=new String[99];
	static String []count2=new String[99];
	static int uamount;
	static String utype;
	static String uyear;
	public static final String url="jdbc:mysql://localhost:3306/cashbook_aeontanvir?serverTimezone=UTC";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "88879556";
	public Connection conn = null;
	public PreparedStatement pst = null;
	static ResultSet ret = null;
	static BarChartDemo2 db1 = null;
	public static final String sql="select * from consume_barchart2";

	public BarChartDemo2(String sql) {
		try {
			Class.forName(name);//指定连接类型
			conn = DriverManager.getConnection(url,user,password);//获取连接
			pst = conn.prepareStatement(sql);//准备执行语句
		} catch (Exception e) {
			e.printStackTrace();
		}


	}



	public static void main(String[] args)  {

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

				"各年总收入与总支出柱状图", // 图表标题

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
		db1 = new BarChartDemo2(sql);//创建DBHelper对象

		try {
			ret = db1.pst.executeQuery();//执行语句，得到结果集
			int i=0;
			int j=0;
			int h=0;
			int k=0;
			while (ret.next()) {

				uamount = ret.getInt(1);
				utype = ret.getString(2);
				uyear = ret.getString(3);

				if(utype.equals("收入")) {
					count1[i]=uyear;
					strArray1[j]= uamount;

					i++;j++;					}
				else if(utype.equals("支出")) {
					count2[k]=uyear;
					strArray2[h]=uamount;
            		/*if(strArray1[j]<strArray2[h]) {
            			JOptionPane.showMessageDialog(null, count2[k]+"年支出超额", "警告",JOptionPane.ERROR_MESSAGE);
            		}*/
					k++;h++;
				}


				dataset.addValue(uamount,utype,uyear);
			}//显示数据



		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i=0;
		while(strArray1[i]!=0) {
			i++;
		}	//System.out.println(i);
		length=i;
		for(int h=0;h<length;h++) {
			for(int k=0;k<length;k++) {
				String point=count2[k];
				if(point.equals(count1[h])) {

					int diffrence=strArray1[h]-strArray2[k];
					JOptionPane.showMessageDialog(null, count1[h]+"年支出超额"+-diffrence+"元", "警告",JOptionPane.ERROR_MESSAGE);
				}
			}

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
	/*
	public int[] StringToInt(String[] b[]) {
		int[] ints=new int[b.length];
		for(int i=0;i<b.length;i++) {
			ints[i]=Integer.parseInt(b[i]);
		}
		return ints;
	}


	static void sort(int a[]) {



	 int n=a.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
	}

*/

}

