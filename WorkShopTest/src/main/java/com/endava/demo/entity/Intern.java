package com.endava.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Table(name = "intern")
@Entity
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @Column(name = "stream")
    @Enumerated(EnumType.STRING)
    private InternStreams stream;

    public Intern(String name, int age, InternStreams stream) {
        this.name = name;
        this.age = age;
        this.stream = stream;
    }
}
