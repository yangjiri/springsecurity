package io.security.corespringsecurity.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// DBに保存するためのEntity。DBテーブルとマッピングされる。
@Entity // JPA技術
@Data // Lombokアノテーション。getter,setter自動生成してくれる。
public class Account {

    @Id
    @GeneratedValue
    private Long Id;
    private String username;
    private String password;
    private String email;
    private String age;
    private String role;


}
