package it.chusen.boot.annotate;

import org.aspectj.lang.annotation.Aspect;

import javax.annotation.Nullable;

/**
 * @author chusen
 * @date 2020/1/17 10:51 上午
 */
public class MyConfigurationSelector extends MyModeImportSelector<MyAnnotate> {

    @Nullable
    @Override
    protected String[] selectImports(MyMode model) {
        switch (model) {
            case CS:
                System.out.println("cs 牛逼！");
                break;
            case GXC:
                System.out.println("GXC垃圾");
                break;
            default:
                System.out.println("fff");
        }
        return new String[0];
    }
}
