package com.osetrova.util;

import com.osetrova.designpatterns.model.Student;
import com.osetrova.designpatterns.model.tree.BinaryTree;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class TestTreeInitUtil {

    public static BinaryTree<Integer> buildIntegerTree() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        testTree.add(8);
        testTree.add(3);
        testTree.add(10);
        testTree.add(1);
        testTree.add(6);
        testTree.add(14);
        testTree.add(4);
        testTree.add(7);
        testTree.add(13);

        return testTree;
    }

    public static BinaryTree<Student> buildStudentTree() {
        BinaryTree<Student> testTree = new BinaryTree<>();
        getStudents().forEach(testTree::add);

        return testTree;
    }

    private List<Student> getStudents() {
        Student firstStudent = new Student(24L, "Геннадий", "Петров");
        firstStudent.addMarks("Математика", 8, 5, 10, 9, 3);
        firstStudent.addMarks("Физика", 7, 10, 5, 5, 9);
        firstStudent.addMarks("Химия", 10, 7, 6, 4, 3);
        firstStudent.addProjects("Project1", "Project3");

        Student secondStudent = new Student(18L, "Егор", "Васильков");
        secondStudent.addMarks("Математика", 6, 2, 7, 8, 6, 2);
        secondStudent.addMarks("Физика", 8, 4, 10, 4, 9, 8, 6, 10);
        secondStudent.addMarks("Химия", 7, 7, 3, 9, 10, 5);
        secondStudent.addProjects("Project1", "Project2", "Project5");

        Student thirdStudent = new Student(27L, "Светлана", "Зайцева");
        thirdStudent.addMarks("Математика", 4, 7, 10);
        thirdStudent.addMarks("Физика", 7, 5, 7, 9, 9);
        thirdStudent.addMarks("Химия", 8, 4, 10, 9, 2, 8);
        thirdStudent.addProjects("Project1", "Project2");

        Student fourthStudent = new Student(35L, "Мария", "Логинова");
        fourthStudent.addMarks("Математика", 3, 9, 6, 9, 7);
        fourthStudent.addMarks("Физика", 9, 2, 1, 8, 3);
        fourthStudent.addMarks("Химия", 7, 9, 2, 8);
        fourthStudent.addProjects("Project1", "Project3", "Project4");

        Student fifthStudent = new Student(19L, "Александра", "Котикова");
        fifthStudent.addMarks("Математика", 3, 8, 9, 5, 10);
        fifthStudent.addMarks("Физика", 5, 7, 2, 7, 6, 8);
        fifthStudent.addMarks("Химия", 9, 5, 2, 5, 9, 4, 8);
        fifthStudent.addProjects("Project3", "Project4");

        Student sixthStudent = new Student(7L, "Фёдор", "Рыбин");
        sixthStudent.addMarks("Математика", 9, 8, 1, 3, 10, 6);
        sixthStudent.addMarks("Физика", 10, 8, 6, 10, 7, 6);
        sixthStudent.addMarks("Химия", 7, 4, 6, 7, 9);
        sixthStudent.addProjects("Project1", "Project2", "Project4", "Project5");

        return Arrays.asList(firstStudent, secondStudent, thirdStudent, fourthStudent, fifthStudent, sixthStudent);
    }
}
