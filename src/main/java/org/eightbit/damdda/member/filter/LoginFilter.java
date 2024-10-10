package org.eightbit.damdda.member.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eightbit.damdda.member.domain.AccountCredentials;
import org.eightbit.damdda.member.domain.User;
import org.eightbit.damdda.member.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtService jwtService;

    public LoginFilter(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.jwtService = jwtService;
        setAuthenticationManager(authenticationManager); // AuthenticationManager 설정
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            AccountCredentials loginRequest = objectMapper.readValue(request.getInputStream(), AccountCredentials.class);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getLoginId(), loginRequest.getPassword());

            return getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse login request", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal(); // UserDetails로 캐스팅
        String token = jwtService.getToken(user.getMember().getId(), user.getUsername());

        response.setHeader("Authorization", "Bearer " + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Authentication failed: " + failed.getMessage());
    }
}