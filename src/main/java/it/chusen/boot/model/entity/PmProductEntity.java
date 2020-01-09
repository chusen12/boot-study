package it.chusen.boot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author chusen
 * @date 2019-12-30 20:51:20
 */
@Data
@Entity
@Table(name = "pm_product")
public class PmProductEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id" ,columnDefinition= "bigint" )
	private Long id;

	@Column(name = "prod_name" ,columnDefinition= "varchar" )
	private String prodName;

	@Column(name = "model" ,columnDefinition= "varchar" )
	private String model;

	@Column(name = "price" ,columnDefinition= "decimal" )
	private BigDecimal price;

	@Column(name = "brand_id" ,columnDefinition= "bigint" )
	private Long brandId;

}
