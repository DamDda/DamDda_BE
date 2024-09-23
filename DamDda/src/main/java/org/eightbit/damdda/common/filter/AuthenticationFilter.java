package org.eightbit.damdda.common.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.eightbit.damdda.common.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 토큰 존재 여부 확인
        // String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION); 아래랑 똑같은 동작
        String jwtToken = request.getHeader("Authorization");
        String username = null;
        if (jwtToken != null) {
            // 2. 토큰이 정상인지 확인
            // 토큰을 비밀키로 복호화 후 username 추출
            username = jwtService.getAuthUser(request);
            Authentication auth =
                    new UsernamePasswordAuthenticationToken(
                            username, null, java.util.Collections.emptyList());
            // security context에 저장하여 서버는 인증 정보를 가지게 됨
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        // 3. DispatcherServlet 으로 전달
        //log.info(username);
        request.setAttribute("adminId", username);
        filterChain.doFilter(request, response);
    }
}