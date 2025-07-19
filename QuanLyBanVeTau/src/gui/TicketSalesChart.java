package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class TicketSalesChart {

    public ChartPanel createChartPanel() {
        // Tạo dataset từ cơ sở dữ liệu
        DefaultCategoryDataset dataset = createDataset();

        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createBarChart(
                "Doanh thu bán vé", // Chart title
                "Ngày", // X-Axis Label
                "Doanh thu (VNĐ)", // Y-Axis Label
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Tạo và trả về ChartPanel
        return new ChartPanel(chart);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLVeTau";
        String user = "sa";
        String password = "sapassword";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ngayLapHD, tongDoanhThu FROM HoaDon")) {

            while (rs.next()) {
                String date = rs.getString("ngayLapHD");
                double revenue = rs.getDouble("tongDoanhThu");
                dataset.addValue(revenue, "Doanh thu", date);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }
}
