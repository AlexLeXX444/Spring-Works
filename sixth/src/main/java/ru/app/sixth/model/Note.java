package ru.app.sixth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "note_creation_date")
    private Date creationDate;

    @Column(name = "note_close_date")
    private Date closeDate;

    @Column(name = "note_last_correction_date")
    private Date lastCorrectionDate;

    @Column(name = "note_content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
