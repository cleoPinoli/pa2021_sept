package CorePackage;

import Commands.BasicCommand;
import Commands.Command;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;

import java.util.*;

/**
 * Class container that can contain both leaves and other containers;
 *
 * @author claudia.raffaelli@studenti.unicam.it
 */
public class Program extends BasicCommand {

    private List<Command> children;

    private int nextInstruction;
    private int times;

    public Program () {
        this(new ArrayList<>());
    }


    public Program(List<Command> commands){
        times = 1;
        children = commands; // deep copy?
        nextInstruction = 0;
    }

    public Program (Queue<String> context) throws InvalidArgumentException, MissingArgumentException {
        String token = "";
        children = new LinkedList<>();
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
            children.addAll(BasicParser.getParser().parseInstructions(commandTokensSequence));


        }catch (NumberFormatException e2) {
            throw new InvalidArgumentException(getName(),"int", token);
        }
    }



    public void runNextInstruction (MyPlane plane) {
        if (nextInstruction<children.size()) {
        System.out.println("Executing: " +children.get(nextInstruction).getName());
        children.get(nextInstruction++).execute(plane);

        }
    }


    public void runFrom (MyPlane plane, int fromIndex){
        for (int i=fromIndex; i<children.size(); i++) {
            runNextInstruction(plane);

        }
        nextInstruction = children.size();
    }

    public void runFrom (MyPlane plane) {
        runFrom(plane, nextInstruction);
    }

    public List<Command> getChildren() { return children; }

    public void resetProgram () {
        nextInstruction = 0;
    }

    public void add (Command cmd) {
        children.add(cmd);
    }

    public void remove (Command cmd) {
        children.remove(cmd);
    }

    @Override
    public void execute(MyPlane plane) {

        for (int i=0; i<times; i++) {
            runFrom(plane, 0);
            resetProgram();
        }


    }

    @Override
    public String getName() {
        return "REPEAT";
    }
}
