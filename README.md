

# PBL – Quản lý Kì Thi Trắc nghiệm

## Giới thiệu

PBL là một ứng dụng Java sử dụng Hibernate ORM để quản lý dữ liệu trong cơ sở dữ liệu quan hệ. Dự án này được phát triển nhằm mục đích [mô tả mục tiêu dự án, ví dụ: quản lý sinh viên, sản phẩm, v.v.].

## Công nghệ sử dụng

- Java 8 trở lên
- Hibernate ORM
- Maven
- MySQL
- [Thêm các công nghệ khác nếu có, ví dụ: Spring Boot, JPA, v.v.]

## Cài đặt

### Yêu cầu hệ thống

- JDK 8 trở lên
- Maven
- MySQL Server

### Hướng dẫn cài đặt

1. **Clone repository:**

   ```bash
   git clone https://github.com/Johnong55/PBL.git
   cd PBL
   ```

2. **Cấu hình cơ sở dữ liệu:**

   - Tạo cơ sở dữ liệu MySQL với tên phù hợp.
   - Cập nhật thông tin kết nối trong tệp `hibernate.cfg.xml` hoặc `application.properties` (nếu sử dụng Spring Boot).

3. **Build và chạy ứng dụng:**

   ```bash
   mvn clean install
   mvn exec:java
   ```

   Hoặc nếu sử dụng Spring Boot:

   ```bash
   mvn spring-boot:run
   ```

## Cấu trúc dự án

- `src/main/java`: Mã nguồn Java
- `src/main/resources`: Tệp cấu hình Hibernate và tài nguyên khác
- `pom.xml`: Tệp cấu hình Maven

## Tính năng

- [Liệt kê các tính năng chính của ứng dụng, ví dụ: thêm/sửa/xóa dữ liệu, tìm kiếm, v.v.]

## Đóng góp

Chúng tôi hoan nghênh mọi đóng góp từ cộng đồng. Vui lòng tạo pull request hoặc mở issue để thảo luận thêm.

## Giấy phép

Dự án này được cấp phép theo [Tên giấy phép, ví dụ: MIT License].

---
