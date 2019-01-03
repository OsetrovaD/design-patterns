package com.osetrova.model.visitor;

import com.osetrova.designpatterns.iterator.BinaryTreeIterator;
import com.osetrova.designpatterns.model.Student;
import com.osetrova.designpatterns.model.tree.BinaryTree;
import com.osetrova.designpatterns.model.tree.NodeAcceptVisitorDecorator;
import com.osetrova.designpatterns.model.visitor.SubjectMarksStatisticVisitor;
import com.osetrova.designpatterns.strategy.DFSPreOrderIterationStrategy;
import com.osetrova.util.TestTreeInitUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class StudentMarksStatisticTest {

    private BinaryTree<Student> studentBinaryTree = TestTreeInitUtil.buildStudentTree();

    @Test
    public void checkGetAvg() {
        BinaryTreeIterator<Student> iterator = new BinaryTreeIterator<>(studentBinaryTree, DFSPreOrderIterationStrategy.getInstance());
        SubjectMarksStatisticVisitor visitor = new SubjectMarksStatisticVisitor();

        while (iterator.hasNext()) {
            new NodeAcceptVisitorDecorator<Student>(iterator.next()).accept(visitor);
        }

        List<Double> expectedAvgMarks = Stream.of(
                Arrays.asList(7, 10, 5, 5, 9),
                Arrays.asList(8, 4, 10, 4, 9, 8, 6, 10),
                Arrays.asList(7, 5, 7, 9, 9),
                Arrays.asList(9, 2, 1, 8, 3),
                Arrays.asList(5, 7, 2, 7, 6, 8),
                Arrays.asList(10, 8, 6, 10, 7, 6)
        )
        .map(x -> x.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0))
        .sorted(reverseOrder())
        .collect(toList());

        assertEquals(expectedAvgMarks, new ArrayList<>(visitor.getMarksAvg("Физика").values()));
    }

    @Test
    public void checkGetMaxMark() {
        BinaryTreeIterator<Student> iterator = new BinaryTreeIterator<>(studentBinaryTree, DFSPreOrderIterationStrategy.getInstance());
        SubjectMarksStatisticVisitor visitor = new SubjectMarksStatisticVisitor();

        while (iterator.hasNext()) {
            new NodeAcceptVisitorDecorator<Student>(iterator.next()).accept(visitor);
        }

        Map<Student, Integer> maxMark = visitor.getMaxMark("Математика");
        List<Integer> expectedMaxMarks = Arrays.asList(10, 10, 10, 10, 9, 8);

        List<Long> expectedCardsNumbers = Arrays.asList(7L, 19L, 24L, 27L, 35L, 18L);
        List<Long> cardNumbers = maxMark.keySet().stream().map(Student::getStudentCardNumber).collect(Collectors.toList());

        assertEquals(expectedMaxMarks, new ArrayList<>(maxMark.values()));
        assertEquals(expectedCardsNumbers, cardNumbers);
    }

    @Test
    public void checkGetMinMark() {
        BinaryTreeIterator<Student> iterator = new BinaryTreeIterator<>(studentBinaryTree, DFSPreOrderIterationStrategy.getInstance());
        SubjectMarksStatisticVisitor visitor = new SubjectMarksStatisticVisitor();

        while (iterator.hasNext()) {
            new NodeAcceptVisitorDecorator<Student>(iterator.next()).accept(visitor);
        }

        Map<Student, Integer> minMark = visitor.getMinMark("Химия");
        List<Integer> expectedMinMarks = Arrays.asList(2, 2, 2, 3, 3, 4);

        List<Long> expectedCardsNumbers = Arrays.asList(19L, 27L, 35L, 18L, 24L, 7L);
        List<Long> cardNumbers = minMark.keySet().stream().map(Student::getStudentCardNumber).collect(Collectors.toList());

        assertEquals(expectedMinMarks, new ArrayList<>(minMark.values()));
        assertEquals(expectedCardsNumbers, cardNumbers);
    }

    @Test
    public void checkGetAllMarks() {
        BinaryTreeIterator<Student> iterator = new BinaryTreeIterator<>(studentBinaryTree, DFSPreOrderIterationStrategy.getInstance());
        SubjectMarksStatisticVisitor visitor = new SubjectMarksStatisticVisitor();

        while (iterator.hasNext()) {
            new NodeAcceptVisitorDecorator<Student>(iterator.next()).accept(visitor);
        }

        Map<Student, List<Integer>> allMarks = visitor.getAllMarks("Химия");
        List<List<Integer>> expectedMarks = Arrays.asList(
            Arrays.asList(7, 4, 6, 7, 9),
            Arrays.asList(7, 7, 3, 9, 10, 5),
            Arrays.asList(9, 5, 2, 5, 9, 4, 8),
            Arrays.asList(10, 7, 6, 4, 3),
            Arrays.asList(8, 4, 10, 9, 2, 8),
            Arrays.asList(7, 9, 2, 8)
        );

        List<Long> expectedCardsNumbers = Arrays.asList(7L, 18L, 19L, 24L, 27L, 35L);
        List<Long> cardNumbers = allMarks.keySet().stream().map(Student::getStudentCardNumber).collect(Collectors.toList());

        assertEquals(expectedCardsNumbers, cardNumbers);
        assertEquals(expectedMarks, new ArrayList<>(allMarks.values()));
    }
}
