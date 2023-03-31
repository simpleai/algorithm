package com.xiaoruiit.algorithm.search.unit;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author hanxiaorui
 * @date 2023/3/31
 */
@Data
public class MaterialDto {

    /**
     * 物料编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 单位场景
     */
    private List<SceneUnit> sceneUnits;

    /**
     * 单位换算
     */
    private List<MaterialUnitConversionDto> unitConversions;

    @Data
    public static class SceneUnit {

        private String unitName;

        private String unitType;

        public static enum PlatformEnum {
            STOCK("STOCK", "库存单位"),
            PLATFORM_DJ("PLATFORM_DJ", "外部单位"),
            PURCHASE("PURCHASE", "采购单位"),
            SELL("SELL", "扣料单位"),
            SEND_OUT("SEND_OUT", "发货单位"),
            ;

            private String value;
            private String describing;

            public String getValue() {
                return this.value;
            }

            public String getDescribing() {
                return this.describing;
            }

            PlatformEnum(String value, String describing) {
                this.value = value;
                this.describing = describing;
            }

            public static SceneUnit.PlatformEnum parse(Integer value) {
                if (value == null) {
                    return null;
                } else {
                    SceneUnit.PlatformEnum[] var1 = values();
                    int var2 = var1.length;

                    for(int var3 = 0; var3 < var2; ++var3) {
                        SceneUnit.PlatformEnum typeEnum = var1[var3];
                        if (Objects.equals(typeEnum.value, value)) {
                            return typeEnum;
                        }
                    }

                    return null;
                }
            }
        }
    }

    @Data
    public static class MaterialUnitConversionDto {
        /**
         * 等式左侧单位名称
         */
        private String leftUnit;

        /**
         * 等式右侧单位名称
         */
        private String rightUnit;

        /**
         * 等式左侧换算数量
         */
        private BigDecimal leftAmount;

        /**
         * 等式右侧换算数量
         */
        private BigDecimal rightAmount;

        private Boolean deleted;
    }
}
