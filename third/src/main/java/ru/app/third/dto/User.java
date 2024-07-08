package ru.app.third.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy  =  GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name  = "email")
    private String email;

    @Column(name  = "age")
    private int age;

    @Override
    public String toString() {
        return "User {" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
