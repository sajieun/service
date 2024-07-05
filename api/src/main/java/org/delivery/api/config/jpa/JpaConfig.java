package org.delivery.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.delivery.db") // 이렇게 해야지 api가 db를 사용할 때 오류가 없어진다 !
@EnableJpaRepositories(basePackages = "org.delivery.db")
public class JpaConfig {
}
