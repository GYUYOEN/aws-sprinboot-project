package org.example.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    /*
    @Autowired를 쓰지 않은 이유
    - 생성자로 주입받는 방식을 사용함 (@Autowired는 권장하지 않음)
    - 생성자로 Bean 객체를 받도록 하면 @Autowired와 동일한 효과를 볼 수 있음
    - final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬북의 @RequiredArgsConstructor 대신 생성해줌
    */
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
