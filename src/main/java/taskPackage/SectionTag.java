package taskPackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SectionTag {
    /**
     * 所在阶段名称
     * @return
     */
    String sectionName();

    /**
     * 执行顺序
     */
    int order();

    /**
     * 所在阶段类型，为INIT、EXECUTE、FINALLY
     * @return
     */
    SectionType sectionType();
}
