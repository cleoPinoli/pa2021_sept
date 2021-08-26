package Commands;

import CorePackage.MyPlane;

public class CmdRotateRight implements Command  {
    private short angle;
    public CmdRotateRight (short angle) { this.angle = angle; }

    public short getAngle() {
        return angle;
    }

    public void setAngle(short angle) {
        this.angle = angle;
    }

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setDirection(angle);
    }
}
