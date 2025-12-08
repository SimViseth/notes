package com.example.workspace.entity;

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
@Table(name = "TBL_QASECTION")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QaSection {
    @Id
    int qaSectionId;

    String title;
    Timestamp createdAt;
    Timestamp updatedAt;
}
