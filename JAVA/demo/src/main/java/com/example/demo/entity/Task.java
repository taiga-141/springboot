package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer task_id;

    @Column(length=50, nullable = false)
    private Integer id;

    @Column(length=100, nullable = false)
    private String title;

    private String status;

    @Column(length=200, nullable = false)  
    private String memo;

    public Integer getTaskId() {
        return task_id;
    }
    public void setTaskId(Integer task_id) {
        this.task_id = task_id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }

    
}
