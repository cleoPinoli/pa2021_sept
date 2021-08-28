package Commands;
import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdMoveCursorBwd implements Command {
    private int distance;


    public CmdMoveCursorBwd (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {
        try {
            String token = context.remove();      //or poll (returns null if q is empty)
            distance = Integer.parseInt(token);
            if (distance<0)
                throw new InvalidArgumentException("Invalid parameter for instruction BACKWARD (Expected: 0+; Provided: "+distance+ ";)");
        }
        catch (NoSuchElementException e1) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction BACKWARD");
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException("BACKWARD","int");
        }
    }
    @Override
    public void execute(MyPlane plane) {
        plane.moveCursor(distance, false);
    }
}
