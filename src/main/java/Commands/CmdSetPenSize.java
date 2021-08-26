package Commands;

import CorePackage.MyPlane;

public class CmdSetPenSize implements Command {

    private byte size;
    public CmdSetPenSize (byte size) {
        this.size = size;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setSize(size);
    }
}
