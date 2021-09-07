package Commands;

import CorePackage.MyPlane;
import java.util.Queue;

public class CmdHome extends BasicCommand  {

    public CmdHome (Queue<String> context) {

    }




    @Override
    public void execute(MyPlane plane) {
        plane.getMyCursor().setPosition(plane.getHome());
    }

    @Override
    public String getName() {
        return "HOME";
    }
}
