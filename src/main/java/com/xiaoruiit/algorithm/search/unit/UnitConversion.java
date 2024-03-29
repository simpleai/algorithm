package com.xiaoruiit.algorithm.search.unit;

import java.math.BigDecimal;
import java.util.*;

/**
 * 计算单位之间的换算系数.
 * n个单位之间的公式。5个场景单位是公式中的单位。计算5个场景单位之间的换算系数
 */
public class UnitConversion {

    public static void main(String[] args) {

        // 1.构造数据
        /**
         * 1盒 = 10000小包
         * 1包 = 100小包
         * 1箱 = 10000包
         */
//        MaterialDto materialDto = constructTheData();
        /**
         * 1包 = 100小包
         * 1包 = 0.01盒
         * 1包 = 0.0001箱
         */
        MaterialDto materialDto = constructTheData2();

        // 计算
        // 2.1 构建有向图
        DirectedGraph2 graph = new DirectedGraph2();
        // 添加节点
        materialDto.getUnitConversions().stream()
                .map(MaterialDto.MaterialUnitConversionDto::getLeftUnit)
                .forEach(leftUnitName -> graph.addNode(new Node(leftUnitName)));

        materialDto.getUnitConversions().stream()
                .map(MaterialDto.MaterialUnitConversionDto::getRightUnit)
                .forEach(rightUnitName -> graph.addNode(new Node(rightUnitName)));

        // 添加边
        for (MaterialDto.MaterialUnitConversionDto unitConversion : materialDto.getUnitConversions()) {
            Edge2 edge = new Edge2(new Node(unitConversion.getLeftUnit()), new Node(unitConversion.getRightUnit()), unitConversion.getRightAmount().divide(unitConversion.getLeftAmount()));
            graph.addEdge(edge);

            Edge2 edge2 = new Edge2(new Node(unitConversion.getRightUnit()), new Node(unitConversion.getLeftUnit()), unitConversion.getLeftAmount().divide(unitConversion.getRightAmount()));
            graph.addEdge(edge2);
        }

        // 2.2 换算
        List<UnitConversionFactor> unitConversionFactors = getUnitConversionFactors(materialDto.getSceneUnits(), graph);
        System.out.println(unitConversionFactors);
    }

    private static MaterialDto constructTheData() {
        MaterialDto materialDto = new MaterialDto();

        // 1.1单位公式
        List<MaterialDto.MaterialUnitConversionDto> materialUnitConversionDtos = new ArrayList<>();
        MaterialDto.MaterialUnitConversionDto materialUnitConversion = new MaterialDto.MaterialUnitConversionDto();
        materialUnitConversion.setLeftUnit("盒");
        materialUnitConversion.setRightUnit("小包");
        materialUnitConversion.setLeftAmount(new BigDecimal("1"));
        materialUnitConversion.setRightAmount(new BigDecimal("10000"));
        materialUnitConversionDtos.add(materialUnitConversion);

        MaterialDto.MaterialUnitConversionDto materialUnitConversion2 = new MaterialDto.MaterialUnitConversionDto();
        materialUnitConversion2.setLeftUnit("包");
        materialUnitConversion2.setRightUnit("小包");
        materialUnitConversion2.setLeftAmount(new BigDecimal("1"));
        materialUnitConversion2.setRightAmount(new BigDecimal("100"));
        materialUnitConversionDtos.add(materialUnitConversion2);

        MaterialDto.MaterialUnitConversionDto materialUnitConversion3 = new MaterialDto.MaterialUnitConversionDto();
        materialUnitConversion3.setLeftUnit("箱");
        materialUnitConversion3.setRightUnit("包");
        materialUnitConversion3.setLeftAmount(new BigDecimal("1"));
        materialUnitConversion3.setRightAmount(new BigDecimal("10000"));
        materialUnitConversionDtos.add(materialUnitConversion3);

        MaterialDto.MaterialUnitConversionDto materialUnitConversion4 = new MaterialDto.MaterialUnitConversionDto();
        materialUnitConversion4.setLeftUnit("盒");
        materialUnitConversion4.setRightUnit("包");
        materialUnitConversion4.setLeftAmount(new BigDecimal("1"));
        materialUnitConversion4.setRightAmount(new BigDecimal("100"));
        materialUnitConversionDtos.add(materialUnitConversion4);

        materialDto.setUnitConversions(materialUnitConversionDtos);

        // 1.2场景单位
        List<MaterialDto.SceneUnit> sceneUnits = new ArrayList<>();
        MaterialDto.SceneUnit sceneUnit = new MaterialDto.SceneUnit();
        sceneUnit.setUnitName("包");
        sceneUnit.setUnitType(MaterialDto.SceneUnit.PlatformEnum.STOCK.getValue());
        sceneUnits.add(sceneUnit);

        MaterialDto.SceneUnit sceneUnit2 = new MaterialDto.SceneUnit();
        sceneUnit2.setUnitName("盒");
        sceneUnit2.setUnitType(MaterialDto.SceneUnit.PlatformEnum.PLATFORM_DJ.getValue());
        sceneUnits.add(sceneUnit2);

        MaterialDto.SceneUnit sceneUnit3 = new MaterialDto.SceneUnit();
        sceneUnit3.setUnitName("箱");
        sceneUnit3.setUnitType(MaterialDto.SceneUnit.PlatformEnum.PURCHASE.getValue());
        sceneUnits.add(sceneUnit3);

        MaterialDto.SceneUnit sceneUnit4 = new MaterialDto.SceneUnit();
        sceneUnit4.setUnitName("小包");
        sceneUnit4.setUnitType(MaterialDto.SceneUnit.PlatformEnum.SELL.getValue());
        sceneUnits.add(sceneUnit4);

        MaterialDto.SceneUnit sceneUnit5 = new MaterialDto.SceneUnit();
        sceneUnit5.setUnitName("盒");
        sceneUnit5.setUnitType(MaterialDto.SceneUnit.PlatformEnum.SEND_OUT.getValue());
        sceneUnits.add(sceneUnit5);

        materialDto.setSceneUnits(sceneUnits);

        return materialDto;
    }

