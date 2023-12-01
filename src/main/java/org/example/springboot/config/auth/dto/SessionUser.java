package org.example.springboot.config.auth.dto;

import lombok.Getter;
import org.example.springboot.domain.user.User;

import java.io.Serializable;

// 인증된 사용자 정보만 필요
/*
User 클래스를 사용하지 않는 이유 : User 클래스에 직렬화를 구현하지 않아서
따라서 아래 코드는 직렬화 기능을 가진 세션 Dto
*/
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
