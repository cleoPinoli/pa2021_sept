package Commands;

import CorePackage.MyPlane;

public class CmdRotateLeft implements Command {
    private short angle;
    public CmdRotateLeft (short angle) {
        this.angle = angle;
    }

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
