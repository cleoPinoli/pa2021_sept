package Commands;

import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.InvalidTokenException;
import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdMoveCursorFwd extends BasicCommand  {
    private int distance;

    public CmdMoveCursorFwd (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {
        String token = "";
        try {
            token = getNextToken(context);
            distance = Integer.parseInt(token);
            if (distance<0)
                throw new InvalidArgumentException("Invalid parameter for instruction FORWARD (Expected: 0+; Provided: "+distance+ ";)");
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException(getName(),"int", token);
        }
    }

    @Override
    public void execute(MyPlane plane) {
        plane.moveCursor(distance, true);
    }

    @Override
    public String getName() {
        return "FORWARD";
    }
}
