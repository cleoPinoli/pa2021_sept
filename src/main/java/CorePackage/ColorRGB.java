package CorePackage;

/**
 * Class representing a color in RGB code 0-255.
 *
 * @author claudia.raffaelli@studenti.unicam.it
 */
public class ColorRGB {

    private int red, green, blue;

    public ColorRGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    } //TODO check invalid parameters

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }


}
