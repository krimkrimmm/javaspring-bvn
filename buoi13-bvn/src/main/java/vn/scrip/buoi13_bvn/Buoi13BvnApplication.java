//Yêu cầu
//Trong trang chi tiết person: http://localhost:8080/person/{id} thực hiện tìm kiếm các person liên quan với person hiện tại và hiển thị trong trang chi tiết (person.html).
//
//Hôm trước đã hiển thị chi tiết, hôm nay hiển thị thêm các person liên quan
//
//Person liên quan lấy như sau:
//
//Cùng gender với person hiện tại
//Không trùng ID (nghĩa là trong ds person liên quan, không có person trùng với person hiện tại)
//Sắp xếp theo id giảm dần
//Giới hạn 4 person
package vn.scrip.buoi13_bvn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Buoi13BvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(Buoi13BvnApplication.class, args);
	}

}







