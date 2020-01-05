package taskPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Section {
    /**
     * 阶段名，task作用域唯一
     */
    String sectionName;

    /**
     * 步骤列表
     */
    List<Step> steps;
}
