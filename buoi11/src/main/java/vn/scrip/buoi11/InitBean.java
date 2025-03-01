package vn.scrip.buoi11;
import vn.scrip.buoi11.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class InitBean
{
    public InitBean() {
        System.out.println("This is InitBean");
    }
    @Bean
    public Book book1() {
        System.out.println("Init book1");
        return new Book();

    }
}


