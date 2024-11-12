package org.delivery.storeadmin.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.delivery.db")
@EnableJpaRepositories(basePackages = "org.delivery.db") // org.delivery.db 하위에 있는 패키지에 있는 모든 래퍼지토리 JPA로 적용
public class JpaConfig {
}
