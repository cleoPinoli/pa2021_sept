package Commands;

import CorePackage.MyPlane;
import java.util.Queue;

public class CmdClearPlane implements Command {


    public CmdClearPlane (Queue<String> context)  {

    }


    @Override
    public void execute(MyPlane plane) {
        plane.clearPlane();
    }
}
