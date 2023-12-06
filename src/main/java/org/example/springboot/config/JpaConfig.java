package org.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // JPA Auditing 어노테이션들을 모두 활성화 할 수 있도록 하는 어노테이션. 이 어노테이션을 사용하기 위해 최소 하나의 @Entity 클래스가 필요
public class JpaConfig {
}
