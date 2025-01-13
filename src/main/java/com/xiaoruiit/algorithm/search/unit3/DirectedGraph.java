package com.xiaoruiit.algorithm.search.unit3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectedGraph {

    public Set<String> nodes;// 所有的点

    public Map<String, List<Edge>> edges;// 每个点的有向边

    public static DirectedGraph buildGraph(Material material){
        // 构建有向图
        Set<String> leftUnits = material.getFormulas().stream().map(UnitFormula::getLeftUnit).collect(Collectors.toSet());
        Set<String> rightUnits = material.getFormulas().stream().map(UnitFormula::getRightUnit).collect(Collectors.toSet());

        Map<String, List<Edge>> edges = new HashMap<>();
        for (UnitFormula formula : material.getFormulas()) {
            Edge edge = new Edge(formula.getRightUnit(), formula.getRightNumber(), formula.getLeftNumber());
            List<Edge> orDefault = edges.getOrDefault(formula.getLeftUnit(), new ArrayList<>());
            orDefault.add(edge);
            edges.put(formula.getLeftUnit(), orDefault);

            Edge edge2 = new Edge(formula.getLeftUnit(), formula.getLeftNumber(), formula.getRightNumber());
            List<Edge> orDefault2 = edges.getOrDefault(formula.getRightUnit(), new ArrayList<>());
            orDefault2.add(edge2);
            edges.put(formula.getRightUnit(), orDefault2);
        }

        leftUnits.addAll(rightUnits);

        DirectedGraph graph = new DirectedGraph(leftUnits, edges);
        return graph;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Edge {

    public String right;

    /**
     * 分子
     */
    public int molecular;
    /**
     * 分母
     */
    public int denominator;
}