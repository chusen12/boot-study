package it.chusen.boot.service;

import it.chusen.annotation.MyAnnotation;
import it.chusen.boot.map.MyMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author chusen
 * @date 2020/1/17 5:12 下午
 */
@Service
public class AutoImportService {



    @Resource
//    private Map<Integer, MyMap> testMap;

    private List<MyMap> testList;


    @MyAnnotation(name = MyAnnotation.MyType.GXC)
    public void test() {
        System.out.println("this is test method!");
//        for (Map.Entry<Integer, MyMap> entry : testMap.entrySet()) {
//
//            System.out.println(entry.getKey()+":" + entry.getValue());
//        }
        for (MyMap myMap : testList) {
            System.out.println(myMap);
        }
    }

}
