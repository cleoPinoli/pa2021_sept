package Commands;

public class CmdSetFillColor {
    private byte red;
    private byte green;
    private byte blue;

    public CmdSetFillColor (byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
