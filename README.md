

# PBL – Quản lý Kì Thi Trắc nghiệm

## Giới thiệu

PBL là một ứng dụng desktop Java dùng để quản lý các kỳ thi trắc nghiệm. Ứng dụng cho phép quản lý hệ thống câu hỏi, tạo và quản lý các kỳ thi, lập lịch thi đúng hẹn và phân lớp chính xác theo yêu cầu. Đây là công cụ hỗ trợ hiệu quả cho việc tổ chức và kiểm soát kỳ thi trắc nghiệm trong các cơ sở giáo dục.


## Công nghệ sử dụng

- Java 8 trở lên
- Hibernate ORM
- Maven
- MySQL
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
- Quản lý danh sách câu hỏi trắc nghiệm với các loại câu hỏi đa dạng  
- Tạo mới và chỉnh sửa các kỳ thi trắc nghiệm  
- Lập lịch thi chính xác theo thời gian, lớp học và môn thi  
- Quản lý danh sách thí sinh tham gia kỳ thi  
- Quản lý sự tiến bộ của lớp thông qua việc kiểm tra

## Đóng góp

Chúng tôi hoan nghênh mọi đóng góp từ cộng đồng. Vui lòng tạo pull request hoặc mở issue để thảo luận thêm.

