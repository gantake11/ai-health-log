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
@Table(name = "mst_exercise_menu")
//@Where(clause = "deleted = false")
public class ExerciseMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_menu_id")
    // 運動メニューの種類のID
    private int exerciseMenuId;

    @Column(name = "exercise_menu_name", nullable = false, length = 30)
    // 運動メニューの種類名
    private String exerciseMenuName;

    @Column(name = "created_at",updatable = false)
    @CreatedDate
    // 作成日時
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    // 更新日時
    private LocalDateTime updatedAt;

    @Column(name = "delete_flg", columnDefinition = "int default 0")
    // 削除フラグ
    private boolean deleteFlg;

}
