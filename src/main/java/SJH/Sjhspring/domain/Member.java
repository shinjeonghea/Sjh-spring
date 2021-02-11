package SJH.Sjhspring.domain;

import javax.persistence.*;

//jpa가 관리하는 entitiy라는 뜻의 애노테이션
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //만약 db의 컬럼명이 username일 경우 밑의 애노테이션을 가지고 매핑할 수 있다.
    //@Column(name="username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
