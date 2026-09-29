# 🛒 Store & Order Management API

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Hệ thống Backend (RESTful API) quản lý bán hàng và đơn hàng trực tuyến, được xây dựng theo chuẩn kiến trúc doanh nghiệp bằng **Java Enterprise (Spring Boot)**.

## ✨ Tính Năng Nổi Bật (Key Features)

- **🔐 Xác thực & Phân quyền (Auth & RBAC)**: Quản lý người dùng với Spring Security và JWT. Phân tách quyền hạn rõ ràng giữa Quản trị viên (Admin) và Khách hàng (Customer).
- **📦 Quản lý Sản phẩm & Danh mục**: Cung cấp các API CRUD đầy đủ cho sản phẩm và danh mục.
- **🛒 Xử lý Đơn hàng (Order Processing)**: API đặt hàng, tính toán tổng tiền, và cập nhật trạng thái đơn.
- **🛡️ Đảm bảo Toàn vẹn Dữ liệu**: Sử dụng **Database Transaction** (Spring Data JPA / Hibernate) để đảm bảo tính nhất quán của dữ liệu khi checkout (tránh sai lệch tồn kho).
- **🧪 Unit Testing**: Kiểm thử logic tính toán và xử lý ngoại lệ chặt chẽ với **JUnit 5**.

## 🛠️ Công Nghệ Sử Dụng (Tech Stack)

- **Ngôn ngữ**: Java 17
- **Framework**: Spring Boot 3.4
- **ORM & Database**: Spring Data JPA, Hibernate, MySQL
- **Bảo mật**: Spring Security, JWT (io.jsonwebtoken)
- **Công cụ Build**: Maven
- **Kiểm thử**: JUnit 5

## 🚀 Cài Đặt & Khởi Chạy (Getting Started)

### Yêu cầu hệ thống
- Java 17+
- MySQL Server
- Maven

### Các bước chạy dự án
1. Clone repository:
   ```bash
   git clone https://github.com/luandz123/WEB-cuoi-ky.git
   cd WEB-cuoi-ky
   ```
2. Cấu hình database:
   - Mở file `src/main/resources/application.properties` (hoặc `application.yml`).
   - Sửa cấu hình `spring.datasource.url`, `username`, và `password` cho khớp với MySQL của bạn.
3. Build và Run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 📂 Kiến Trúc Dự Án
Dự án tuân thủ nghiêm ngặt mô hình phân tầng OOP/SOLID:
- **Controller Layer**: Tiếp nhận HTTP Request và phản hồi JSON.
- **Service Layer**: Xử lý logic nghiệp vụ (Business logic).
- **Repository Layer**: Giao tiếp với Database (Spring Data JPA).
- **Model/Entity Layer**: Định nghĩa cấu trúc dữ liệu quan hệ (One-to-Many, Many-to-One).
