//package com.lgcns.newspacegateway;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.List;
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.setAllowedOrigins(List.of(
//                "http://kudong.kr:55020",
//                "http://kudong.kr:55021",
//                "http://kudong.kr:55022",
//                "http://kudong.kr:55023",
//                "http://kudong.kr:55025",
//                "http://localhost:8080",
//                "http://localhost:8070",
//                "http://localhost:5173"));
//        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
//        config.addAllowedHeader("*");
//        config.addExposedHeader("*");
//        config.setMaxAge(3600L);
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}



package com.lgcns.newspacegateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        // ✅ WebFlux에서는 UrlBasedCorsConfigurationSource(reactive)를 사용해야 함
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of(
                "http://d1wvssrshiud2m.cloudfront.net",
                "https://d1wvssrshiud2m.cloudfront.net",
                "http://172.18.0.2:8080",
                "http://3.82.228.233:8072",
                "lb://newspace-user-service",
                "lb://newspace-notice-service",
                "lb://newspace-news-service"
        ));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        config.addAllowedHeader("*");
        config.addExposedHeader("*");
        config.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
