package Commands;

import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdRotateRight extends BasicCommand  { //CW
    private int angle;



    public CmdRotateRight (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {
        try {
            String token = getNextToken(context);     //or poll (returns null if q is empty)
            angle = Integer.parseInt(token);
            if (angle>360 || angle<0)
                throw new InvalidArgumentException("Invalid parameter for instruction RIGHT (Expected: 0-360); Provided: " +angle+ ";)");
        }
        catch (NoSuchElementException e1) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction RIGHT");
        }

    }

    @Override
    public void execute(MyPlane plane) {
        plane.getMyCursor().changeDirection(angle);
    }

    @Override
    public String getName() {
        return "RIGHT";
    }
}
