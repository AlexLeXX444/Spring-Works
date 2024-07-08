package ru.app.springapp.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_group_name")
    private String groupName;

    @JsonCreator
    public Student(@JsonProperty("name") String name, @JsonProperty("groupName") String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

}
