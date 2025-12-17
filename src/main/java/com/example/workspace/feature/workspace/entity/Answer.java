package com.example.workspace.feature.workspace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "TBL_ANSWER")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Answer {
    @Id
    int answerId;

    int questionId; // foreign key
    String description;
    Timestamp createdAt;
    Timestamp updatedAt;
}
