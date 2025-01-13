package com.xiaoruiit.algorithm.search.unit3;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Material material = new Material();
        DirectedGraph directedGraph = DirectedGraph.buildGraph(material);

        List<SceneCaleResult> results = new ArrayList<>();

        List<String> sceneUnits = new ArrayList<>();
        sceneUnits.add("采购");
        sceneUnits.add("发货");
        sceneUnits.add("库存");
        sceneUnits.add("扣料");

        SceneCaleResult sceneCaleResult2 = material.buildByType("发货", "扣料", directedGraph);
        System.out.println(JSONObject.toJSONString(sceneCaleResult2));

        SceneCaleResult sceneCaleResult3 = material.buildByType("采购", "库存", directedGraph);
        System.out.println(JSONObject.toJSONString(sceneCaleResult3));

        // 算法：组合
        for (String leftUnitType : sceneUnits) {
            for (String rightUnitType : sceneUnits) {
                if (leftUnitType.equals(rightUnitType)) {
                    continue;
                }
                SceneCaleResult sceneCaleResult = material.buildByType(leftUnitType, rightUnitType, directedGraph);

                results.add(sceneCaleResult);
            }
        }
        material.setResults(results);

        System.out.println(JSONObject.toJSONString(material));
    }
}




