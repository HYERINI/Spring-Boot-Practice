//회원 레포지토리 메모리 구현체
package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

// MemberRepository 에 정의해둔 함수들을 여기서 구현한다고 생각하면 됨
// 동시성 문제가 고려되어 있지 않음 - 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //아이디값에 매핑해서 멤버 객체 저장할 해시맵
    private static long sequence = 0L; //아이디값을 하나씩 더해서 지정해줄 변수

    // 멤버 객체를 받아서 아이디값을 sequence + 1 해서 지정해준 후
    // 해당 아이디값을 가져와서 해시맵의 키, 멤버객체를 값으로 put 해줌
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //store에 저장된 객체들 중 아이디값에 해당하는 멤버 객체 반환
        // null일수도 있으니 optional로 감싸줘~
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //store에 저장된 객체들 반복문 돌려서 방문
        //멤버의 이름을 가져왔을 때 param의 name과 같은 것만 추출
        //findAny() 해당하는 애들 다 가져와.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
