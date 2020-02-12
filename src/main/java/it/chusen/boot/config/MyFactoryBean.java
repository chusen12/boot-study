package it.chusen.boot.config;

import it.chusen.boot.model.req.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author chusen
 * @date 2020/1/23 23:52
 */
public class MyFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        return new Color("黄色");
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
