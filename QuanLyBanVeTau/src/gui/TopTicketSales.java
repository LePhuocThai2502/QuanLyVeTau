package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class TopTicketSales {

    public ChartPanel createChartPanel() {
        // Tạo dataset từ cơ sở dữ liệu
        DefaultCategoryDataset dataset = createDataset();

        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createBarChart(
                "Top vé tàu bán chạy nhất", // Chart title
                "Mã Vé", // X-Axis Label
                "Doanh thu (VNĐ)", // Y-Axis Label
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);


        return new ChartPanel(chart);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLVeTau";
        String user = "sa";
        String password = "sapassword";

        try (Connection conn = DriverManager.getConnection(url, user, password);
        	     Statement stmt = conn.createStatement();
        	     ResultSet rs = stmt.executeQuery("SELECT CT.maVe, SUM(CT.donGiaSauThue * CT.soLuong) AS tongDoanhThu " +
        	                                      "FROM CT_HoaDon CT " +
        	                                      "JOIN HoaDon HD ON CT.maHD = HD.maHD " +
        	                                      "GROUP BY CT.maVe " +
        	                                      "ORDER BY tongDoanhThu DESC")) {

        	    int count = 0;
        	    while (rs.next() && count < 10) { // Lấy top 5 vé tàu bán chạy nhất
        	        String maVe = rs.getString("maVe");
        	        double revenue = rs.getDouble("tongDoanhThu");
        	        dataset.addValue(revenue, "Doanh thu", maVe);
        	        count++;
        	    }

        	} catch (Exception e) {
        	    e.printStackTrace();
        	}

        return dataset;
    }
}
