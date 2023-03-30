//package com.xiaoruiit.algorithm.search;
//
///**
// * @author hanxiaorui
// * @date 2023/3/30
// */
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//public class Main {
//    public static void main(String[] args) {
//        List<UnitConversionFormula> unitConversionFormulaList = new ArrayList<UnitConversionFormula>();
//        UnitConversionFormula unitConversionFormula = new UnitConversionFormula();
//        unitConversionFormula.setLeftUnit("盒");
//        unitConversionFormula.setLeftValue(1);
//        unitConversionFormula.setRightUnit("小包");
//        unitConversionFormula.setRightValue(10000);
//        unitConversionFormulaList.add(unitConversionFormula);
//
//        UnitConversionFormula unitConversionFormula2 = new UnitConversionFormula();
//        unitConversionFormula2.setLeftUnit("包");
//        unitConversionFormula2.setLeftValue(1);
//        unitConversionFormula2.setRightUnit("小包");
//        unitConversionFormula2.setRightValue(100);
//        unitConversionFormulaList.add(unitConversionFormula2);
//
//        UnitConversionFormula unitConversionFormula3 = new UnitConversionFormula();
//        unitConversionFormula3.setLeftUnit("箱");
//        unitConversionFormula3.setLeftValue(1);
//        unitConversionFormula3.setRightUnit("包");
//        unitConversionFormula3.setRightValue(100);
//        unitConversionFormulaList.add(unitConversionFormula3);
//
//        SceneUnit sceneUnit = new SceneUnit();
//        sceneUnit.setStockUnit("包");
//        sceneUnit.setExternalUnit("盒");
//        sceneUnit.setPurchasUnit("箱");
//        sceneUnit.setDeductUnit("小包");
//        sceneUnit.setShippingUnit("包");
//
//        List<UnitConvertCoefficient> unitConvertCoefficients = getUnitConvertCoefficient(unitConversionFormulaList, sceneUnit);
//    }
//
//    private static List<UnitConvertCoefficient> getUnitConvertCoefficient(List<UnitConversionFormula> unitConversionFormulaList, SceneUnit sceneUnit) {
//    }
//}
//
//@Data
//class SceneUnit{
//    public String stockUnit;
//    public String externalUnit;//外部单位
//    public String purchasUnit;
//    public String deductUnit;// 扣料单位
//    public String shippingUnit;// 发货单位
//    public String skuCode;
//
//    private Map<String, Integer> unitMap;
//
//    public SceneUnit(){}
//}
//
//@Data
//class UnitConversionFormula {
//    public String leftUnit;
//    public Integer leftValue;
//    public String rightUnit;
//    public Integer rightValue;
//    public String skuCode;
//}
//
//@Data
//class UnitConvertCoefficient {
//    public String from;
//
//    public String to;
//
//    public BigDecimal coefficient;
//
//    public String skuCode;
//}
//
