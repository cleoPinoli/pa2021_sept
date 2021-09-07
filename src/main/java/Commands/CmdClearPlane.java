package Commands;

import CorePackage.MyPlane;
import java.util.Queue;

public class CmdClearPlane implements Command {


    public CmdClearPlane (Queue<String> context)  {
    }

    public CmdClearPlane() {
        this(null);
    }
    @Override
    public void execute(MyPlane plane) {
        plane.clearPlane();
    }

    @Override
    public String getName() {
        return "CLEAR";
    }
}
