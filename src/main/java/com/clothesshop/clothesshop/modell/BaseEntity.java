package com.clothesshop.clothesshop.modell;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @Column
    protected LocalDateTime modifiedAt;

    public BaseEntity() {
        LocalDateTime now = LocalDateTime.now();

        this.createdAt = now;
        this.modifiedAt = now;
    }
}