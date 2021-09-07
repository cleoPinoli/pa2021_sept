package Commands;

import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import java.util.Queue;

public class CmdRotateLeft extends BasicCommand { //CCW
    private int angle;


    public CmdRotateLeft (Queue<String> context) throws MissingArgumentException, InvalidArgumentException {
        String token = "";
        try {
            token = getNextToken(context);
            angle = Integer.parseInt(token);
            if (angle>360 || angle<0)
                throw new InvalidArgumentException(getName(), "Integer 0-360",Integer.toString(angle));
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException(getName(),"int", token);
        }

    }

    @Override
    public void execute(MyPlane plane) {
        plane.getMyCursor().changeDirection(-angle);
    }

    @Override
    public String getName() {
        return "LEFT";
    }
}
