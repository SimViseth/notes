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
@Table(name = "TBL_DOCUMENT")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Document {
    @Id
    int documentId;

    int workspaceId; // foreign key
    String title;
    String content;
    boolean isPrivate;
    boolean isDelete;
    Timestamp createdAt;
    Timestamp updatedAt;
}
