package Commands;
import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import CorePackage.BasicParser;

import java.util.*;

public class CmdRepeat implements Command{

    private int times;

    private List<Command> commandList = new LinkedList<>(); //perhaps not the most optimal solution but i'll see


    public CmdRepeat (Queue<String> context) throws InvalidArgumentException, MissingArgumentException {

        try {
            String token = context.remove();
            times = Integer.parseInt(token);
            Queue<String> commandTokensSequence = new LinkedList<>();



            if (times < 0)
                throw new InvalidArgumentException("Invalid parameter for command REPEAT (Expected: 0+; Provided: " + times + ";)");
            token = context.remove();
            if(!token.equals("["))
                throw new InvalidArgumentException("Invalid parameter for command REPEAT (Missing '[' )");
            token = context.remove();

            while (!token.equals("]")) {
                if (Objects.isNull(token))
                    throw new InvalidArgumentException("Invalid parameter for command REPEAT (Missing ']' )");
                commandTokensSequence.add(token);
                token = context.remove();
            }
            commandList.addAll(BasicParser.getParser().parseInstructions(commandTokensSequence));


        } catch (NoSuchElementException e1) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction REPEAT");
        }
        catch (NumberFormatException e2) {
            throw new InvalidArgumentException("SETPENSIZE","byte");
        }
    }


    @Override
    public void execute(MyPlane plane) {
        for (int i=0; i<times; i++) {
            commandList.stream().forEach(s-> s.execute(plane)); //A/N for testing phase: make sure the order of the cmds is respected. if not, maybe maybe we can review the data structures.

        }
    }
}
