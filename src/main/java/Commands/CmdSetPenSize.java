package Commands;

import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import java.util.Queue;

public class CmdSetPenSize extends BasicCommand {

    private byte size;
    public CmdSetPenSize (Queue<String> context) throws InvalidArgumentException, MissingArgumentException {

        String token = "";
        try {
            token = context.remove();
            size = Byte.parseByte(token);
            if (size < 1)
                throw new InvalidArgumentException(getName(), "1+", Integer.toString(size));
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException(getName(),"int", token);
        }
    }

    @Override
    public void execute(MyPlane plane) {
        plane.getMyCursor().setSize(size);
    }

    @Override
    public String getName() {
        return "SETPENSIZE";
    }
}
