package com.osetrova.model.visitor;

import com.osetrova.designpatterns.iterator.BinaryTreeIterator;
import com.osetrova.designpatterns.model.Student;
import com.osetrova.designpatterns.model.tree.BinaryTree;
import com.osetrova.designpatterns.model.tree.NodeAcceptVisitorDecorator;
import com.osetrova.designpatterns.model.visitor.ProjectStatisticVisitor;
import com.osetrova.designpatterns.strategy.DFSPreOrderIterationStrategy;
import com.osetrova.util.TestTreeInitUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StudentProjectStatisticTest {

    private BinaryTree<Student> studentBinaryTree = TestTreeInitUtil.buildStudentTree();

    @Test
    public void checkGetParticipants() {
        BinaryTreeIterator<Student> iterator = new BinaryTreeIterator<>(studentBinaryTree, DFSPreOrderIterationStrategy.getInstance());
        ProjectStatisticVisitor visitor = new ProjectStatisticVisitor();

        while (iterator.hasNext()) {
            new NodeAcceptVisitorDecorator<Student>(iterator.next()).accept(visitor);
        }

        List<Student> participants = visitor.getParticipants("Project2");

        List<Long> expectedParticipantsCardsNumbers = Arrays.asList(7L, 18L, 27L);
        List<Long> cardsNumbers = participants.stream().map(Student::getStudentCardNumber).collect(Collectors.toList());
        assertEquals(expectedParticipantsCardsNumbers, cardsNumbers);
    }

    @Test
    public void checkGetProjectsNumber() {
        BinaryTreeIterator<Student> iterator = new BinaryTreeIterator<>(studentBinaryTree, DFSPreOrderIterationStrategy.getInstance());
        ProjectStatisticVisitor visitor = new ProjectStatisticVisitor();

        while (iterator.hasNext()) {
            new NodeAcceptVisitorDecorator<Student>(iterator.next()).accept(visitor);
        }

        Map<Student, Integer> projectsNumber = visitor.getProjectsNumber();

        List<Long> expectedCardsNumbers = Arrays.asList(7L, 18L, 35L, 19L, 24L, 27L);
        List<Long> cardsNumbers = projectsNumber.keySet().stream().map(Student::getStudentCardNumber).collect(Collectors.toList());

        List<Integer> expectedProjectsNumber = Arrays.asList(4, 3, 3, 2, 2, 2);

        assertEquals(expectedCardsNumbers, cardsNumbers);
        assertEquals(expectedProjectsNumber, new ArrayList<>(projectsNumber.values()));
    }
}
