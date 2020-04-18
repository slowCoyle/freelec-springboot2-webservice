package com.saas.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
/*public Post() {} 와 같은 효과*/
@NoArgsConstructor
/*테이블과 링크될 크래스
* 기본 값으로 클래스의 카멜 케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
* SalesManager.java -> sales_manager table*/
@Entity
public class Posts {

    /*해당 테이블의 PK 필드를 나타낸다.*/
    @Id
    /*PK의 생성 규칙을 나타낸다.
    * GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    * 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    * 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶거나 등의 경우에 용된다.*/
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*해당 클래스의 빌더 패턴 클래스를 생성
    * 생성자 상단에 선언시 생성자에 포함된 필드만 필더에 포함*/
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
