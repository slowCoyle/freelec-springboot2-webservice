package com.saas.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
// 스프링 부트의 자동 설정, 스프링 빈 읽기 생성을 모두 자동으로 설정한다.
// 특히나, 해당 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 존재해야한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*
         메인 메서드에서 실행하는 SpringApplication으로 인해 내장 WAS(Web Application Server)를 실행한다.
         내장 AWS 란 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 이야기한다.
         이렇게 하면 항상 서버에 톰캣을 설치할 필요가 없게되고, 스프링 부트로 만들어진 Jar 파일(실행가능한 Java 패키지
         파일)로 실행하면된다.
        */

        /*
        * 스프링 부트에서만 내장 WAS를 사용하는 것은 아니다. 그러나, 스프링 부트에서는 내장 WAS를 사용하기를 권잘한다.
        * 그이유는 '언제 어디서나 같은 환경에서 스플링 부트를 배포'할 수 있기 때문이다.
        * */
        SpringApplication.run(Application.class, args);
    }
}
