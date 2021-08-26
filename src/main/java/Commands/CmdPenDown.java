package Commands;

import CorePackage.MyPlane;

public class CmdPenDown implements Command  {

    public CmdPenDown () { }

    @Override
    public void execute(MyPlane plane) {
      plane.getCursor().setPlot(true);
    }
}

