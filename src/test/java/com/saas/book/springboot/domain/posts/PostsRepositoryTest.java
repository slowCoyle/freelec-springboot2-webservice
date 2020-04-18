package com.saas.book.springboot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
/*별다른 설정 없이 아래 어노테이션을 사요할 경우 H2 데이터 베이스를 자동으로 실행해준다.*/
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        /*테이블 posts에 insert/update 쿼리 실행
        * id 값이 있다면 update가, 없다면 insert*/
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("slowcoyle@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }
}