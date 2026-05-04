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
import java.time.LocalTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_exercise_records")
//@Where(clause = "deleted = false")
public class ExerciseRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_records_id")
    // 運動の記録のID
    private int exerciseRecordsId;

    @ManyToOne
    @JoinColumn(name = "daily_records_id")
    // 日々の記録のID
    private DailyRecords dailyRecords;

    @ManyToOne
    @JoinColumn(name = "exercise_menu_id")
    // 日々の記録のID
    private ExerciseMenu exerciseMenu;

    @Column(name = "details", nullable = false)
    // 備考
    private String details;

    @Column(name = "start_time", nullable = false)
    // 開始時間
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    // 開始時間
    private LocalTime endTime;

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
