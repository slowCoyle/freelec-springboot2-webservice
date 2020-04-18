package com.saas.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*보통 MyBatis 등에서 Dao 라고 불리는 DB Layer 접근자
* JPA에선 Repository 라고 부르며 인터페이스로 생성
* 단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입을 상속하면
* 기본적인 CRUD 메서드가 자도으로 생성된다.*/

/*심지어, @Repository를 추가할 필요도 없다. 여기서 주의할 점은 Entity 클래스와
기본 Entity Repository는 함께 위치해야한다.
둘은 아주 밀접한 관계이고, Entity 클래스는 기본 Repository가 없이는 제대로 역할을
할 수가 없다.*/
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
