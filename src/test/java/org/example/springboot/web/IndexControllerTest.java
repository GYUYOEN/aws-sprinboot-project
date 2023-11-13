package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        // TestRestTemplate을 통해 "/"로 호출했을 때 index.mustache에 포함된 코드들이 있는지 확인
        String body = this.restTemplate.getForObject("/", String.class);

        // 전체 코드를 다 검증할 필요없으므로 contains 사용
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
