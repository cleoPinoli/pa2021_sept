package Commands;

import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class CmdSetPenSize implements Command {

    private byte size;
    public CmdSetPenSize (Queue<String> context) throws InvalidArgumentException, MissingArgumentException {
        try {
            String token = context.remove();
            size = Byte.parseByte(token);
            if (size < 1)
                throw new InvalidArgumentException("Invalid parameter for command SETPENSIZE (Expected: 1+; Provided: " + size + ";)");
        } catch (NoSuchElementException e1) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction SETPENSIZE");
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException("SETPENSIZE","byte"); //TODO this can be generalized
        }
    }

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setSize(size);
    }
}
