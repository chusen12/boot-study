package it.chusen.boot.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chusen
 * @date 2020/1/9 4:57 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    List<T> list;
    private int pageNo;
    private int pageSize;
    private Long totalNumber;
}
