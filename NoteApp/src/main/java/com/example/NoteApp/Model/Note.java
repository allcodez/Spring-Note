package com.example.NoteApp.Model;

import jakarta.persistence.*;

@Entity
public class Note {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName =  "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )

    private int id;
    private String title;
    private String content;

    public Note() {
    }

    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
