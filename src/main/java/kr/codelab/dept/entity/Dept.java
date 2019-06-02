package kr.codelab.dept.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor

public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "dept_group_id")
    private Long deptGroupId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Dept(String name, Long deptGroupId, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.name = name;
        this.deptGroupId = deptGroupId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setCurrentTime() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(Dept dept) {
        this.name = dept.getName();
        this.updatedAt = LocalDateTime.now();
    }
}
