package org.example.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
/*
assertJ가 JUnit의 assertThat보다 편함.
- CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않음
- 자동완성이 좀 더 확실하게 지원
 */
public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        /*
         assertThat : 검증하고 싶은 대상을 메소드 인자로 받음
         isEqualTo : assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을때만 성공
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
