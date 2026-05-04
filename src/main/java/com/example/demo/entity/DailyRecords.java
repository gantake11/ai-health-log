package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_daily_records")
//@Where(clause = "deleted = false")
public class DailyRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_records_id")
    // 日々の記録のID
    private int dailyRecordsId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    // ユーザーID
    private Users user;

    @Column(name = "date", nullable = false)
    // 日付
    private LocalDate date;

    @Column(name = "weight", nullable = false)
    // 体重
    private double weight;

    @Column(name = "steps", nullable = false, columnDefinition = "int default 0")
    // 歩数
    private int steps;

    @Column(name = "notes")
    // 備考
    private String notes;

    @Column(name = "gemini_message", nullable = false)
    // geminiのメッセージ
    private String geminiMessage;

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
