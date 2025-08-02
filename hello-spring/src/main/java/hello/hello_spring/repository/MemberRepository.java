// 회원 레포지토리 인터페이스
package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 멤버 객체를 저장하는 인터페이스

    //Optinal은 리턴값이 null 이어도 감싸서  리턴해준다 고런 너낌
    Optional<Member> findById(Long id); //아이디로 멤버를 찾는 인터페이스
    Optional<Member> findByName(String name); //이름으로 멤버를 찾는 인터페이스

    List<Member> findAll(); //멤버 리스트 전체 반환 인터페이스
}
