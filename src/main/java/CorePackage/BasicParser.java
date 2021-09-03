package CorePackage;

import Commands.*;
import Exceptions.ParsingException;
import java.util.*;


/**
 * Class that implements a basic parser that can recognize if certain
 * strings are associated to a command of type Command.
 * If so, the associated Command objects is instantiated.
 *
 * @author claudia.raffaelli@studenti.unicam.it
 */
public class BasicParser {

    private Map<String, CheckedFunction<Queue<String>, Command>> commandsMap;
    private static BasicParser basicParser;


    /**
     * Class constructor.
     */
    private BasicParser() {
        commandsMap = new HashMap<>();

        registerCommand("FORWARD", CmdMoveCursorFwd::new);
        registerCommand("BACKWARD", CmdMoveCursorBwd::new);
        registerCommand("RIGHT", CmdRotateRight::new);
        registerCommand("LEFT", CmdRotateLeft::new);
        registerCommand("PENUP", CmdPenUp::new);
        registerCommand("PENDOWN", CmdPenDown::new);
        registerCommand("HOME", CmdHome::new);
        registerCommand("REPEAT", CmdRepeat::new);
        registerCommand("SETFILLCOLOR", CmdSetFillColor::new);
        registerCommand("SETPENCOLOR", CmdSetPenColor::new);
        registerCommand("SETSCREENCOLOR", CmdSetBackgroundColor::new);
        registerCommand("SETPENSIZE", CmdSetPenSize::new);
        registerCommand("CLEARSCREEN", CmdClearPlane::new);
    }


    public static BasicParser getParser() {
        if (Objects.isNull(basicParser)) {
            basicParser = new BasicParser();
        }
        return basicParser;
    }
    /**
     * Method called to register new commands.
     *
     * @param keyword a name suggesting the command's purpose
     * @param function the function in charge of creating the new Command command.
     */
    public void registerCommand (String keyword, CheckedFunction<Queue<String>, Command> function) {
            commandsMap.put(keyword, function);
    }


    /**
     * Instructions parser taking instructions from a file.
     *
     * @param path the file's location
     * @return a list of identified commands
     */
    public List<Command> parseInstructions(String path) {
        Queue<String> instructionsList = FileReader.readFile(path);
        return parseInstructions(instructionsList);
    }

    /**
     * Instructions parser taking instructions from a given queue.
     *
     * @param instructions a queue of strings to be examined
     * @return a list of identified commands
     */
    public List<Command> parseInstructions(Queue<String> instructions) {
        List<Command> commandList = new LinkedList<>();
        try {
            while (!instructions.isEmpty()) {
                String token = instructions.remove();
                if (commandsMap.containsKey(token)) {
                    CheckedFunction<Queue<String>, Command> myFunction = commandsMap.get(token);
                    commandList.add(myFunction.apply(instructions) );
                }
            }
        } catch (ParsingException e) {
            System.out.println(e.getMessage());
        }
      return commandList;
    }


}
