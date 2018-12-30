package com.osetrova.designpatterns.model.visitor;

import com.osetrova.designpatterns.model.Student;
import com.osetrova.designpatterns.model.tree.AcceptVisitorNode;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubjectMarksStatisticVisitor implements BinaryTreeVisitor<Student> {

    private Map<Student, Map<String, List<Integer>>> allMarks = new HashMap<>();

    @Override
    public void collectStatistic(AcceptVisitorNode<Student> node) {
        allMarks.put(node.getKey(), node.getKey().getSubjectMarks());
    }

    public Map<Student, Double> getMarksAvg(String subject) {
        return allMarks.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .filter(s -> s.getKey().equals(subject))
                                .map(Map.Entry::getValue)
                                .flatMap(Collection::stream)
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(Double.NaN)))
                .entrySet().stream().sorted(Comparator.comparing((Map.Entry<Student, Double> e) -> e.getValue()).reversed()
                                                    .thenComparing((Map.Entry<Student, Double> e) -> e.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<Student, List<Integer>> getAllMarks(String subject) {
        return allMarks.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                        .filter(s -> s.getKey().equals(subject))
                        .map(Map.Entry::getValue)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<Student, Integer> getMaxMark(String subject) {
        return allMarks.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .filter(s -> s.getKey().equals(subject))
                                .map(Map.Entry::getValue)
                                .flatMap(Collection::stream)
                                .mapToInt(Integer::intValue)
                                .max()
                                .orElse(0)))
                .entrySet().stream().sorted(Comparator.comparing((Map.Entry<Student, Integer> e) -> e.getValue()).reversed()
                                                        .thenComparing((Map.Entry<Student, Integer> e) -> e.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<Student, Integer> getMinMark(String subject) {
        return allMarks.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .filter(s -> s.getKey().equals(subject))
                                .map(Map.Entry::getValue)
                                .flatMap(Collection::stream)
                                .mapToInt(Integer::intValue)
                                .min()
                                .orElse(0)))
                .entrySet().stream().sorted(Comparator.comparing((Map.Entry<Student, Integer> e) -> e.getValue())
                                                        .thenComparing((Map.Entry<Student, Integer> e) -> e.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
