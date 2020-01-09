package it.chusen.boot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chusen
 * @date 2020-01-09 14:08:33
 */
@Data
@Entity
@Table(name = "pm_brand")
public class PmBrandEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "brand_name", columnDefinition = "varchar")
    private String brandName;

}
