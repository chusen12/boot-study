package it.chusen.boot.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author chusen
 */
@AllArgsConstructor
@Data
public class PageListMapResult implements Serializable {
    private List<Map<String,Object>> list;
    private int pageNo;
    private int pageSize;
    private Long totalNumber;
}