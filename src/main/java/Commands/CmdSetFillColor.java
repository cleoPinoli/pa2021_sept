package Commands;

import CorePackage.ColorRGB;
import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdSetFillColor extends BasicCommand {
    private int red;
    private int green;
    private int blue;



    public CmdSetFillColor (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {

        String token = "";
        try {
            token = context.remove();
            red = Integer.parseInt(token);
            token = context.remove();
            green = Integer.parseInt(token);
            token = context.remove();
            blue = Integer.parseInt(token);
            if (red < 0 || red > 255)
                throw new InvalidArgumentException(getName(), "Integer 0-255",Integer.toString(red));
            if (green < 0 || green > 255)
                throw new InvalidArgumentException(getName(), "Integer 0-255",Integer.toString(green));
            if (blue < 0 || blue > 255)
                throw new InvalidArgumentException(getName(), "Integer 0-255",Integer.toString(blue));
        }

        catch (NumberFormatException e2) {
            throw new InvalidArgumentException(getName(), "Integer", token);
        }
    }

    @Override
    public void execute(MyPlane plane) {
        plane.setAreaFillingColor(new ColorRGB(red, green, blue));
    }

    @Override
    public String getName() {
        return "SETFILLCOLOR";
    }
}
