package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@RunWith(SpringRunner.class)
// 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴. 즉. 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest
/*
- Web에 집중할 수 있는 어노테이션
- 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음.
- 단, @Service, @Component, @Repository 등은 사용할 수 없음.
 */
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 웹 API를 테스트 할 때 사용

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청.
                .andExpect(status().isOk()) // HTTP Header의 Status 검증. 여기선 OK 즉, 200 인지 아닌지 검증.
                .andExpect(content().string(hello)); // 응답 본문의 내용 검증. Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증.
    }

    @Test
    public void helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(get("/hello/dto")
                        .param("name", name) // API 테스트할 떄 사용될 요청 파라미터를 설정
                        .param("amount", String.valueOf(amount))) // String만 적용됨
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // JSON 응답값을 필드별로 검증할 수 있는 메소드. $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
