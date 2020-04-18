package com.saas.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * 태스트를 진행할 때 제이유닛에 내장된 실행자 외에 다른 실행자를 실행
 * 여기서는 SpringRunner 라는 스프링 실행자를 사요한다.
 * 즉, 스프링 부트 테스트와 제이유닛 사이에 연결자 역할을 한다.*/
@RunWith(SpringRunner.class)
/*
 * 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
 * 선언할 경우 @Controller, @ControllerAdvice등 사용 가능
 * 단, @Service, @Component, @Repository 등은 사용할 수 없다.
 * 여기서는 컨트롤러만 사용하기 때문에 선언한다.
 * */
@WebMvcTest
public class HelloControllerTest {

    /*스프링이 관리하는 빈을 주입*/
    @Autowired
    /*
     * 웹 API를 테스트할 때 사용
     * 스프링 MVC 테스트의 시작점
     * 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
     * */
    private MockMvc mvc;

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        /*MockMvc 를 통해 /hello 주소로 HTTP GET 요청*/
        mvc.perform(get("/hello"))
                /*mvc.porform의 결과를 검증
                 * HTTP Header의 Status를 검증
                 * 우리가 흔히 아는 상태 코드 점검
                 */
                .andExpect(status().isOk())
                /*mvc.perform의 결과를 검증
                 * 응답 본문의 내용을 검증
                 * Controller 에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증*/
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto() throws Exception {
        String name = "name";
        int amount = 1;

        mvc.perform(get("/hello/dto")
                /* .param
                * API 테스트할 때 사용될 요청 파라미터를 설정
                * 단, 값은 String 만 허용
                * 그래서 숫자/ 날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능*/
                .param("name", name)
                .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                /* jsonPath
                * JSON 응답값을 필드별로 검증할 수 있는 메소드
                * $를 기준으로6필드명을 명시
                */
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}