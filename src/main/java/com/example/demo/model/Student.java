package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private int id;
    private String name;
    private int age;
}
