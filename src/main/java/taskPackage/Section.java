package taskPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Section {
    public Section(String sectionName, SectionType sectionType, int order) {
        this(sectionName, new ArrayList<Step>(), sectionType, order);
    }

    public Section(String sectionName, List<Step> steps, SectionType sectionType, int order) {
        this.sectionName = sectionName;
        this.steps = steps;
        this.sectionType = sectionType;
        this.order = order;
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

    /**
     * 执行顺序
     */
    int order;

    @Override
    public String toString(){
        return "{sectionName: " + this.sectionName + "; steps: " + this.steps + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Section)){
            return false;
        }
        Section sectionObj = (Section) obj;
        if (sectionObj.getSectionName().equals(this.sectionName)) {
            return true;
        }
        return false;
    }
}
