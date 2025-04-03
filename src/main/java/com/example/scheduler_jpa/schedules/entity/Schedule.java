package com.example.scheduler_jpa.schedules.entity;

import com.example.scheduler_jpa.BaseEntity;
import com.example.scheduler_jpa.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 스케줄 등록 번호 고유 값
    private Long id;

    @Size(max = 10)
    @Column(nullable = false)
    //스케줄 제목
    private String title;

    @Column(columnDefinition = "longtext")
    // 스케줄 내용
    private String contents;

    @ManyToOne
    @JoinColumn(name="user_id")
    //스케줄을 작성한 유저를 담을 필드
    private User user;

    public Schedule() {
    }

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