    private static MaterialDto constructTheData2() {
        MaterialDto materialDto = new MaterialDto();

        // 1.1单位公式
        List<MaterialDto.MaterialUnitConversionDto> materialUnitConversionDtos = new ArrayList<>();
        MaterialDto.MaterialUnitConversionDto materialUnitConversion = new MaterialDto.MaterialUnitConversionDto();
        materialUnitConversion.setLeftUnit("包");
        materialUnitConversion.setRightUnit("小包");
        materialUnitConversion.setLeftAmount(new BigDecimal("1"));
        materialUnitConversion.setRightAmount(new BigDecimal("100"));
        materialUnitConversionDtos.add(materialUnitConversion);

        MaterialDto.MaterialUnitConversionDto materialUnitConversion2 = new MaterialDto.MaterialUnitConversionDto();
        materialUnitConversion2.setLeftUnit("包");
        materialUnitConversion2.setRightUnit("盒");
        materialUnitConversion2.setLeftAmount(new BigDecimal("1"));
        materialUnitConversion2.setRightAmount(new BigDecimal("0.01"));
        materialUnitConversionDtos.add(materialUnitConversion2);

        MaterialDto.MaterialUnitConversionDto materialUnitConversion3 = new MaterialDto.MaterialUnitConversionDto();
        materialUnitConversion3.setLeftUnit("包");
        materialUnitConversion3.setRightUnit("箱");
        materialUnitConversion3.setLeftAmount(new BigDecimal("1"));
        materialUnitConversion3.setRightAmount(new BigDecimal("0.0001"));
        materialUnitConversionDtos.add(materialUnitConversion3);

        materialDto.setUnitConversions(materialUnitConversionDtos);

        // 1.2场景单位
        List<MaterialDto.SceneUnit> sceneUnits = new ArrayList<>();
        MaterialDto.SceneUnit sceneUnit = new MaterialDto.SceneUnit();
        sceneUnit.setUnitName("包");
        sceneUnit.setUnitType(MaterialDto.SceneUnit.PlatformEnum.STOCK.getValue());
        sceneUnits.add(sceneUnit);

        MaterialDto.SceneUnit sceneUnit2 = new MaterialDto.SceneUnit();
        sceneUnit2.setUnitName("盒");
        sceneUnit2.setUnitType(MaterialDto.SceneUnit.PlatformEnum.PLATFORM_DJ.getValue());
        sceneUnits.add(sceneUnit2);

        MaterialDto.SceneUnit sceneUnit3 = new MaterialDto.SceneUnit();
        sceneUnit3.setUnitName("箱");
        sceneUnit3.setUnitType(MaterialDto.SceneUnit.PlatformEnum.PURCHASE.getValue());
        sceneUnits.add(sceneUnit3);

        MaterialDto.SceneUnit sceneUnit4 = new MaterialDto.SceneUnit();
        sceneUnit4.setUnitName("小包");
        sceneUnit4.setUnitType(MaterialDto.SceneUnit.PlatformEnum.SELL.getValue());
        sceneUnits.add(sceneUnit4);

        MaterialDto.SceneUnit sceneUnit5 = new MaterialDto.SceneUnit();
        sceneUnit5.setUnitName("盒");
        sceneUnit5.setUnitType(MaterialDto.SceneUnit.PlatformEnum.SEND_OUT.getValue());
        sceneUnits.add(sceneUnit5);

        materialDto.setSceneUnits(sceneUnits);

        return materialDto;
    }

