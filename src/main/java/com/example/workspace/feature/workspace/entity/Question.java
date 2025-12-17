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
@Table(name = "TBL_QUESTION")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question {
    @Id
    int questionId;

    int qaSectionId;  // foreign key

    String title;
    String description;
    Timestamp createdAt;
    Timestamp updatedAt;
}
