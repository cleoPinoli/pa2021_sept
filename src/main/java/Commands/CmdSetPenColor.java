package Commands;
import CorePackage.ColorRGB;
import CorePackage.MyPlane;

public class CmdSetPenColor implements Command {
    private byte red;
    private byte green;
    private byte blue;

    public CmdSetPenColor (byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public byte getRed() {
        return red;
    }

    public void setRed(byte red) {
        this.red = red;
    }

    public byte getGreen() {
        return green;
    }

    public void setGreen(byte green) {
        this.green = green;
    }

    public byte getBlue() {
        return blue;
    }

    public void setBlue(byte blue) {
        this.blue = blue;
    }

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setLineColor(new ColorRGB(red, green, blue));
    }
}

