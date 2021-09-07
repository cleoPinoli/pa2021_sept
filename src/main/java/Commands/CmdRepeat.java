package Commands;
import CorePackage.MyPlane;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import CorePackage.BasicParser;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;


public class CmdRepeat extends BasicCommand {

    private int times;

    private List<Command> commandList = new LinkedList<>(); //perhaps not the most optimal solution but i'll see


    public CmdRepeat (Queue<String> context) throws InvalidArgumentException, MissingArgumentException {
        String token = "";
        try {
            token = getNextToken(context);
            times = Integer.parseInt(token);
            Queue<String> commandTokensSequence = new LinkedList<>();



            if (times < 0)
                throw new InvalidArgumentException(getName(), "Positive int", Integer.toString(times));
            token = getNextToken(context);
            if(!token.equals("["))
                throw new InvalidArgumentException(getName(), "[", token);
            token = getNextToken(context);

            while (!token.equals("]")) {
                if (Objects.isNull(token)) //TODO test this
                    throw new InvalidArgumentException(getName(), "]", token);
                commandTokensSequence.add(token);
                token = context.remove();
            }
            commandList.addAll(BasicParser.getParser().parseInstructions(commandTokensSequence));


        }catch (NumberFormatException e2) {
            throw new InvalidArgumentException(getName(),"int", token);
        }
    }


    @Override
    public void execute(MyPlane plane) {
        for (int i=0; i<times; i++) {
            commandList.stream().forEach(s-> s.execute(plane)); //A/N for testing phase: make sure the order of the cmds is respected. if not, maybe maybe we can review the data structures.

        }
    }

    @Override
    public String getName() {
        return "REPEAT";
    }
}
