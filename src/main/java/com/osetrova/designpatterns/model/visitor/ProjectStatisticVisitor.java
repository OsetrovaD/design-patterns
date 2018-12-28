package com.osetrova.designpatterns.model.visitor;

import com.osetrova.designpatterns.model.Student;
import com.osetrova.designpatterns.model.tree.AcceptVisitor;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectStatisticVisitor implements BinaryTreeVisitor<Student> {

    private Map<Student, Set<String>> studentProjects = new HashMap<>();

    @Override
    public void collectStatistic(AcceptVisitor<Student> node) {
        studentProjects.put(node.getKey(), node.getKey().getProjectNames());
    }

    public List<Student> getParticipants(String projectName) {
        return studentProjects.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(e -> e.getValue().contains(projectName))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<Student, Integer> getProjectsNumber() {
        return studentProjects.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Student, Set<String>> e) -> e.getValue().size()).reversed()
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
