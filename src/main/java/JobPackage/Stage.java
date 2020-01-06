package JobPackage;

import lombok.Getter;
import lombok.Setter;
import resultPackage.StageResult;
import taskPackage.Section;

@Getter
@Setter
public class Stage {
    String stageID;

    Section section;

    StageResult stageResult;

    Status stageStatus;
}
