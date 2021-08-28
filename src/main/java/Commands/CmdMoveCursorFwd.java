package Commands;

import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.InvalidTokenException;
import Exceptions.MissingArgumentException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdMoveCursorFwd implements Command  {
    private int distance;

    public CmdMoveCursorFwd (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {
        try {
            String token = context.remove();      //or poll (returns null if q is empty)
            distance = Integer.parseInt(token);
            if (distance<0)
                throw new InvalidArgumentException("Invalid parameter for instruction FORWARD (Expected: 0+; Provided: "+distance+ ";)");
        }
        catch (NoSuchElementException e1) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction FORWARD");
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException("FORWARD", "int");
        }
    }

    @Override
    public void execute(MyPlane plane) {
        plane.moveCursor(distance, true);
    }
}
