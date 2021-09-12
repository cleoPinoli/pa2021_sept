package Commands;
import CorePackage.MyPlane;
import CorePackage.Program;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import CorePackage.BasicParser;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;


public class CmdRepeat extends BasicCommand {

    private int times;

    private Program program; //perhaps not the most optimal solution but i'll see

    private List<Command> children;

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
            program = new Program(BasicParser.getParser().parseInstructions(commandTokensSequence));
            //children = new LinkedList<>();
            //children.addAll(BasicParser.getParser().parseInstructions(commandTokensSequence));


        }catch (NumberFormatException e2) {
            throw new InvalidArgumentException(getName(),"int", token);
        }
    }


    @Override
    public void execute(MyPlane plane) {
       System.out.println(times);
        for (int i=0; i<times; i++) {
            program.execute(plane);
            }
       //
            //children.stream().forEach(c -> c.execute(plane));

        //}
    }

    @Override
    public String getName() {
        return "REPEAT";
    }
}
