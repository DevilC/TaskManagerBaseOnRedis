package taskPackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StepTag {
    /**
     * 步骤名称，同一个target中唯一
     * @return
     */
    String stepName();

    /**
     * 回滚步骤名称，默认为空
     */
    String rollbackStepName() default "";

    /**
     * 步骤顺序
     */
    int order();
    /**
     * 是否失败断点重试
     * @return
     */
    boolean canRetry() default false;

    /**
     * 是否支持回滚
     * @return
     */
    boolean canRollback() default false;

    /**
     * 是否失败自动回滚
     * @return
     */
    boolean autoRollback() default false;
}
