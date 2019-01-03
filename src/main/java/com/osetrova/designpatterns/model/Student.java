package com.osetrova.designpatterns.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Getter
@ToString(exclude = {"subjectMarks", "projectNames"})
public class Student implements Comparable<Student> {

    private Long studentCardNumber;
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjectMarks = new HashMap<>();
    private Set<String> projectNames = new HashSet<>();

    public Student(Long studentCardNumber, String firstName, String lastName) {
        this.studentCardNumber = studentCardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addMarks(String subject, Integer... marks) {
        subjectMarks.merge(subject, Arrays.asList(marks),
                (oldMarks, newMarks) -> Stream.of(oldMarks, newMarks)
                        .flatMap(Collection::stream)
                        .collect(toList()));
    }

    public void addProjects(String... projectName) {
        projectNames.addAll(Arrays.asList(projectName));
    }

    @Override
    public int compareTo(Student o) {
        return this.studentCardNumber.compareTo(o.studentCardNumber);
    }

}
