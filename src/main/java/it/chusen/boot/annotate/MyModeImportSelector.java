package it.chusen.boot.annotate;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;

import javax.annotation.Nullable;
import java.lang.annotation.Annotation;

/**
 * @author chusen
 * @date 2020/1/17 11:04 上午
 */
public abstract class MyModeImportSelector<A extends Annotation> implements ImportSelector {


    @Override
    public final String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Class<?> annType = GenericTypeResolver.resolveTypeArgument(getClass(), MyModeImportSelector.class);
        Assert.state(annType != null, "Unresolvable type argument for AdviceModeImportSelector");
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(annType.getName(), false));
        if (attributes == null) {
            throw new IllegalArgumentException(String.format(
                    "@%s is not present on importing class '%s' as expected",
                    annType.getSimpleName(), importingClassMetadata.getClassName()));
        }

        MyMode name = attributes.getEnum("name");
        selectImports(name);
        return new String[0];
    }


    @Nullable
    protected abstract String[] selectImports(MyMode model);

}
