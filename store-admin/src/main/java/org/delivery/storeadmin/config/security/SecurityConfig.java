package org.delivery.storeadmin.config.security;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
@Configuration
@EnableWebSecurity // security 활성화
public class SecurityConfig {
    private List<String> SWAGGER = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/open-api/**"
    );

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 보안 강화: CSRF 공격으로부터 애플리케이션을 보호 disable가 활성화 안함 활성화는 default
                // 현 상태 swagger는 들어가지지만 그냥 주소로 들어갈땐 로그인 해야지 들어가지게끔 됨
                .csrf().disable()
                .authorizeHttpRequests(it -> {
                    it
                            .requestMatchers(
                                    PathRequest.toStaticResources().atCommonLocations()
                            ).permitAll() // resource 에 대해서는 모든 요청 허용(인증없이 통과)
                            // swagger 는 인증 없이 통과
                            .requestMatchers(
                                    SWAGGER.toArray(new String[0])
                            ).permitAll()
                            // 그 외 모든 요청은 인증 사용
                            .anyRequest().authenticated()
                    ;
                })
//                .formLogin(Customizer.withDefaults())
                .formLogin(from -> from
                        .defaultSuccessUrl("/main", true)
                        .permitAll())

        ;
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
