package vn.scrip.buoi26.config;

import vn.scrip.buoi26.entity.User;
import vn.scrip.buoi26.model.dto.UserDTO;
import vn.scrip.buoi26.model.enums.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthorizationInterceptor implements HandlerInterceptor {
    private final HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
        if (currentUser == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            return false;
        }

        if (!currentUser.getRole().equals(UserRole.ADMIN)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403
            return false;
        }

        return true;
    }
}