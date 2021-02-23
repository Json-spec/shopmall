/*
package com.shopMallProject.common.CrossOrigin;


import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

*/
/**
 * description: 跨域类 <br>
 * date: 2020/11/2 14:45 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 *//*

public class CrossOriginConfig {
    */
/**
     * 解决前后端分离跨域问题
     * @return
     *//*

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
*/
