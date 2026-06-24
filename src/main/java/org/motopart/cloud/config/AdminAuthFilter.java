package org.motopart.cloud.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.motopart.cloud.common.ApiBaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;

/**
 * Guards admin write endpoints with a shared token header, reproducing the original
 * scheme (header "token"). Configure the expected value via app.admin.token.
 */
@Component
@Order(1)
public class AdminAuthFilter extends OncePerRequestFilter {

    private static final Set<String> ADMIN_PATHS = Set.of(
            "/year", "/makers", "/model", "/parts", "/subpart",
            "/customad", "/adminpost", "/cleardata/1");

    private final String adminToken;
    private final ObjectMapper mapper = new ObjectMapper();

    public AdminAuthFilter(@Value("${app.admin.token}") String adminToken) {
        this.adminToken = adminToken;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String method = request.getMethod();
        String path = request.getRequestURI();
        boolean isWrite = "POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method);
        boolean guarded = isWrite && ADMIN_PATHS.stream().anyMatch(path::endsWith);

        // The /makers, /model, /parts, /subpart, /year, /customad paths also serve GET (public).
        // Only guard the write methods.
        if (guarded) {
            String token = request.getHeader("token");
            if (token == null || !token.equals(adminToken)) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                mapper.writeValue(response.getWriter(),
                        ApiBaseResponse.error("Unauthorized: invalid admin token"));
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
