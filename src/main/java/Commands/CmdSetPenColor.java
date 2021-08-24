package Commands;
import CorePackage.ColorRGB;

public class CmdSetPenColor {
    private byte red;
    private byte green;
    private byte blue;

    public CmdSetPenColor (byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

}

