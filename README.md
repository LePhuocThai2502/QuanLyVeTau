# Quản Lý Bán Vé Tàu 🚆

> Ứng dụng Java Swing hỗ trợ quản lý đặt vé tàu, đổi/trả vé, xuất hóa đơn và thống kê doanh thu.

---

## 📋 Tính năng chính

- Đặt vé tàu theo chuyến, ngày, toa và ghế
- Quản lý thông tin vé, chuyến tàu, khách hàng
- Chức năng đổi vé, trả vé, xuất hóa đơn (PDF)
- Thống kê số lượng vé, doanh thu theo tháng/năm
- Giao diện thân thiện sử dụng Java Swing
- Kết nối cơ sở dữ liệu SQL Server

---

## 🛠️ Công nghệ sử dụng

- **Java SE 8+**
- **Java Swing (GUI)**
- **SQL Server** (.bacpac)
- Thư viện hỗ trợ:
  - `jgoodies-forms`
  - `miglayout`
  - `jcalendar`

---

## 🗂️ Cấu trúc thư mục

```bash
QuanLyBanVeTau/
│
├── src/ # Mã nguồn chính (Java)
├── bin/ # File đã biên dịch (.class)
├── lib/ # Thư viện JAR
├── images/, icons/ # Ảnh và biểu tượng giao diện
├── HoaDonBanVe.pdf # Mẫu hóa đơn bán vé
├── HoaDonDoiTraVeTau.pdf # Mẫu hóa đơn đổi/trả
├── .classpath, .project # File cấu hình Eclipse
└── .settings/ # Cấu hình IDE
```

---

## 🚀 Hướng dẫn chạy ứng dụng

### 1. Cài đặt

- Cài **JDK 8 trở lên**
- Sử dụng **IDE như Eclipse** hoặc chạy từ dòng lệnh

### 2. Thiết lập database

- Import file `database_QuanLyVeTau.bacpac` vào **SQL Server Management Studio**
- Cập nhật chuỗi kết nối DB trong file Java (thường ở `DBConnection.java` hoặc tương tự)

### 3. Chạy ứng dụng

- Mở project bằng Eclipse hoặc IntelliJ
- Build và chạy lớp `Main.java` trong thư mục `src/`

---

## 📄 Hóa đơn mẫu

- `HoaDonBanVe.pdf`: Mẫu hóa đơn đặt vé
- `HoaDonDoiTraVeTau.pdf`: Mẫu hóa đơn đổi/trả

---

## 📦 Các phụ thuộc (.jar)

Các thư viện cần thiết đã có sẵn trong thư mục `lib/`:

- `jgoodies-forms-1.8.0.jar`
- `jgoodies-common-1.8.0.jar`
- `miglayout15-swing.jar`
- `jcalendar-1.4.jar`

> Đảm bảo thư viện đã được add vào Build Path (trong Eclipse hoặc IDE bạn dùng)

---

## 📬 Liên hệ

> Được phát triển bởi: **LePhuocThai2502**  
> GitHub: [https://github.com/LePhuocThai2502](https://github.com/LePhuocThai2502)

---

## 📃 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


