package Commands;

import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdRotateRight implements Command  { //CW
    private int angle;



    public CmdRotateRight (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {
        try {
            String token = context.remove();      //or poll (returns null if q is empty)
            angle = Integer.parseInt(token);
            if (angle>360 || angle<0)
                throw new InvalidArgumentException("Invalid parameter for instruction RIGHT (Expected: 0-360); Provided: " +angle+ ";)");
        }
        catch (NoSuchElementException e1) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction RIGHT");
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException("LEFT","int");
        }
    }

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().changeDirection(angle);
    }
}
