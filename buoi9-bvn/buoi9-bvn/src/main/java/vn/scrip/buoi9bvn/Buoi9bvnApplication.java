//Học viên tạo class Product.java theo gợi ý dưới đây. Sử dụng thêm dependence Lombok để tối ưu quá trình tạo getter/setter, constructor
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Product {
//    private String id;
//    private String name;
//    private String description;
//    private int price;
//    private String brand;
//}
//
//// Ví dụ về 1 sản phẩm khi tạo
//Product product = new Product();
//product.setId("1234");
//product.setName("iPhone 12");
//product.setDescription("The latest iPhone");
//product.setPrice(999);
//product.setBrand("Apple");
//Product.java
//
//Yêu cầu
//Tạo ứng dụng SpringBoot để trả về danh sách Product bao gồm từ 5 -> 10 sản phẩm sử dụng GET method
//Dữ liệu trả về ở dạng JSON
//Thông tin về từng sản phẩm học viên tự tạo, không được trùng nhau
//Kiểm tra kết quả trả về từ API và capture lại màn hình khi nộp bài
package vn.scrip.buoi9bvn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

public class Buoi9bvnApplication
{

	public static void main(String[] args) {
		SpringApplication.run(Buoi9bvnApplication.class, args);
	}

}




