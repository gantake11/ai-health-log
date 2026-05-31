package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mst_users")
//@Where(clause = "deleted = false")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    // ユーザーID
    private int userId;

    @Column(name = "user_name", nullable = false, length = 30)
    // ユーザー名
    private String userName;

    @Email(message = "有効なメールアドレスを入力してください")
    @Column(name = "email", nullable = false)
    // メールアドレス
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    // パスワード
    private String password;

    @Column(name = "created_at",updatable = false)
    @CreatedDate
    // 作成日時
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    // 更新日時
    private LocalDateTime updatedAt;

    @Column(name = "delete_flg", columnDefinition = "tinyint(1) default 0")
    // 削除フラグ
    private boolean deleteFlg;

}
