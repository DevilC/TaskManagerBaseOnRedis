package JobPackage;

import lombok.Getter;
import lombok.Setter;
import resultPackage.ActionResult;
import taskPackage.Step;

@Getter
@Setter
public class Action {
    Step step;

    String actionID;

    Status actionStatus;

    ActionResult actionResult;

    @Override
    public boolean equals(Object item){
        if(!(item instanceof Action)){
            return false;
        }
        return this.actionID.equals(((Action) item).getActionID());
    }

    @Override
    public String toString(){
        return "Action:[actionID: " + this.actionID + "; step: " + this.step + "; actionStatus: " + this.actionStatus + "; actionResult: " + this.actionResult;
    }
}
