# Train Ticket Sales Management 🚆

> A Java Swing application that supports train ticket booking management, ticket exchange/refund, invoice generation, and revenue statistics..

---

## 📋 Main Features

- Book train tickets by route, date, carriage, and seat
- Manage ticket information, train routes, and customer data
- Support for ticket exchange, refund, and invoice export (PDF)
- Generate statistics on ticket quantity and revenue by month/year
- User-friendly interface built with Java Swing
- Connected to SQL Server database

---

## 🛠️ Technologies Used

- **Java SE 8+**
- **Java Swing (GUI)**
- **SQL Server** (.bacpac)
- Supporting libraries:
  - `jgoodies-forms`
  - `miglayout`
  - `jcalendar`

---

## 🗂️  Project Structure

```bash
QuanLyBanVeTau/
│
├── src/ # Main Java source code)
├── bin/ # Compiled .class files  
├── lib/ # JAR libraries
├── images/, icons/ # UI images and icons
├── HoaDonBanVe.pdf # Sample booking invoice
├── HoaDonDoiTraVeTau.pdf # Sample exchange/refund invoice
├── .classpath, .project # Eclipse configuration files
└── .settings/ # IDE settings
```

---

## 🚀 Getting Started

### 1.  Installation

- Install JDK 8 or later
- Use an IDE such as Eclipse or run from terminal

### 2. Database Setup

- Import database_QuanLyVeTau.bacpac into SQL Server Management Studio
- Update the database connection string in your Java file (usually DBConnection.java or similar)

### 3. Run the Application

- Open the project in Eclipse or IntelliJ
- Build and run Main.java located in the src/ directory

---

## 📄  Sample Invoices

- `HoaDonBanVe.pdf`: Sample booking invoice
- `HoaDonDoiTraVeTau.pdf`: Sample exchange/refund invoice

---

## 📦 Dependencies (.jar)

All required libraries are available in the lib/ directory:

- `jgoodies-forms-1.8.0.jar`
- `jgoodies-common-1.8.0.jar`
- `miglayout15-swing.jar`
- `jcalendar-1.4.jar`

> Ensure all libraries are added to your Build Path in Eclipse or your IDE of choice.

---

## 📬 Contact

> Developed by:  **LePhuocThai2502**  
> GitHub: [https://github.com/LePhuocThai2502](https://github.com/LePhuocThai2502)

---

## 📃 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


