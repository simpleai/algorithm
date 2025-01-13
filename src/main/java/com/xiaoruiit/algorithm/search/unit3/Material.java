package com.xiaoruiit.algorithm.search.unit3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Data
public class Material {

    private String code;
    private SceneUnit sceneUnit;
    private List<UnitFormula> formulas;

    private List<SceneCaleResult> results;

    public Material() {}{
        // 测试数据
        List<UnitFormula> unitFormulas = new ArrayList<>();
        UnitFormula unitFormula = new UnitFormula(1, "件", 10, "盒");
        UnitFormula unitFormula2 = new UnitFormula(1, "件", 100, "包");
        UnitFormula unitFormula3 = new UnitFormula(1, "件", 1000, "克");
        unitFormulas.add(unitFormula);
        unitFormulas.add(unitFormula2);
        unitFormulas.add(unitFormula3);
        this.setFormulas(unitFormulas);

        SceneUnit sceneUnit = new SceneUnit("件", "盒", "包", "克");
        this.setSceneUnit(sceneUnit);
    }

    public SceneCaleResult buildByType(String leftUnitType, String rightUnitType, DirectedGraph directedGraph) {
        SceneCaleResult sceneCaleResult = buildByUnit(getUnitByType(leftUnitType), getUnitByType(rightUnitType), directedGraph);
        sceneCaleResult.setLeftUnitType(leftUnitType);
        sceneCaleResult.setRightUnitType(rightUnitType);
        return sceneCaleResult;
    }

    /**
     * 有向图计算单位换算
     * @param leftUnit
     * @param rightUnit
     * @param directedGraph
     * @return
     */
    private SceneCaleResult buildByUnit(String leftUnit, String rightUnit, DirectedGraph directedGraph) {
        SceneCaleResult sceneCaleResult = new SceneCaleResult();
        sceneCaleResult.setLeftUnit(leftUnit);
        sceneCaleResult.setRightUnit(rightUnit);
        sceneCaleResult.setMolecular(1);
        sceneCaleResult.setDenominator(1);

        if (leftUnit.equals(rightUnit)){
            return sceneCaleResult;
        }

        // 缓存
        Map<String, SceneCaleResult> cache = new HashMap<>();
        if (cache.get(leftUnit + "-" + rightUnit) != null) {
            return cache.get(leftUnit + "-" + rightUnit);
        }

        // 标记是否访问过
        Map<String, Boolean> isVisitedMap = new HashMap<>();
        for (String node : directedGraph.getNodes()) {
            isVisitedMap.put(node, false);
        }
        isVisitedMap.put(leftUnit, true);

        // 起点到当前节点的系数
        Map<String, Coefficient> coefficientMap = new HashMap<>();
        coefficientMap.put(leftUnit, new Coefficient(1,1));

        Queue<String> queue = new LinkedList<>();
        queue.add(leftUnit);

        /**
         * 遍历节点，计算最初起点到此起点所有终点的权重（Map<String, Coefficient> coefficientMap），添加边的终点作为新的节点（Queue<String> queue）；
         */
        while (!queue.isEmpty()) {
            String unit = queue.poll();

            if (unit.equals(rightUnit)) {
                sceneCaleResult.setMolecular(coefficientMap.get(unit).getMolecular());
                sceneCaleResult.setDenominator(coefficientMap.get(unit).getDenominator());

                cache.put(leftUnit + "-" + rightUnit, sceneCaleResult);

                return sceneCaleResult;
            }

            List<Edge> edges = directedGraph.getEdges().get(unit);
            for (Edge edge : edges) {
                while (!isVisitedMap.get(edge.getRight())){// 之前的每一个都需要更新距离
                    // 计算最初起点到此起点所有终点的权重
                    // 约分
                    int a = coefficientMap.get(unit).getMolecular() * edge.getMolecular();
                    int b = coefficientMap.get(unit).getDenominator() * edge.getDenominator();
                    int gcd = gcd(a, b);
                    // 计算结果放在临时map中。  注意：不能改变图的值
                    coefficientMap.put(edge.getRight(), new Coefficient(a / gcd, b / gcd));

                    // 添加边的终点作为新节点
                    queue.add(edge.getRight());

                    // 当前节点已被访问
                    isVisitedMap.put(edge.getRight(), true);
                }
            }
        }

        throw new RuntimeException("未找到单位转换系数,左侧单位:" + leftUnit + ",右侧单位:"+ rightUnit);
    }

    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String getUnitByType(String unitType) {
        if ("采购".equals(unitType)) {
            return this.getSceneUnit().getPurchaseUnit();
        } else if ("发货".equals(unitType)) {
            return this.getSceneUnit().getSendOutUnit();
        } else if ("库存".equals(unitType)) {
            return this.getSceneUnit().getStockUnit();
        } else if ("扣料".equals(unitType)) {
            return this.getSceneUnit().getDeductionUnit();
        }
        return null;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Coefficient {
    /**
     * 分子
     */
    public int molecular;
    /**
     * 分母
     */
    public int denominator;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class SceneUnit {

    private String purchaseUnit;
    private String sendOutUnit;
    private String stockUnit;
    private String deductionUnit;
}

/**
 * 例：1 件 = 10 盒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class UnitFormula {

    private Integer leftNumber;
    private String leftUnit;

    private Integer rightNumber;
    private String rightUnit;

}


@Data
@NoArgsConstructor
@AllArgsConstructor
class SceneCaleResult {

    private String leftUnitType;
    private String leftUnit;
    private String rightUnitType;
    private String rightUnit;
    /**
     * 分子
     */
    public int molecular;
    /**
     * 分母
     */
    public int denominator;
}

