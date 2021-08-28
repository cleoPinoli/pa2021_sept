package Commands;

import CorePackage.ColorRGB;
import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdSetBackgroundColor implements Command  {

    private byte red;
    private byte green;
    private byte blue;



    public CmdSetBackgroundColor (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {
        try {
            String token = context.remove();
            red = Byte.parseByte(token);
            token = context.remove();
            green = Byte.parseByte(token);
            token = context.remove();
            blue = Byte.parseByte(token);
            if (red<0 || red >255)
                throw new InvalidArgumentException("Invalid parameter for instruction SETSCREENCOLOR:RED (Expected: 0-255; Provided: " +red);
            if (green<0 || green>255)
            throw new InvalidArgumentException("Invalid parameter for instruction SETSCREENCOLOR:GREEN (Expected: 0-255; Provided: " +green);
            if (blue<0 || blue>255)
            throw new InvalidArgumentException("Invalid parameter for instruction SETSCREENCOLOR:BLUE (Expected: 0-255; Provided: " +blue);
        }
        catch (NoSuchElementException e1) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction SETSCREENCOLOR");
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException("SETSCREENCOLOR", "byte");
        }
    }



    @Override
    public void execute(MyPlane plane) {
        plane.changeBackground(new ColorRGB(red, green, blue));
    }
}