    private static List<UnitConversionFactor> getUnitConversionFactors(List<MaterialDto.SceneUnit> sceneUnits, DirectedGraph2 graph) {
        List<UnitConversionFactor> unitConversionFactors = new ArrayList<>();
        for (MaterialDto.SceneUnit unit : sceneUnits) {
            for (MaterialDto.SceneUnit unit2 : sceneUnits) {
                BigDecimal v = getExchangeRate(graph, new Node(unit.getUnitName()), new Node(unit2.getUnitName()));

                UnitConversionFactor unitConversionFactor = new UnitConversionFactor();
                unitConversionFactor.setSkuCode("");
                unitConversionFactor.setLeftSceneUnitName(unit.getUnitName());
                unitConversionFactor.setLeftSceneUnitType(unit.getUnitType());
                unitConversionFactor.setRightSceneUnitName(unit2.getUnitName());
                unitConversionFactor.setRightSceneUnitType(unit2.getUnitType());
                unitConversionFactor.setFactor(v);

                unitConversionFactors.add(unitConversionFactor);
            }
        }
        return unitConversionFactors;
    }

    public static BigDecimal depthFirstSearch(DirectedGraph2 graph, Node startNode, Node endNode) {
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node node : graph.getNodes()) {
            visited.put(node, false);
        }
        BigDecimal v = depthFirstSearchHelper(graph, startNode, endNode, visited);
        if(v.compareTo(BigDecimal.ZERO) > 0){
            return v;
        }else {
            throw new RuntimeException("无法计算出" + startNode.getLabel() + "到" + endNode.getLabel() + "的换算关系");
        }
    }

    private static BigDecimal depthFirstSearchHelper(DirectedGraph2 graph, Node currentNode, Node endNode, Map<Node, Boolean> visited) {
        visited.put(currentNode, true);
        if (currentNode.equals(endNode)) {// 结束条件
            return BigDecimal.ONE;
        }
        for (Edge2 edge : graph.getEdges(currentNode)) {
            Node neighbor = edge.getDestination();
            if (!visited.get(neighbor)) {
                BigDecimal distance = depthFirstSearchHelper(graph, neighbor, endNode, visited);// 递归内容
                if (distance.compareTo(BigDecimal.ZERO) > 0) {
                    return edge.getWeight().multiply(distance);
                }
            }
        }
        return new BigDecimal("-1");
    }

    /**
     * 计算从起始节点到终止节点的换算关系。使用广度优先搜索
     * @param graph 有向图
     * @param startNode 起始节点
     * @param endNode 终止节点
     * @return 换算关系
     */
    public static BigDecimal getExchangeRate(DirectedGraph2 graph, Node startNode, Node endNode) {
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node node : graph.getNodes()) {
            visited.put(node, false);
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, BigDecimal> distances = new HashMap<>(); // 存储节点到起点的系数
        queue.add(startNode);
        visited.put(startNode, true);
        distances.put(startNode, BigDecimal.ONE); // 起始节点到自己的系数为1

        // 外循环存储广度优先顺序访问到的节点，内循环遍历节点的有向边，将边指向的节点挨个加入到队列尾部
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode.equals(endNode)) { // 找到终止节点，直接返回
                return distances.get(currentNode);
            }
            for (Edge2 edge : graph.getEdges(currentNode)) {
                Node neighbor = edge.getDestination();
                if (!visited.get(neighbor)) {
                    BigDecimal distance = distances.get(currentNode).multiply(edge.getWeight());
                    distances.put(neighbor, distance); // 更新邻居节点的系数
                    queue.add(neighbor);
                    visited.put(neighbor, true);
                }
            }
        }

        throw new IllegalArgumentException("无法计算出" + startNode.getLabel() + "到" + endNode.getLabel() + "的换算关系");
    }

}

class UnitConversionFactor {
    private String skuCode;
    private String leftSceneUnitName;
    private String leftSceneUnitType;
    private String rightSceneUnitName;
    private String rightSceneUnitType;
    private BigDecimal factor;

    @Override
    public String toString() {
        return "UnitConversionFactor{" +
                "skuCode='" + skuCode + '\'' +
                ", leftSceneUnitName='" + leftSceneUnitName + '\'' +
                ", leftSceneUnitType='" + leftSceneUnitType + '\'' +
                ", rightSceneUnitName='" + rightSceneUnitName + '\'' +
                ", rightSceneUnitType='" + rightSceneUnitType + '\'' +
                ", factor=" + factor +
                '}';
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getLeftSceneUnitName() {
        return leftSceneUnitName;
    }

    public void setLeftSceneUnitName(String leftSceneUnitName) {
        this.leftSceneUnitName = leftSceneUnitName;
    }

    public String getLeftSceneUnitType() {
        return leftSceneUnitType;
    }

    public void setLeftSceneUnitType(String leftSceneUnitType) {
        this.leftSceneUnitType = leftSceneUnitType;
    }

    public String getRightSceneUnitName() {
        return rightSceneUnitName;
    }

    public void setRightSceneUnitName(String rightSceneUnitName) {
        this.rightSceneUnitName = rightSceneUnitName;
    }

    public String getRightSceneUnitType() {
        return rightSceneUnitType;
    }

    public void setRightSceneUnitType(String rightSceneUnitType) {
        this.rightSceneUnitType = rightSceneUnitType;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }
}




