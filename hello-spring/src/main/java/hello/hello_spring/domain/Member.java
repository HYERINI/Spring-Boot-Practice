// 회원 객체
package hello.hello_spring.domain;

public class Member {
    private Long id; // 멤버 한 명 (객체)에 대한 아이디 값
    private String name; //멤버 이름

    //아이디 값을 가져오는 getter 함수
    public Long getId() {
        return id;
    }
    //아이디를 param 값으로 저장하는 setter 함수
    public void setId(Long id){
        this.id = id;
    }

    //이름을 가져오는 getter 함수
    public String getName(){
        return name;
    }
    //이름을 param 값으로 저장하는 setter 함수
    public void setName(String name){
        this.name = name;
    }
}
