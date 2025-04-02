package vn.scrip.buoi23.model.response;
import lombok.*;
import org.springframework.http.HttpStatus;
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class ErrorResponse {
    private HttpStatus status;
    private Object message;
}






