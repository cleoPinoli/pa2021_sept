package CorePackage;

/**
 * Class representing a color in RGB code 0-255.
 *
 * @author claudia.raffaelli@studenti.unicam.it
 */
public class ColorRGB {

    private byte red, green, blue;

    public ColorRGB(byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    } //TODO check invalid parameters

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


}
