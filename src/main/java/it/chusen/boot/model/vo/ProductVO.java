package it.chusen.boot.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chusen
 * @date 2020/1/9 5:38 下午
 */
@Data
public class ProductVO {

        private Long id;
        private String prodName;
        private String model;
        private BigDecimal price;
        private String brandName;
}
