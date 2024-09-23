package org.eightbit.damdda.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${org.eightbit.client.url}")
    private String clientUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 경로에 대해 CORS 허용
                .allowedOrigins(clientUrl)  // 허용할 클라이언트 도메인
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // OPTIONS 메서드 포함
                .allowedHeaders("Authorization", "Content-Type")  // 허용할 요청 헤더
                .allowCredentials(true);  // 인증 정보를 사용할 경우 true로 설정
    }
}