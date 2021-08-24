package Commands;

public class CmdSetBackgroundColor {

    private byte red;
    private byte green;
    private byte blue;

    public CmdSetBackgroundColor (byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
