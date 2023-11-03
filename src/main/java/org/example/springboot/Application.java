package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 어노테이션들을 모두 활성화 할 수 있도록 하는 어노테이션
// 이 어노테이션이 있는 위치부터 설정을 읽어감. 따라서 이 클래스는 항상 프로젝트의 최상단에 위치해야 함.
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행

        /*
        내장 WAS : Web Application Server
        - 외부에 WAS를 두지 않고 내부에 WAS를 실행
        - 톰켓 설치할 필요 없음
        - 스프링 부트로 만들어진 Jar 파일(실행 가능한 Java 패키징 파일)로 실행
        - 언제 어디서나 같은 환경에서 스프링 부트 배포 가능
         */
    }
}
