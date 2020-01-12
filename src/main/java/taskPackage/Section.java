package taskPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Section {
    public Section(String sectionName, SectionType sectionType) {
        this(sectionName, new ArrayList<Step>(), sectionType);
    }

    public Section(String sectionName, List<Step> steps, SectionType sectionType) {
        this.sectionName = sectionName;
        this.steps = steps;
        this.sectionType = sectionType;
    }

    /**
     * 所在阶段类型，为INIT、EXECUTE、FINALLY
     */
    SectionType sectionType;

    /**
     * 阶段名，task作用域唯一
     */
    String sectionName;

    /**
     * 步骤列表
     */
    List<Step> steps;

    @Override
    public String toString(){
        return "{sectionName: " + this.sectionName + "; steps: " + this.steps + "}";
    }
}
